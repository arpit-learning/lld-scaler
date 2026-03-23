package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidLearnerIdException;
import dev.arpit.scaler.models.Learner;

public interface ILearnerService {
  Learner findById(long learnerId) throws InvalidLearnerIdException;
}
