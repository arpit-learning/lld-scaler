package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;

public class InvalidExamQuestionIdException extends BaseException {
  public InvalidExamQuestionIdException (ResponseCode code, String message, String displayMessage) {
    super(code, message, displayMessage);
  }
}