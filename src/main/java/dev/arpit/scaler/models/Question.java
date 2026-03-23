package dev.arpit.scaler.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_question")
public class Question extends BaseModel {
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String description;
  @OneToMany
  @JoinColumn(name = "question_id", referencedColumnName = "id")
  private List<Option> options;
  @OneToOne(optional = false)
  @JoinColumn(name = "correct_option_id")
  private Option correctOption;
  @Column(nullable = false)
  private int score;
}
