package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidLearnerIdException;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.repositories.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerService implements ILearnerService {
  @Autowired
  private LearnerRepository learnerRepository;

  @Override
  public Learner findById(long learnerId) throws InvalidLearnerIdException {
    return learnerRepository
        .findById(learnerId)
        .orElseThrow(() ->
            new InvalidLearnerIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid learner id",
                "Invalid learner id"
            )
        );
  }
}
