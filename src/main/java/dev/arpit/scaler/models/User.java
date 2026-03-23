package dev.arpit.scaler.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User extends BaseModel {
  private String name;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(unique = true)
  private String mobile;
  @Column(nullable = false)
  private String password;
}
