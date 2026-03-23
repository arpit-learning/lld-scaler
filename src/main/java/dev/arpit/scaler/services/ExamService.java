package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidExamIdException;
import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService implements IExamService {
  @Autowired
  private ExamRepository examRepository;

  @Override
  public Exam findById(long examId) throws InvalidExamIdException {
    return examRepository
        .findById(examId)
        .orElseThrow(() ->
            new InvalidExamIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid exam id",
                "Invalid exam id"
            )
        );
  }
}
