package dev.arpit.scaler.services;

import dev.arpit.scaler.models.BatchLearner;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.ScheduledLecture;
import dev.arpit.scaler.repositories.ScheduledLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
