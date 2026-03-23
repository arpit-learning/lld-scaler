package dev.arpit.scaler.services;

import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.ScheduledLecture;

import java.util.List;

public interface IScheduledLectureService {
  List<ScheduledLecture> fetchTimeline(Learner learner);
}
