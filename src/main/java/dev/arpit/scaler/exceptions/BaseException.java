package dev.arpit.scaler.exceptions;

import dev.arpit.scaler.dtos.ResponseCode;
import lombok.Getter;

@Getter
public abstract class BaseException extends Exception {
  private final ResponseCode code;
  private final String displayMessage;

  public BaseException(ResponseCode code, String message, String displayMessage) {
    super(message);
    this.code = code;
    this.displayMessage = displayMessage;
  }
}
