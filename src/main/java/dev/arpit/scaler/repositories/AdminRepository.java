package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Admin;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<@NonNull Admin, @NonNull Long> {
}
