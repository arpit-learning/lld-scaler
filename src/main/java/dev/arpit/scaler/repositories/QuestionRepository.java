package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Question;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<@NonNull Question, @NonNull Long> {
}
