package dev.arpit.scaler.services;

import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.BatchLearner;
import dev.arpit.scaler.models.Learner;

import java.util.List;

public interface IBatchLearnerService {
  List<BatchLearner> findAllByBatch(Batch batch);
  List<BatchLearner> findAllByLearner(Learner learner);
}
