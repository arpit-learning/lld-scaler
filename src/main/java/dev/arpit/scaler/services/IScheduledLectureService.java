package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidScheduledLectureException;
import dev.arpit.scaler.exceptions.InvalidScheduledLectureIdException;
import dev.arpit.scaler.models.*;

import java.util.List;

public interface IScheduledLectureService {
  List<ScheduledLecture> fetchTimeline(Learner learner);
  List<ScheduledLecture> rescheduleScheduledLecture(long scheduledLectureId) throws InvalidScheduledLectureIdException;
  ScheduledLecture findById(long scheduledLectureId) throws InvalidScheduledLectureIdException;
  List<ScheduledLecture> saveAll(List<ScheduledLecture> scheduledLectures);
  List<ScheduledLecture> scheduleLectures(List<Lecture> lectures, Instructor instructor, Batch batch) throws InvalidScheduledLectureException;
}
