package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamResponseDto {
  private long id;
  private String name;
  private int totalScore;
}
