package com.platform.onlinecoding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDTO {
    private Long id;
    private String title;
    private String description;
    private String difficultyLevel;
    private String exampleInput;
    private String exampleOutput;
    private String solutionTemplate;
} 