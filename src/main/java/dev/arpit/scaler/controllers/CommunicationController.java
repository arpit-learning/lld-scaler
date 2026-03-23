package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.*;
import dev.arpit.scaler.exceptions.BaseException;
import dev.arpit.scaler.mappers.CommunicationDTOs;
import dev.arpit.scaler.models.Admin;
import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.services.IAdminService;
import dev.arpit.scaler.services.IBatchService;
import dev.arpit.scaler.services.ICommunicationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class CommunicationController implements ICommunicationController {
    @Autowired
    private ICommunicationService iCommunicationService;
    @Autowired
    private IBatchService iBatchService;
    @Autowired
    private IAdminService iAdminService;

    public ResponseEntity<@NonNull ResponseDto<BroadcastMessageResponseDto>> broadcastMessage(BroadcastMessageRequestDto requestDto) {
      ResponseDto<BroadcastMessageResponseDto> responseDto = new ResponseDto<>();

      try {
        long batchId = requestDto.getBatchId();
        long adminId = requestDto.getAdminId();
        String message = requestDto.getMessage();
        Batch batch = iBatchService.findById(batchId);
        Admin admin = iAdminService.findById(adminId);
        responseDto.setData(CommunicationDTOs.getBroadcastMessageResponseDto(iCommunicationService.broadcastMessage(batch, admin, message)));
        responseDto.setMeta(
            new MetaDataDto(
                ResponseCode.SCALER_SUCCESS_200,
                "Communication sent successfully",
                "Communication sent successfully",
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
