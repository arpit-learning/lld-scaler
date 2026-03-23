package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidScheduledLectureIdException;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.ScheduledLecture;

import java.util.List;

public interface IScheduledLectureService {
  List<ScheduledLecture> fetchTimeline(Learner learner);
  List<ScheduledLecture> rescheduleScheduledLecture(long scheduledLectureId) throws InvalidScheduledLectureIdException;
  ScheduledLecture findById(long scheduledLectureId) throws InvalidScheduledLectureIdException;
  List<ScheduledLecture> saveAll(List<ScheduledLecture> scheduledLectures);
}
