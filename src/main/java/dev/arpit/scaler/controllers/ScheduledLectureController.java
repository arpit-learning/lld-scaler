package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import dev.arpit.scaler.exceptions.BaseException;
import dev.arpit.scaler.mappers.ScheduledLectureDTOs;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.services.ILearnerService;
import dev.arpit.scaler.services.IScheduledLectureService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledLectureController implements IScheduledLectureController {
  @Autowired
  private IScheduledLectureService iScheduledLectureService;
  @Autowired
  private ILearnerService iLearnerService;

  @Override
  @Transactional
  @GetMapping(Endpoints.v1FetchTimeline)
  public ResponseEntity<@NonNull ResponseDto<FetchTimelineResponseDto>> fetchTimeline(FetchTimelineRequestDto requestDto) {
      ResponseDto<FetchTimelineResponseDto> responseDto = new ResponseDto<>();

      try {
        long learnerId = requestDto.getLearnerId();
        Learner learner = iLearnerService.findById(learnerId);
        responseDto.setData(ScheduledLectureDTOs.getFetchTimelineResponseDto(iScheduledLectureService.fetchTimeline(learner)));
        responseDto.setMeta(
            new MetaDataDto(
                ResponseCode.SCALER_SUCCESS_200,
                "Timeline fetched successfully",
                "Timeline fetched successfully",
                null,
                null
            )
        );

        return ResponseEntity.ok(responseDto);
      } catch (BaseException e) {
        responseDto.setMeta(
            new MetaDataDto(
                e.getCode(),
                e.getMessage(),
                e.getDisplayMessage(),
                null,
                null
            )
        );

        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
        return bodyBuilder.body(responseDto);
      }
  }

  @Override
  @Transactional
  @PutMapping(Endpoints.v1ScheduledLecturesReschedule)
  public ResponseEntity<@NonNull ResponseDto<RescheduleScheduledLectureResponseDto>> rescheduleScheduledLecture(RescheduleScheduledLectureRequestDto requestDto) {
    ResponseDto<RescheduleScheduledLectureResponseDto> responseDto = new ResponseDto<>();

    try {
      long scheduledLectureId = requestDto.getScheduledLectureId();
      responseDto.setData(ScheduledLectureDTOs.getRescheduleScheduledLectureResponseDto(iScheduledLectureService.rescheduleScheduledLecture(scheduledLectureId)));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.SCALER_SUCCESS_200,
              "Scheduled lectures rescheduled successfully",
              "Scheduled lectures rescheduled successfully",
              null,
              null
          )
      );

      return ResponseEntity.ok(responseDto);
    } catch(BaseException e) {
      responseDto.setMeta(
          new MetaDataDto(
              e.getCode(),
              e.getMessage(),
              e.getDisplayMessage(),
              null,
              null
          )
      );

      ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
      return bodyBuilder.body(responseDto);
    }
  }
}
