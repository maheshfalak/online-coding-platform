package com.platform.onlinecoding.service;

import com.platform.onlinecoding.dto.ProblemDTO;

import java.util.List;

public interface ProblemService {
    List<ProblemDTO> getAllProblems();
    ProblemDTO getProblemById(Long id);
    ProblemDTO createProblem(ProblemDTO problemDTO);
    ProblemDTO updateProblem(Long id, ProblemDTO problemDTO);
    void deleteProblem(Long id);
    List<ProblemDTO> getProblemsByDifficulty(String difficultyLevel);
    List<ProblemDTO> searchProblems(String keyword);
} 