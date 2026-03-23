package dev.arpit.scaler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_batch")
public class Batch extends BaseModel {
  private String name;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Schedule schedule;
}
