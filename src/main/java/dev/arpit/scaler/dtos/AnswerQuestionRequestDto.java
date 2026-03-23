package dev.arpit.scaler.dtos;

import lombok.Data;

@Data
public class AnswerQuestionRequestDto {
    private Long learnerId;
    private Long examId;
    private Long questionId;
    private Long optionId;
}
