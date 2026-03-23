package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidOptionIdException;
import dev.arpit.scaler.models.Option;
import dev.arpit.scaler.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService implements IOptionService {
  @Autowired
  private OptionRepository optionRepository;

  @Override
  public Option findById(long optionId) throws InvalidOptionIdException {
    return optionRepository
        .findById(optionId)
        .orElseThrow(() ->
            new InvalidOptionIdException(
                ResponseCode.SCALER_FAILURE_400,
                "Invalid option id",
                "Invalid option id"
            )
        );
  }
}
