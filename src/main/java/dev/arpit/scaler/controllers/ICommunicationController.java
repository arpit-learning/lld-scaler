package dev.arpit.scaler.controllers;

import dev.arpit.scaler.dtos.BroadcastMessageRequestDto;
import dev.arpit.scaler.dtos.BroadcastMessageResponseDto;
import dev.arpit.scaler.dtos.ResponseDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface ICommunicationController {
  ResponseEntity<@NonNull ResponseDto<BroadcastMessageResponseDto>> broadcastMessage(BroadcastMessageRequestDto requestDto);
}
