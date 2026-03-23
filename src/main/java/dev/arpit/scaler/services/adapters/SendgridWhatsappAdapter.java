package dev.arpit.scaler.services.adapters;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.SendWhatsappMessageException;
import dev.arpit.scaler.exceptions.SendgridSendWhatsappMessageException;
import dev.arpit.scaler.libraries.sendgrid.Sendgrid;
import org.springframework.stereotype.Component;

@Component
public class SendgridWhatsappAdapter implements WhatsappAdapter {
  private final Sendgrid sendgrid = new Sendgrid();

  public void sendWhatsappMessage(String phoneNumber, String message) throws SendWhatsappMessageException {
    try {
      sendgrid.sendWhatsApp(phoneNumber, message);
    } catch (Exception e) {
      throw new SendgridSendWhatsappMessageException(
          ResponseCode.SCALER_FAILURE_400,
          "could not send whatsapp message",
          "could not send whatsapp message"
      );
    }
  }
}
