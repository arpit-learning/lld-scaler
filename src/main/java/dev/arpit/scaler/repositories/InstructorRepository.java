package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Instructor;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<@NonNull Instructor, @NonNull Long> {
}
