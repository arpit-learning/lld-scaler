package dev.arpit.scaler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_batch_learner")
public class BatchLearner extends BaseModel{
    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    public Batch batch;
    @ManyToOne(optional = false)
    @JoinColumn(name = "learner_id", referencedColumnName = "id")
    public Learner learner;
    @Column(nullable = false)
    public LocalDateTime entryDate;
    public LocalDateTime exitDate;
}
