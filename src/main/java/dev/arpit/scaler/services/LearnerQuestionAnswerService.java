package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidLearnerExamException;
import dev.arpit.scaler.exceptions.InvalidLearnerQuestionAnswerException;
import dev.arpit.scaler.models.*;
import dev.arpit.scaler.repositories.LearnerQuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LearnerQuestionAnswerService implements ILearnerQuestionAnswerService {
  @Autowired
  private ILearnerExamService iLearnerExamService;
  @Autowired
  private LearnerQuestionAnswerRepository learnerQuestionAnswerRepository;

  @Override
  @Transactional
  public LearnerQuestionAnswer answerQuestion(Learner learner, ExamQuestion examQuestion, Option option) throws InvalidLearnerExamException, InvalidLearnerQuestionAnswerException {
    Exam exam = examQuestion.getExam();
    LearnerExam learnerExam = iLearnerExamService.findByLearnerAndExam(learner, exam);

    if(!examQuestion.getQuestion().getOptions().contains(option)) {
      throw new InvalidLearnerQuestionAnswerException(
          ResponseCode.SCALER_FAILURE_400,
          "Invalid option selected for question",
          "Invalid option selected for question"
      );
    }

    LearnerQuestionAnswer learnerQuestionAnswer = new LearnerQuestionAnswer(
        learner,
        examQuestion.getQuestion(),
        option
    );

    if(examQuestion.getQuestion().getCorrectOption().getId() == option.getId()) {
      learnerExam.setScoreObtained(learnerExam.getScoreObtained() + examQuestion.getQuestion().getScore());
    }
    iLearnerExamService.save(learnerExam);
    return learnerQuestionAnswerRepository.save(learnerQuestionAnswer);
  }
}
