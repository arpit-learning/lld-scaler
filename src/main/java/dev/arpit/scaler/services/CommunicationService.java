package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.SendEmailException;
import dev.arpit.scaler.exceptions.SendWhatsappMessageException;
import dev.arpit.scaler.services.adapters.EmailAdapter;
import dev.arpit.scaler.services.adapters.WhatsappAdapter;
import dev.arpit.scaler.models.*;
import dev.arpit.scaler.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunicationService implements ICommunicationService {
  @Autowired
  private CommunicationRepository communicationRepository;
  @Autowired
  private IBatchLearnerService iBatchLearnerService;
  @Autowired
  private ILearnerCommunicationService iLearnerCommunicationService;
  @Autowired
  private EmailAdapter emailAdapter;
  @Autowired
  private WhatsappAdapter whatsappAdapter;

  @Override
  @Transactional
  public Communication broadcastMessage(Batch batch, Admin admin, String message) throws SendEmailException, SendWhatsappMessageException {
    Communication communication = new Communication(
        batch,
        message,
        admin
    );
    communication = this.save(communication);

    List<Learner> learners = iBatchLearnerService.findAllByBatch(batch).stream().filter(i -> i.getExitDate() == null).map(BatchLearner::getLearner).toList();
    List<LearnerCommunication> learnerCommunications = new ArrayList<>();

    for(Learner learner : learners) {
      learnerCommunications.add(new LearnerCommunication(
          learner,
          communication,
          false,
          false
      ));
    }

    learnerCommunications = iLearnerCommunicationService.saveAll(learnerCommunications);

    for(LearnerCommunication i : learnerCommunications) {
      emailAdapter.sendEmail(i.getLearner().getEmail(), i.getCommunication().getMessage());
      i.setEmailDelivered(true);
      whatsappAdapter.sendWhatsappMessage(i.getLearner().getMobile(), i.getCommunication().getMessage());
      i.setWhatsappDelivered(true);
      iLearnerCommunicationService.save(i);
    }

    return communication;
  }

  @Override
  public Communication save (Communication communication) {
    return communicationRepository.save(communication);
  }
}
