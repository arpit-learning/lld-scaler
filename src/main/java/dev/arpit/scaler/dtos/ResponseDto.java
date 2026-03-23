package dev.arpit.scaler.dtos;

import lombok.Data;

@Data
public class ResponseDto<T> {
  private T data;
  private MetaDataDto meta;
}
