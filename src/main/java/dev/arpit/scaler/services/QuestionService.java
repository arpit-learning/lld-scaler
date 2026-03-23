package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidLearnerIdException;
import dev.arpit.scaler.exceptions.InvalidQuestionIdException;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.Question;
import dev.arpit.scaler.repositories.LearnerRepository;
import dev.arpit.scaler.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService {
  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public Question findById(long questionId) throws InvalidQuestionIdException {
    return questionRepository
        .findById(questionId)
        .orElseThrow(() ->
            new InvalidQuestionIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid question id",
                "Invalid question id"
            )
        );
  }
}
