package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Option;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<@NonNull Option, @NonNull Long> {
}
