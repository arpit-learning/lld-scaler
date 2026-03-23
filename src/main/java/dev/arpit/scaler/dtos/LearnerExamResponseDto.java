package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LearnerExamResponseDto {
  private long id;
  private LearnerResponseDto learner;
  private ExamResponseDto exam;
  private String startedAt;
  private String endedAt;
  private String status;
}
