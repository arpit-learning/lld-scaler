package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.BroadcastMessageResponseDto;
import dev.arpit.scaler.dtos.CommunicationResponseDto;
import dev.arpit.scaler.models.Communication;

public class CommunicationDTOs {
  public static BroadcastMessageResponseDto getBroadcastMessageResponseDto(Communication communication) {
    return new BroadcastMessageResponseDto(
        CommunicationDTOs.getCommunicationResponseDto(communication)
    );
  }

  public static CommunicationResponseDto getCommunicationResponseDto(Communication communication) {
    return new CommunicationResponseDto(
        BatchDTOs.getBatchResponseDto(communication.getBatch()),
        communication.getMessage(),
        AdminDTOs.getAdminResponseDto(communication.getSentBy())
    );
  }
}
