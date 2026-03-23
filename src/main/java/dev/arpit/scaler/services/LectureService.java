package dev.arpit.scaler.services;

import dev.arpit.scaler.models.Lecture;
import dev.arpit.scaler.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService implements ILectureService {
  @Autowired
  private LectureRepository lectureRepository;

  @Override
  public List<Lecture> findAllById (List<Long> lectureIds) {
    return lectureRepository.findAllById(lectureIds);
  }
}
