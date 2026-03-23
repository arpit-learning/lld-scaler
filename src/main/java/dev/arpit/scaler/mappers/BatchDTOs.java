package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.BatchResponseDto;
import dev.arpit.scaler.models.Batch;

public class BatchDTOs {
  public static BatchResponseDto getBatchResponseDto(Batch batch) {
    return new BatchResponseDto(
        batch.getId(),
        batch.getName()
    );
  }
}
