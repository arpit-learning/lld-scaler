package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidScheduledLectureException extends BaseException {
  public InvalidScheduledLectureException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
