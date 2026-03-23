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
@Entity(name = "scaler_learner_communication")
public class LearnerCommunication extends BaseModel {
  @ManyToOne(optional = false)
  @JoinColumn(name = "learner_id", referencedColumnName = "id")
  public Learner learner;
  @ManyToOne(optional = false)
  @JoinColumn(name = "communication_id", referencedColumnName = "id")
  private Communication communication;
  @Column(nullable = false)
  private boolean whatsappDelivered;
  @Column(nullable = false)
  private boolean emailDelivered;
}
