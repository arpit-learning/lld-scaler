package dev.arpit.scaler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_lecture")
public class Lecture extends BaseModel {
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String description;
}
