package dev.arpit.scaler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_learner_exam")
public class LearnerExam extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "learner_id", referencedColumnName = "id")
  private Learner learner;
  @OneToOne(optional = false)
  @JoinColumn(name = "exam_id", referencedColumnName = "id")
  private Exam exam;
  @Column(nullable = false)
  private LocalDateTime startedAt;
  private LocalDateTime endedAt;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private LearnerExamStatus status;
  @Column(nullable = false)
  private int scoreObtained;
}
