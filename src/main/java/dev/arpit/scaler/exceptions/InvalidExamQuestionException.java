package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidExamQuestionException extends BaseException {
  public InvalidExamQuestionException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}