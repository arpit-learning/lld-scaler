package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import dev.arpit.scaler.exceptions.BaseException;
import dev.arpit.scaler.mappers.LearnerQuestionAnswerDTOs;
import dev.arpit.scaler.models.*;
import dev.arpit.scaler.services.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnerQuestionAnswerController implements ILearnerQuestionAnswerController {
  @Autowired
  private ILearnerQuestionAnswerService iLearnerQuestionAnswerService;
  @Autowired
  private ILearnerService iLearnerService;
  @Autowired
  private IExamService iExamService;
  @Autowired
  private IQuestionService iQuestionService;
  @Autowired
  private IOptionService iOptionService;
  @Autowired
  private IExamQuestionService iExamQuestionService;

  @Override
  @PostMapping(Endpoints.v1Answer)
  public ResponseEntity<@NonNull ResponseDto<AnswerQuestionResponseDto>> answerQuestion(AnswerQuestionRequestDto requestDto) {
    ResponseDto<AnswerQuestionResponseDto> responseDto = new ResponseDto<>();

    try {
      long learnerId = requestDto.getLearnerId();
      long examId = requestDto.getExamId();
      long questionId = requestDto.getQuestionId();
      long optionId = requestDto.getOptionId();
      Learner learner = iLearnerService.findById(learnerId);
      Exam exam = iExamService.findById(examId);
      Question question = iQuestionService.findById(questionId);
      Option option = iOptionService.findById(optionId);
      ExamQuestion examQuestion = iExamQuestionService.findByExamAndQuestion(exam, question);
      responseDto.setData(LearnerQuestionAnswerDTOs.getAnswerQuestionResponseDto(iLearnerQuestionAnswerService.answerQuestion(learner, examQuestion, option)));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.SCALER_SUCCESS_200,
              "User successfully answered the question",
              "User successfully answered the question",
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
