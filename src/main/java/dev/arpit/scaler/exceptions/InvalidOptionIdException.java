package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidOptionIdException extends BaseException {
  public InvalidOptionIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

