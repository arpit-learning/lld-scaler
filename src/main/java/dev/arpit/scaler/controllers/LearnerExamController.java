package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import dev.arpit.scaler.exceptions.BaseException;
import dev.arpit.scaler.mappers.LearnerExamDTOs;
import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.services.IExamService;
import dev.arpit.scaler.services.ILearnerExamService;
import dev.arpit.scaler.services.ILearnerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LearnerExamController implements ILearnerExamController {
  @Autowired
  private ILearnerExamService iLearnerExamService;
  @Autowired
  private ILearnerService iLearnerService;
  @Autowired
  private IExamService iExamService;

  @Override
  @PostMapping(Endpoints.v1ExamStart)
  public ResponseEntity<@NonNull ResponseDto<StartExamResponseDto>> startExam(StartExamRequestDto requestDto) {
    ResponseDto<StartExamResponseDto> responseDto = new ResponseDto<>();

    try {
      long learnerId = requestDto.getLearnerId();
      long examId = requestDto.getExamId();
      Learner learner = iLearnerService.findById(learnerId);
      Exam exam = iExamService.findById(examId);
      responseDto.setData(LearnerExamDTOs.getStartExamResponseDto(iLearnerExamService.startExam(learner, exam)));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.SCALER_SUCCESS_200,
              "Exam started for user successfully",
              "Exam started for user successfully",
              null,
              null
          )
      );

      return ResponseEntity.ok(responseDto);
    } catch (BaseException e) {
      responseDto.setMeta(
          new MetaDataDto(
              e.getCode(),
              e.getMessage(),
              e.getDisplayMessage(),
              null,
              null
          )
      );

      ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
      return bodyBuilder.body(responseDto);
    }
  }

  @Override
  @PostMapping(Endpoints.v1ExamSubmit)
  public ResponseEntity<@NonNull ResponseDto<SubmitExamResponseDto>> submitExam(SubmitExamRequestDto requestDto) {
    ResponseDto<SubmitExamResponseDto> responseDto = new ResponseDto<>();

    try {
      long learnerId = requestDto.getLearnerId();
      long examId = requestDto.getExamId();
      Learner learner = iLearnerService.findById(learnerId);
      Exam exam = iExamService.findById(examId);
      responseDto.setData(LearnerExamDTOs.getSubmitExamResponseDto(iLearnerExamService.submitExam(learner, exam)));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.SCALER_SUCCESS_200,
              "Exam submitted successfully for user",
              "Exam submitted successfully for user",
              null,
              null
          )
      );

      return ResponseEntity.ok(responseDto);
    } catch (BaseException e) {
      responseDto.setMeta(
          new MetaDataDto(
              e.getCode(),
              e.getMessage(),
              e.getDisplayMessage(),
              null,
              null
          )
      );

      ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
      return bodyBuilder.body(responseDto);
    }
  }
}
