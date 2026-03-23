package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "scaler_learner")
public class Learner extends User {
}
