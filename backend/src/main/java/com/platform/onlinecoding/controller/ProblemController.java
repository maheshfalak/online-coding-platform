package com.platform.onlinecoding.controller;

import com.platform.onlinecoding.dto.ProblemDTO;
import com.platform.onlinecoding.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping
    public ResponseEntity<List<ProblemDTO>> getAllProblems() {
        return ResponseEntity.ok(problemService.getAllProblems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProblemDTO> getProblemById(@PathVariable Long id) {
        return ResponseEntity.ok(problemService.getProblemById(id));
    }

    @PostMapping
    public ResponseEntity<ProblemDTO> createProblem(@RequestBody ProblemDTO problemDTO) {
        return new ResponseEntity<>(problemService.createProblem(problemDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProblemDTO> updateProblem(@PathVariable Long id, @RequestBody ProblemDTO problemDTO) {
        return ResponseEntity.ok(problemService.updateProblem(id, problemDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/difficulty/{level}")
    public ResponseEntity<List<ProblemDTO>> getProblemsByDifficulty(@PathVariable String level) {
        return ResponseEntity.ok(problemService.getProblemsByDifficulty(level));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProblemDTO>> searchProblems(@RequestParam String keyword) {
        return ResponseEntity.ok(problemService.searchProblems(keyword));
    }
} 