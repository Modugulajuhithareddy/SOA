package com.klu.microservices.evaluation.repository;

import com.klu.microservices.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}