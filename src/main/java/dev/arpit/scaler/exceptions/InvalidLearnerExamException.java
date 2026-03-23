package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidLearnerExamException extends BaseException {
  public InvalidLearnerExamException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
