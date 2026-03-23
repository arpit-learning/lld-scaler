package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public interface ILearnerExamController {
  ResponseEntity<@NonNull ResponseDto<StartExamResponseDto>> startExam(StartExamRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<SubmitExamResponseDto>> submitExam(SubmitExamRequestDto requestDto);
}
