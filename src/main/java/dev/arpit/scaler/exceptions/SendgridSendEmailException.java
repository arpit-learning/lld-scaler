package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class SendgridSendEmailException extends SendEmailException {
  public SendgridSendEmailException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
