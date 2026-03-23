package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_batch")
public class Batch extends BaseModel {
    private String name;
}
