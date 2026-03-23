package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.QuestionResponseDto;
import dev.arpit.scaler.models.Question;

public class QuestionDTOs {
  public static QuestionResponseDto getQuestionResponseDto(Question question) {
    return new QuestionResponseDto(
        question.getId(),
        question.getName(),
        question.getDescription(),
        OptionDTOs.getOptionsResponseDto(question.getOptions()),
        OptionDTOs.getOptionResponseDto(question.getCorrectOption()),
        question.getScore()
    );
  }
}
