package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.AdminResponseDto;
import dev.arpit.scaler.models.Admin;

public class AdminDTOs {
  public static AdminResponseDto getAdminResponseDto(Admin admin) {
    return new AdminResponseDto(
        admin.getId(),
        admin.getName(),
        admin.getEmail(),
        admin.getMobile()
    );
  }
}
