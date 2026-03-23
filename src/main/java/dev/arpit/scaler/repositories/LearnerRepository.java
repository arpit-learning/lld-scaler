package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Learner;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<@NonNull Learner, @NonNull Long> {
}
