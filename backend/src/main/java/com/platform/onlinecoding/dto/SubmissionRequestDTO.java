package com.platform.onlinecoding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionRequestDTO {
    private Long problemId;
    private Long userId;
    private String submissionCode;
    private String language;
} 