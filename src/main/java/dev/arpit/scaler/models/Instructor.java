package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "scaler_instructor")
public class Instructor extends User {
}
