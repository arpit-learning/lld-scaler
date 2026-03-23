package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class SendgridSendWhatsappMessageException extends SendWhatsappMessageException {
  public SendgridSendWhatsappMessageException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
