package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.BatchLearner;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchLearnerRepository extends JpaRepository<@NonNull BatchLearner, @NonNull Long> {
  List<BatchLearner> findAllByBatch (Batch batch);
}
