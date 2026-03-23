package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidQuestionIdException;
import dev.arpit.scaler.models.Question;

public interface IQuestionService {
  Question findById(long questionId) throws InvalidQuestionIdException;
}
