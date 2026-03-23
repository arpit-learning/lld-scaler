package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Communication;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<@NonNull Communication, @NonNull Long> {
}
