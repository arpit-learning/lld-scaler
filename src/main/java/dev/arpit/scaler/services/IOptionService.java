package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidOptionIdException;
import dev.arpit.scaler.models.Option;

public interface IOptionService {
  Option findById(long optionId) throws InvalidOptionIdException;
}
