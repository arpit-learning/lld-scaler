package dev.arpit.scaler.services;

import dev.arpit.scaler.models.LearnerCommunication;
import dev.arpit.scaler.repositories.LearnerCommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerCommunicationService implements ILearnerCommunicationService {
  @Autowired
  private LearnerCommunicationRepository learnerCommunicationRepository;

  @Override
  public LearnerCommunication save(LearnerCommunication learnerCommunication) {
    return learnerCommunicationRepository.save(learnerCommunication);
  }

  @Override
  public List<LearnerCommunication> saveAll(List<LearnerCommunication> learnerCommunications) {
    return learnerCommunicationRepository.saveAll(learnerCommunications);
  }
}
