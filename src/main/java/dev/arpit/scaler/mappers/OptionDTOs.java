package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.OptionResponseDto;
import dev.arpit.scaler.models.Option;

import java.util.List;

public class OptionDTOs {
  public static OptionResponseDto getOptionResponseDto(Option option) {
    return new OptionResponseDto(
        option.getId(),
        option.getText()
    );
  }

  public static List<OptionResponseDto> getOptionsResponseDto(List<Option> options) {
    return options.stream().map(OptionDTOs::getOptionResponseDto).toList();
  }
}
