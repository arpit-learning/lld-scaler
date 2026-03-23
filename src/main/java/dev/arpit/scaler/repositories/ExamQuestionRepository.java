package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Exam;
import dev.arpit.scaler.models.ExamQuestion;
import dev.arpit.scaler.models.Question;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamQuestionRepository extends JpaRepository<@NonNull ExamQuestion, @NonNull Long> {
  Optional<ExamQuestion> findByExamAndQuestion(Exam exam, Question question);
}
