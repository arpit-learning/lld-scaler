package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidBatchIdException;
import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService implements IBatchService {
  @Autowired
  private BatchRepository batchRepository;

  @Override
  public Batch findById(long batchId) throws InvalidBatchIdException {
    return batchRepository
        .findById(batchId)
        .orElseThrow(
            () -> new InvalidBatchIdException(
                ResponseCode.SCALER_FAILURE_400,
                "invalid batch id",
                "invalid batch id"
            )
        );
  }
}
