package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public abstract class SendEmailException extends BaseException {
  public SendEmailException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
