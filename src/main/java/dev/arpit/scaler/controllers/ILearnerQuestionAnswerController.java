package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.AnswerQuestionRequestDto;
import dev.arpit.scaler.dtos.AnswerQuestionResponseDto;
import dev.arpit.scaler.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface ILearnerQuestionAnswerController {
  ResponseEntity<@NonNull ResponseDto<AnswerQuestionResponseDto>> answerQuestion(AnswerQuestionRequestDto requestDto);
}
