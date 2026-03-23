package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminResponseDto {
  private long id;
  private String name;
  private String email;
  private String mobile;
}
