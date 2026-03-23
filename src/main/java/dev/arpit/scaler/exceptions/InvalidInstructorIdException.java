package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidInstructorIdException extends BaseException {
  public InvalidInstructorIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
