package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IScheduledLectureController {
  ResponseEntity<@NonNull ResponseDto<FetchTimelineResponseDto>> fetchTimeline(FetchTimelineRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<RescheduleScheduledLectureResponseDto>> rescheduleScheduledLecture(RescheduleScheduledLectureRequestDto requestDto);
}
