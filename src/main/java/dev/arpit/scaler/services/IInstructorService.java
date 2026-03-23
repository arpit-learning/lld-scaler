package dev.arpit.scaler.services;

import dev.arpit.scaler.exceptions.InvalidInstructorIdException;
import dev.arpit.scaler.models.Instructor;

public interface IInstructorService {
  Instructor findById(long instructorId) throws InvalidInstructorIdException;
}
