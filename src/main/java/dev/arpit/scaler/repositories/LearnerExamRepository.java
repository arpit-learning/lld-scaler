package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.models.LearnerExam;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearnerExamRepository extends JpaRepository<@NonNull LearnerExam, @NonNull Long> {
  Optional<LearnerExam> findByLearnerAndExam(Learner learner, Exam exam);
}
