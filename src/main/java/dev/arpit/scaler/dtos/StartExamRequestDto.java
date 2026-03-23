package dev.arpit.scaler.dtos;

import lombok.Data;

@Data
public class StartExamRequestDto {
    private Long learnerId;
    private Long examId;
}
