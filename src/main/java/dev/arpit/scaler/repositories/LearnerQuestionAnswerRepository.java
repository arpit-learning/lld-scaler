package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.LearnerQuestionAnswer;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerQuestionAnswerRepository extends JpaRepository<@NonNull LearnerQuestionAnswer, @NonNull Long> {
}
