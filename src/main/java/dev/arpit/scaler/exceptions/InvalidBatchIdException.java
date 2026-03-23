package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidBatchIdException extends BaseException {
  public InvalidBatchIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
