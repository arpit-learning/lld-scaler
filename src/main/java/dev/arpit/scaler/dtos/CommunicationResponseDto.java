package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommunicationResponseDto {
  private BatchResponseDto batch;
  private String message;
  private AdminResponseDto sentBy;
}
