package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_option")
public class Option extends BaseModel{
    private String text;
}
