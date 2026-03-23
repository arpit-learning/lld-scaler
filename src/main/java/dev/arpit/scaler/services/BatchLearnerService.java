package dev.arpit.scaler.services;

import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.BatchLearner;
import dev.arpit.scaler.models.Learner;
import dev.arpit.scaler.repositories.BatchLearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchLearnerService implements IBatchLearnerService {
  @Autowired
  private BatchLearnerRepository batchLearnerRepository;

  @Override
  public List<BatchLearner> findAllByBatch(Batch batch) {
    return batchLearnerRepository.findAllByBatch(batch);
  }

  @Override
  public List<BatchLearner> findAllByLearner (Learner learner) {
    return batchLearnerRepository.findAllByLearner(learner);
  }
}
