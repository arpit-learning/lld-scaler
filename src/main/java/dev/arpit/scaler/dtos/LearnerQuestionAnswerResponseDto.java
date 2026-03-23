package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LearnerQuestionAnswerResponseDto {
  private long id;
  private LearnerResponseDto learner;
  private QuestionResponseDto question;
  private OptionResponseDto option;
}
