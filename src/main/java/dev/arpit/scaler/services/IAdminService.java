package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidAdminIdException;
import dev.arpit.scaler.models.Admin;

public interface IAdminService {
  Admin findById(long adminId) throws InvalidAdminIdException;
}
