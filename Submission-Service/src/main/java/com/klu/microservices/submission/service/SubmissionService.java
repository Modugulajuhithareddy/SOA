package com.klu.microservices.submission.service;

import com.klu.microservices.submission.client.EvaluationClient;
import com.klu.microservices.submission.entity.Submission;
import com.klu.microservices.submission.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final EvaluationClient evaluationClient;

    public SubmissionService(SubmissionRepository submissionRepository,
                             EvaluationClient evaluationClient) {
        this.submissionRepository = submissionRepository;
        this.evaluationClient = evaluationClient;
    }

    public Submission submitAnswer(Submission submission) {

        Integer score = evaluationClient.calculateScore(
                submission.getExamId(),
                submission.getAnswers()
        );

        submission.setScore(score);
        submission.setStatus("EVALUATED");

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public List<Submission> getByStudent(Long studentId) {
        return submissionRepository.findByStudentId(studentId);
    }

    public List<Submission> getByExam(Long examId) {
        return submissionRepository.findByExamId(examId);
    }
}