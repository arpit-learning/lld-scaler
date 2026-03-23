package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureResponseDto {
  private long id;
  private String name;
  private String description;
}
