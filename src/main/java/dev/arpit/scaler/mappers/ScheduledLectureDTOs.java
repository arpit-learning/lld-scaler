package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.FetchTimelineResponseDto;
import dev.arpit.scaler.dtos.RescheduleScheduledLectureResponseDto;
import dev.arpit.scaler.dtos.ScheduleLecturesResponseDto;
import dev.arpit.scaler.dtos.ScheduledLectureResponseDto;
import dev.arpit.scaler.models.ScheduledLecture;

import java.util.List;

public class ScheduledLectureDTOs {
  public static ScheduledLectureResponseDto getScheduledLectureResponseDto(ScheduledLecture scheduledLecture) {
    return new ScheduledLectureResponseDto(
        scheduledLecture.getId(),
        scheduledLecture.getName(),
        LectureDTOs.getLectureResponseDto(scheduledLecture.getLecture()),
        InstructorDTOs.getInstructorResponseDto(scheduledLecture.getInstructor()),
        BatchDTOs.getBatchResponseDto(scheduledLecture.getBatch()),
        scheduledLecture.getStartTime(),
        scheduledLecture.getEndTime(),
        scheduledLecture.getLink(),
        scheduledLecture.getStatus().toString()
    );
  }

  public static List<ScheduledLectureResponseDto> getScheduledLecturesResponseDto(List<ScheduledLecture> scheduledLectures) {
    return scheduledLectures
        .stream()
        .map(ScheduledLectureDTOs::getScheduledLectureResponseDto)
        .toList();
  }

  public static FetchTimelineResponseDto getFetchTimelineResponseDto(List<ScheduledLecture> scheduledLectures) {
    return new FetchTimelineResponseDto(
        ScheduledLectureDTOs.getScheduledLecturesResponseDto(scheduledLectures)
    );
  }

  public static RescheduleScheduledLectureResponseDto getRescheduleScheduledLectureResponseDto(List<ScheduledLecture> scheduledLectures) {
    return new RescheduleScheduledLectureResponseDto(
        ScheduledLectureDTOs.getScheduledLecturesResponseDto(scheduledLectures)
    );
  }

  public static ScheduleLecturesResponseDto getScheduleLecturesResponseDto(List<ScheduledLecture> scheduledLectures) {
    return new ScheduleLecturesResponseDto(
        ScheduledLectureDTOs.getScheduledLecturesResponseDto(scheduledLectures)
    );
  }
}
