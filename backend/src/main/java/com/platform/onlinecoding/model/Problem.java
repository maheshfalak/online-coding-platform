package com.platform.onlinecoding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "problems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false, length = 4000)
    private String description;
    
    @Column(name = "difficulty_level", nullable = false)
    private String difficultyLevel;
    
    @Column(name = "example_input")
    private String exampleInput;
    
    @Column(name = "example_output")
    private String exampleOutput;
    
    @Column(name = "solution_template", length = 4000)
    private String solutionTemplate;
    
    @Column(name = "test_cases", length = 4000)
    private String testCases;
} 