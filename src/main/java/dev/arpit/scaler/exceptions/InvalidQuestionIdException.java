package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidQuestionIdException extends BaseException {
  public InvalidQuestionIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}

