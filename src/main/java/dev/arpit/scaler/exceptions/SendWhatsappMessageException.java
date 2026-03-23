package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public abstract class SendWhatsappMessageException extends BaseException {
  public SendWhatsappMessageException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
