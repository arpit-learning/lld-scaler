package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.LectureResponseDto;
import dev.arpit.scaler.models.Lecture;

public class LectureDTOs {
  public static LectureResponseDto getLectureResponseDto(Lecture lecture) {
    return new LectureResponseDto(
        lecture.getId(),
        lecture.getName(),
        lecture.getDescription()
    );
  }
}
