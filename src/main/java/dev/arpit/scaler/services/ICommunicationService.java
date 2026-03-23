package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.SendEmailException;
import dev.arpit.scaler.exceptions.SendWhatsappMessageException;
import dev.arpit.scaler.models.Admin;
import dev.arpit.scaler.models.Batch;
import dev.arpit.scaler.models.Communication;

public interface ICommunicationService {
  Communication broadcastMessage(Batch batch, Admin admin, String message) throws SendEmailException, SendWhatsappMessageException;
  Communication save(Communication communication);
}
