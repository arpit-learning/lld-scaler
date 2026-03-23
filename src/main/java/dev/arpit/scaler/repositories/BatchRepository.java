package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Batch;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<@NonNull Batch, @NonNull Long> {
}
