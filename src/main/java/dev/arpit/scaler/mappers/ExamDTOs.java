package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.ExamResponseDto;
import dev.arpit.scaler.models.Exam;

public class ExamDTOs {
  public static ExamResponseDto getExamResponseDto(Exam exam) {
    return new ExamResponseDto(
        exam.getId(),
        exam.getName(),
        exam.getTotalScore()
    );
  }
}
