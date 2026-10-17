package com.klu.microservices.submission.controller;

import com.klu.microservices.submission.dto.SubmissionRequest;
import com.klu.microservices.submission.entity.Submission;
import com.klu.microservices.submission.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<Submission> submit(
            @RequestBody SubmissionRequest request) {

        Submission submission = new Submission();

        submission.setStudentId(request.getStudentId());
        submission.setExamId(request.getExamId());
        submission.setAnswers(request.getAnswers());
        submission.setStatus("SUBMITTED");

        return ResponseEntity.ok(
                submissionService.submitAnswer(submission)
        );
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAll() {
        return ResponseEntity.ok(
                submissionService.getAllSubmissions()
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Submission>> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                submissionService.getByStudent(studentId)
        );
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Submission>> getByExam(
            @PathVariable Long examId) {

        return ResponseEntity.ok(
                submissionService.getByExam(examId)
        );
    }
}