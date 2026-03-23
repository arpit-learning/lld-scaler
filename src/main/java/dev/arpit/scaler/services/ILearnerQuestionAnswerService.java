package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidLearnerExamException;
import dev.arpit.scaler.exceptions.InvalidLearnerQuestionAnswerException;
import dev.arpit.scaler.models.*;

public interface ILearnerQuestionAnswerService {
  LearnerQuestionAnswer answerQuestion(Learner learner, ExamQuestion examQuestion, Option option) throws InvalidLearnerExamException, InvalidLearnerQuestionAnswerException;
}
