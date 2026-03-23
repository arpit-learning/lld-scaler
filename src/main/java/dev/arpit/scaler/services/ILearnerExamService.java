package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidLearnerExamException;
import dev.arpit.scaler.models.*;

public interface ILearnerExamService {
  LearnerExam startExam(Learner learner, Exam exam);
  LearnerExam submitExam(Learner learner, Exam exam) throws InvalidLearnerExamException;
  LearnerExam findByLearnerAndExam(Learner learner, Exam exam) throws InvalidLearnerExamException;
  LearnerExam save(LearnerExam learnerExam);
}
