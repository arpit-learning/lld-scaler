package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidExamIdException extends BaseException {
  public InvalidExamIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
