package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidLearnerExamException;
import dev.arpit.scaler.models.*;
import dev.arpit.scaler.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LearnerExamService implements ILearnerExamService {
    @Autowired
    private LearnerExamRepository learnerExamRepository;

    @Override
    @Transactional
    public LearnerExam startExam(Learner learner, Exam exam) {
      LearnerExam learnerExam = new LearnerExam(
          learner,
          exam,
          LocalDateTime.now(),
          null,
          LearnerExamStatus.NOT_ATTEMPTED,
          0
      );
      return this.save(learnerExam);
    }

    @Override
    @Transactional
    public LearnerExam submitExam(Learner learner, Exam exam) throws InvalidLearnerExamException {
      LearnerExam learnerExam = this.findByLearnerAndExam(learner, exam);
      if (new ArrayList<>(List.of(LearnerExamStatus.SUBMITTED, LearnerExamStatus.COMPLETED)).contains(learnerExam.getStatus())) {
        throw new InvalidLearnerExamException(
            ResponseCode.SCALER_FAILURE_400,
            "Exam already submitted to completed by the learner",
            "Exam already submitted to completed by the learner"
        );
      }
      learnerExam.setEndedAt(LocalDateTime.now());
      learnerExam.setStatus(LearnerExamStatus.SUBMITTED);
      return this.save(learnerExam);
    }

  @Override
  public LearnerExam findByLearnerAndExam(Learner learner, Exam exam) throws InvalidLearnerExamException {
    return learnerExamRepository.findByLearnerAndExam(learner, exam).orElseThrow(() ->
        new InvalidLearnerExamException(
            ResponseCode.SCALER_FAILURE_400,
            "Could not find leaner exam for the exam with id " + exam.getId() + " and the learner with id " + learner.getId(),
            "Could not find leaner exam for the exam with id " + exam.getId() + " and the learner with id " + learner.getId()
        )
    );
  }

  @Override
  public LearnerExam save (LearnerExam learnerExam) {
    return learnerExamRepository.save(learnerExam);
  }
}
