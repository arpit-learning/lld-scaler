package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_exam_question")
public class ExamQuestion extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "exam_id", referencedColumnName = "id")
  private Exam exam;
  @ManyToOne(optional = false)
  @JoinColumn(name = "question_id", referencedColumnName = "id")
  private Question question;
}
