package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidLearnerQuestionAnswerException extends BaseException {
  public InvalidLearnerQuestionAnswerException(ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}
