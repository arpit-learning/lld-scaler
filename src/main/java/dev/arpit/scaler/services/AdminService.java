package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidAdminIdException;
import dev.arpit.scaler.models.Admin;
import dev.arpit.scaler.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
  @Autowired
  private AdminRepository adminRepository;

  @Override
  public Admin findById(long adminId) throws InvalidAdminIdException {
    return adminRepository
        .findById(adminId)
        .orElseThrow(
            () -> new InvalidAdminIdException(
                ResponseCode.SCALER_FAILURE_400,
                "invalid admin id",
                "invalid admin id"
            )
        );
  }
}
