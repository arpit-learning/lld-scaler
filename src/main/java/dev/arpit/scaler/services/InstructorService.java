package dev.arpit.scaler.services;

import dev.arpit.scaler.dtos.ResponseCode;
import dev.arpit.scaler.exceptions.InvalidInstructorIdException;
import dev.arpit.scaler.models.Instructor;
import dev.arpit.scaler.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService implements IInstructorService {
  @Autowired
  private InstructorRepository instructorRepository;

  @Override
  public Instructor findById(long instructorId) throws InvalidInstructorIdException {
    return instructorRepository
        .findById(instructorId)
        .orElseThrow(() -> new InvalidInstructorIdException(
            ResponseCode.SCALER_FAILURE_400,
            "invalid instructor id",
            "invalid instructor id"
        ));
  }
}
