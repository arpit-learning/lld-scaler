package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.*;
import dev.arpit.scaler.models.LearnerQuestionAnswer;

public class LearnerQuestionAnswerDTOs {
  public static AnswerQuestionResponseDto getAnswerQuestionResponseDto(LearnerQuestionAnswer learnerQuestionAnswer) {
    return new AnswerQuestionResponseDto(
        LearnerQuestionAnswerDTOs.getLearnerQuestionAnswerResponseDto(learnerQuestionAnswer)
    );
  }

  public static LearnerQuestionAnswerResponseDto getLearnerQuestionAnswerResponseDto(LearnerQuestionAnswer learnerQuestionAnswer) {
    return new LearnerQuestionAnswerResponseDto(
      learnerQuestionAnswer.getId(),
      LearnerDTOs.getLearnerResponseDto(learnerQuestionAnswer.getLearner()),
      QuestionDTOs.getQuestionResponseDto(learnerQuestionAnswer.getQuestion()),
      OptionDTOs.getOptionResponseDto(learnerQuestionAnswer.getOption())
    );
  }
}
