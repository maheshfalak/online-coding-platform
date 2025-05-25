package com.platform.onlinecoding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {
    private Long id;
    private Long problemId;
    private String problemTitle;
    private Long userId;
    private String username;
    private String submissionCode;
    private String language;
    private LocalDateTime submissionDate;
    private String status;
    private Double executionTime;
    private Long memoryUsed;
} 