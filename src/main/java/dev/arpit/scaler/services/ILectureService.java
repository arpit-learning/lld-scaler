package dev.arpit.scaler.services;

import dev.arpit.scaler.models.Lecture;

import java.util.List;

public interface ILectureService {
  List<Lecture> findAllById (List<Long> lectureIds);
}
