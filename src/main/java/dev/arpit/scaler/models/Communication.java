package dev.arpit.scaler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_communication")
public class Communication extends BaseModel {
    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private Batch batch;
    @Column(nullable = false)
    private String message;
    @ManyToOne(optional = false)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin sentBy;
}
