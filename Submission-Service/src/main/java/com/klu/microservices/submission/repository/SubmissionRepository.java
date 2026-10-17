package com.klu.microservices.submission.repository;

import com.klu.microservices.submission.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByStudentId(Long studentId);

    List<Submission> findByExamId(Long examId);
}