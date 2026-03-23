package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidExamQuestionException;
import dev.arpit.scaler.exceptions.InvalidExamQuestionIdException;
import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.models.ExamQuestion;
import dev.arpit.scaler.models.Question;

public interface IExamQuestionService {
  ExamQuestion findById(long examQuestionId) throws InvalidExamQuestionIdException;
  ExamQuestion findByExamAndQuestion(Exam exam, Question question) throws InvalidExamQuestionException;
}
