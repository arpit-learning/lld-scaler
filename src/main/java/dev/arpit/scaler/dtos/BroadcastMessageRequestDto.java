package dev.arpit.scaler.dtos;

import lombok.Data;

@Data
public class BroadcastMessageRequestDto {
  private String message;
  private Long batchId;
  private Long adminId;
}
