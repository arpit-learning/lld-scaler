package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidAdminIdException extends BaseException {
  public InvalidAdminIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
