package com.klu.microservices.evaluation.controller;

import com.klu.microservices.evaluation.service.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Integer> calculateScore(
            @RequestParam("examId") Long examId,
            @RequestParam("answers") String answers) {

        Integer score =
                evaluationService.calculateScore(examId, answers);

        return ResponseEntity.ok(score);
    }
}