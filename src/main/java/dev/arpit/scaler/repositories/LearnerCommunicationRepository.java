package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.LearnerCommunication;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerCommunicationRepository extends JpaRepository<@NonNull LearnerCommunication, @NonNull Long> {
}
