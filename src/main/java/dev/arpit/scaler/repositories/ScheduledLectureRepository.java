package dev.arpit.scaler.repositories;

import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.ScheduledLecture;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduledLectureRepository extends JpaRepository<@NonNull ScheduledLecture, @NonNull Long> {
  List<ScheduledLecture> findAllByBatch(Batch batch);
}
