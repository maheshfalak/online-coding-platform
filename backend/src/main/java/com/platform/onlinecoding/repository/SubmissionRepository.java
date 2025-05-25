package com.platform.onlinecoding.repository;

import com.platform.onlinecoding.model.Problem;
import com.platform.onlinecoding.model.Submission;
import com.platform.onlinecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByUser(User user);
    List<Submission> findByProblem(Problem problem);
    List<Submission> findByUserAndProblem(User user, Problem problem);
    List<Submission> findByStatus(String status);
} 