package com.klu.microservices.evaluation.service;

import com.klu.microservices.evaluation.entity.Evaluation;
import com.klu.microservices.evaluation.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Integer calculateScore(Long examId, String answers) {

        String[] submittedAnswers = answers.split(",");

        // Correct answer for the current exam question
        String[] correctAnswers = {"B"};

        int score = 0;

        for (int i = 0; i < submittedAnswers.length
                && i < correctAnswers.length; i++) {

            if (submittedAnswers[i].trim()
                    .equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }

        Evaluation evaluation =
                new Evaluation(examId, answers, score);

        evaluationRepository.save(evaluation);

        return score;
    }
}