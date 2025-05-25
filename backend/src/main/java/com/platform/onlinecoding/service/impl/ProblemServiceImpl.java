package com.platform.onlinecoding.service.impl;

import com.platform.onlinecoding.dto.ProblemDTO;
import com.platform.onlinecoding.model.Problem;
import com.platform.onlinecoding.repository.ProblemRepository;
import com.platform.onlinecoding.service.ProblemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    @Override
    public List<ProblemDTO> getAllProblems() {
        return problemRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProblemDTO getProblemById(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Problem not found with id: " + id));
        return mapToDTO(problem);
    }

    @Override
    public ProblemDTO createProblem(ProblemDTO problemDTO) {
        Problem problem = mapToEntity(problemDTO);
        Problem savedProblem = problemRepository.save(problem);
        return mapToDTO(savedProblem);
    }

    @Override
    public ProblemDTO updateProblem(Long id, ProblemDTO problemDTO) {
        if (!problemRepository.existsById(id)) {
            throw new EntityNotFoundException("Problem not found with id: " + id);
        }
        
        Problem problem = mapToEntity(problemDTO);
        problem.setId(id);
        Problem updatedProblem = problemRepository.save(problem);
        return mapToDTO(updatedProblem);
    }

    @Override
    public void deleteProblem(Long id) {
        if (!problemRepository.existsById(id)) {
            throw new EntityNotFoundException("Problem not found with id: " + id);
        }
        problemRepository.deleteById(id);
    }

    @Override
    public List<ProblemDTO> getProblemsByDifficulty(String difficultyLevel) {
        return problemRepository.findByDifficultyLevel(difficultyLevel).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProblemDTO> searchProblems(String keyword) {
        return problemRepository.findByTitleContainingIgnoreCase(keyword).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProblemDTO mapToDTO(Problem problem) {
        return ProblemDTO.builder()
                .id(problem.getId())
                .title(problem.getTitle())
                .description(problem.getDescription())
                .difficultyLevel(problem.getDifficultyLevel())
                .exampleInput(problem.getExampleInput())
                .exampleOutput(problem.getExampleOutput())
                .solutionTemplate(problem.getSolutionTemplate())
                .build();
    }

    private Problem mapToEntity(ProblemDTO problemDTO) {
        Problem problem = new Problem();
        problem.setId(problemDTO.getId());
        problem.setTitle(problemDTO.getTitle());
        problem.setDescription(problemDTO.getDescription());
        problem.setDifficultyLevel(problemDTO.getDifficultyLevel());
        problem.setExampleInput(problemDTO.getExampleInput());
        problem.setExampleOutput(problemDTO.getExampleOutput());
        problem.setSolutionTemplate(problemDTO.getSolutionTemplate());
        return problem;
    }
} 