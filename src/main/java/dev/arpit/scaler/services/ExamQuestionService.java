package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidExamQuestionException;
import dev.arpit.scaler.exceptions.InvalidExamQuestionIdException;
import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.models.ExamQuestion;
import dev.arpit.scaler.models.Question;
import dev.arpit.scaler.repositories.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamQuestionService implements IExamQuestionService {
  @Autowired
  private ExamQuestionRepository examQuestionRepository;

  @Override
  public ExamQuestion findById(long examQuestionId) throws InvalidExamQuestionIdException {
    return examQuestionRepository
        .findById(examQuestionId)
        .orElseThrow(() ->
            new InvalidExamQuestionIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid exam question id",
                "Invalid exam question id"
            )
        );
  }

  @Override
  public ExamQuestion findByExamAndQuestion (Exam exam, Question question) throws InvalidExamQuestionException {
    return examQuestionRepository
        .findByExamAndQuestion(exam, question)
        .orElseThrow(() ->
            new InvalidExamQuestionException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid exam question",
                "Invalid exam question"
            )
        );
  }
}
