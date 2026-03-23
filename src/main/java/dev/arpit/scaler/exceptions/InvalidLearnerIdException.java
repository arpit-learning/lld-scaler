package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidLearnerIdException extends BaseException {
  public InvalidLearnerIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
