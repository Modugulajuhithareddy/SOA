package com.klu.microservices.submission.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "evaluation-service")
public interface EvaluationClient {

    @PostMapping("/evaluation/calculate")
    Integer calculateScore(
            @RequestParam Long examId,
            @RequestParam String answers
    );
}