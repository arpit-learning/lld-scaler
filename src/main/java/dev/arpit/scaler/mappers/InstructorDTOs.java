package dev.arpit.scaler.mappers;

import dev.arpit.scaler.dtos.InstructorResponseDto;
import dev.arpit.scaler.models.Instructor;

public class InstructorDTOs {
  public static InstructorResponseDto getInstructorResponseDto(Instructor instructor) {
    return new InstructorResponseDto(
        instructor.getId(),
        instructor.getName(),
        instructor.getEmail(),
        instructor.getMobile()
    );
  }
}
