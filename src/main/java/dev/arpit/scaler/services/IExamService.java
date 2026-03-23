package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidExamIdException;
import dev.arpit.scaler.models.Exam;

public interface IExamService {
  Exam findById(long examId) throws InvalidExamIdException;
}
