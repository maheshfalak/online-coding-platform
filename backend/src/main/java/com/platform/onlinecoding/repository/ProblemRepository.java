package com.platform.onlinecoding.repository;

import com.platform.onlinecoding.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByDifficultyLevel(String difficultyLevel);
    List<Problem> findByTitleContainingIgnoreCase(String keyword);
} 