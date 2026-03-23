package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BatchResponseDto {
  private long id;
  private String name;
}
