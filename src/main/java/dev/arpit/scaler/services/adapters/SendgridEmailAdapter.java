package dev.arpit.scaler.services.adapters;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.SendEmailException;
import dev.arpit.scaler.exceptions.SendgridSendEmailException;
import dev.arpit.scaler.libraries.sendgrid.Sendgrid;
import org.springframework.stereotype.Component;

@Component
public class SendgridEmailAdapter implements EmailAdapter {
  private final Sendgrid sendgrid;

  public SendgridEmailAdapter() {
    this.sendgrid = new Sendgrid();
  }

  @Override
  public void sendEmail(String email, String message) throws SendEmailException {
    try {
      sendgrid.sendEmailAsync(email, message);
    } catch (Exception e) {
      throw new SendgridSendEmailException(
          ResponseCode.SCALER_FAILURE_400,
          "could not send email",
          "could not send email"
      );
    }
  }
}
