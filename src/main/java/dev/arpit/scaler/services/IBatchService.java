package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidBatchIdException;
import dev.arpit.scaler.models.Batch;

public interface IBatchService {
  Batch findById(long batchId) throws InvalidBatchIdException;
}
