package dev.arpit.scaler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_scheduled_lecture")
public class ScheduledLecture extends BaseModel{
  private String name;
  @ManyToOne(optional = false)
  @JoinColumn(name = "lecture_id", referencedColumnName = "id")
  private Lecture lecture;
  @ManyToOne(optional = false)
  @JoinColumn(name = "batch_id", referencedColumnName = "id")
  private Batch batch;
  @ManyToOne(optional = false)
  @JoinColumn(name = "instructor_id", referencedColumnName = "id")
  private Instructor instructor;
  @Column(nullable = false)
  private LocalDateTime startTime;
  @Column(nullable = false)
  private LocalDateTime endTime;
  @Column(nullable = false)
  private String link;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ScheduledLectureStatus status;
}
