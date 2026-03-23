package dev.arpit.scaler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StartExamResponseDto {
    private LearnerExamResponseDto learnerExam;
}
