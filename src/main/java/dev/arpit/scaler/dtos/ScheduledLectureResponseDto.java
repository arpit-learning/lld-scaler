package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ScheduledLectureResponseDto {
  private long id;
  private String name;
  private LectureResponseDto lecture;
  private InstructorResponseDto instructor;
  private BatchResponseDto batch;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private String link;
  private String status;
}
