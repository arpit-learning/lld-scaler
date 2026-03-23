package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.FetchTimelineRequestDto;
import dev.arpit.scaler.dtos.FetchTimelineResponseDto;
import dev.arpit.scaler.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IScheduledLectureController {
  ResponseEntity<@NonNull ResponseDto<FetchTimelineResponseDto>> fetchTimeline(FetchTimelineRequestDto requestDto);
}
