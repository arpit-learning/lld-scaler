package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.LearnerExamResponseDto;
import dev.arpit.scaler.dtos.StartExamResponseDto;
import dev.arpit.scaler.dtos.SubmitExamResponseDto;
import dev.arpit.scaler.models.LearnerExam;

public class LearnerExamDTOs {
  public static StartExamResponseDto getStartExamResponseDto(LearnerExam learnerExam) {
    return new StartExamResponseDto(
        LearnerExamDTOs.getLearnerExamResponseDto(learnerExam)
    );
  }

  public static SubmitExamResponseDto getSubmitExamResponseDto(LearnerExam learnerExam) {
    return new SubmitExamResponseDto(
        LearnerExamDTOs.getLearnerExamResponseDto(learnerExam)
    );
  }

  public static LearnerExamResponseDto getLearnerExamResponseDto(LearnerExam learnerExam) {
    return new LearnerExamResponseDto(
        learnerExam.getId(),
        LearnerDTOs.getLearnerResponseDto(learnerExam.getLearner()),
        ExamDTOs.getExamResponseDto(learnerExam.getExam()),
        learnerExam.getStartedAt().toString(),
        learnerExam.getEndedAt().toString(),
        learnerExam.getStatus().toString()
    );
  }
}
