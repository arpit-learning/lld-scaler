package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidScheduledLectureIdException;
import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.BatchLearner;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.ScheduledLecture;
import dev.arpit.scaler.repositories.ScheduledLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduledLectureService implements IScheduledLectureService {
  @Autowired
  private IBatchLearnerService iBatchLearnerService;
  @Autowired
  private ScheduledLectureRepository scheduledLectureRepository;

  @Override
  public List<ScheduledLecture> fetchTimeline(Learner learner) {
    List<BatchLearner> batchLearners = iBatchLearnerService.findAllByLearner(learner);

    List<ScheduledLecture> scheduledLectures = new ArrayList<>();
    for(BatchLearner batchLearner : batchLearners) {
      scheduledLectures.addAll(
          scheduledLectureRepository.findAllByBatch(batchLearner.getBatch())
              .stream()
              .filter(scheduledLecture ->
                  scheduledLecture.getStartTime().isAfter(batchLearner.getEntryDate()) &&
                      (batchLearner.getExitDate() == null || scheduledLecture.getEndTime().isBefore(batchLearner.getExitDate()))
              )
              .toList()
      );
    }

    return scheduledLectures;
  }

  @Override
  public List<ScheduledLecture> rescheduleScheduledLecture (long scheduledLectureId) throws InvalidScheduledLectureIdException {
    ScheduledLecture scheduledLecture = this.findById(scheduledLectureId);
    Batch batch = scheduledLecture.getBatch();
    List<ScheduledLecture> scheduledLectures = scheduledLectureRepository
        .findAllByBatch(batch)
        .stream()
        .filter(i -> i.getId() == scheduledLectureId || i.getStartTime().isAfter(scheduledLecture.getStartTime()))
        .toList();

    scheduledLectures.forEach(i -> i.setStartTime(getNextStartTime(i.getStartTime())));
    return this.saveAll(scheduledLectures);
  }

  @Override
  public ScheduledLecture findById (long scheduledLectureId) throws InvalidScheduledLectureIdException {
    return scheduledLectureRepository
        .findById(scheduledLectureId)
        .orElseThrow(() ->
            new InvalidScheduledLectureIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid Scheduled Lecture Id",
                "Invalid Scheduled Lecture Id"
            )
        );
  }

  @Override
  public List<ScheduledLecture> saveAll (List<ScheduledLecture> scheduledLectures) {
    return scheduledLectureRepository.saveAll(scheduledLectures);
  }

  private LocalDateTime getNextStartTime(LocalDateTime startTime) {
    DayOfWeek initialDayOfWeek = startTime.toLocalDate().getDayOfWeek();
    LocalDateTime result = startTime.plusDays(2);

    if (new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)).contains(initialDayOfWeek)) {
      result.plusDays(1);
    }

    return result;
  }
}
