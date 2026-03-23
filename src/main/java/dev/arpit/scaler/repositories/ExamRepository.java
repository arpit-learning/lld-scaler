package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Exam;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<@NonNull Exam, @NonNull Long> {
}
