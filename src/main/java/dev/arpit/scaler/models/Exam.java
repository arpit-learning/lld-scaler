package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_exam")
public class Exam extends BaseModel {
    private String name;
    private int totalScore;
}
