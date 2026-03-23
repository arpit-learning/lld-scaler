package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidScheduledLectureIdException extends BaseException {
  public InvalidScheduledLectureIdException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
