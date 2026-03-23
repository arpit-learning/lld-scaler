package dev.arpit.scaler.dtos;

import dev.arpit.scaler.models.Option;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionResponseDto {
  private long id;
  private String name;
  private String description;
  private List<OptionResponseDto> options;
  private OptionResponseDto correctOption;
  private int score;
}
