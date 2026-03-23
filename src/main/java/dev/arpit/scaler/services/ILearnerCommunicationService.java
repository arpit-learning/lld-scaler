package dev.arpit.scaler.services;

import dev.arpit.scaler.models.LearnerCommunication;

import java.util.List;

public interface ILearnerCommunicationService {
  LearnerCommunication save(LearnerCommunication learnerCommunication);
  List<LearnerCommunication> saveAll(List<LearnerCommunication> learnerCommunications);
}
