package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ScheduleLecturesResponseDto {
  private List<ScheduledLectureResponseDto> scheduledLectures;
}
