package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidScheduledLectureException;
import dev.arpit.scaler.exceptions.InvalidScheduledLectureIdException;
import dev.arpit.scaler.models.*;
import dev.arpit.scaler.repositories.ScheduledLectureRepository;
import dev.arpit.scaler.utils.DronaUtils;
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

  @Override
  public List<ScheduledLecture> scheduleLectures (List<Lecture> lectures, Instructor instructor, Batch batch) throws InvalidScheduledLectureException {

    List<ScheduledLecture> scheduledLectures = new ArrayList<>();
    for(Lecture lecture: lectures) {
      LocalDateTime nextStartTime = getNextStartTime(batch.getSchedule());

      if(nextStartTime == null) {
        throw new InvalidScheduledLectureException(
            ResponseCode.SCALER_FAILURE_400,
            "Could not get next start time from the schedule of the batch",
            "Could not get next start time from the schedule of the batch"
        );
      }

      scheduledLectures.add(
          new ScheduledLecture(
              "Scheduled " + lecture.getName(),
              lecture,
              batch,
              instructor,
              nextStartTime,
              getNextEndTime(nextStartTime),
              DronaUtils.generateUniqueLectureLink(),
              ScheduledLectureStatus.SCHEDULED
          )
      );
    }

    return scheduledLectureRepository.saveAll(scheduledLectures);
  }

  @Override
  public ScheduledLecture save (ScheduledLecture scheduledLecture) {
    return scheduledLectureRepository.save(scheduledLecture);
  }

  private LocalDateTime getNextStartTime(Schedule schedule) {
    LocalDateTime datetime = LocalDateTime.now();

    List<DayOfWeek> mwfDays = new ArrayList<>(List.of(
        DayOfWeek.MONDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.FRIDAY
    ));
    List<DayOfWeek> ttsDays = new ArrayList<>(List.of(
        DayOfWeek.TUESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.SATURDAY
    ));

    switch (schedule) {
      case MWF_MORNING:
        datetime.withHour(7);
        datetime.withMinute(0);
        datetime.withSecond(0);
        // set next coming m or w or f
        while(
            !mwfDays.contains(datetime.getDayOfWeek())
        ) {
          datetime.plusDays(1);
        }
        return datetime;
      case MWF_EVENING:
        datetime.withHour(21);
        datetime.withMinute(0);
        datetime.withSecond(0);
        // set next coming m or w or f
        while(
            !mwfDays.contains(datetime.getDayOfWeek())
        ) {
          datetime.plusDays(1);
        }
        return datetime;
      case TTS_MORNING:
        datetime.withHour(7);
        datetime.withMinute(0);
        datetime.withSecond(0);
        // set next coming t or t or s
        while(
            !ttsDays.contains(datetime.getDayOfWeek())
        ) {
          datetime.plusDays(1);
        }
        return datetime;
      case TTS_EVENING:
        datetime.withHour(21);
        datetime.withMinute(0);
        datetime.withSecond(0);
        // set next coming t or t or s
        while(
            !ttsDays.contains(datetime.getDayOfWeek())
        ) {
          datetime.plusDays(1);
        }
        return datetime;
      default:
        return null;
    }
  }

  private LocalDateTime getNextStartTime(LocalDateTime startTime) {
    DayOfWeek initialDayOfWeek = startTime.toLocalDate().getDayOfWeek();
    LocalDateTime result = startTime.plusDays(2);

    if (new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)).contains(initialDayOfWeek)) {
      result.plusDays(1);
    }

    return result;
  }

  private LocalDateTime getNextEndTime(LocalDateTime startTime) {
    return startTime.plusHours(2).plusMinutes(30);
  }
}
