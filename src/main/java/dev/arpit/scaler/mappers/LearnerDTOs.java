package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.LearnerResponseDto;
import dev.arpit.scaler.models.Learner;

public class LearnerDTOs {
  public static LearnerResponseDto getLearnerResponseDto(Learner learner) {
    return new LearnerResponseDto(
        learner.getId(),
        learner.getName(),
        learner.getEmail(),
        learner.getMobile()
    );
  }
}
