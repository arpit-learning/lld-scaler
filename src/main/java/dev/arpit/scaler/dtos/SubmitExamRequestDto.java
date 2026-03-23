package dev.arpit.scaler.dtos;

import lombok.Data;

@Data
public class SubmitExamRequestDto {
    private Long learnerId;
    private Long examId;
}
