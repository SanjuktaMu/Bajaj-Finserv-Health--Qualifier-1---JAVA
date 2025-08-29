package com.example.webhookstarter.repo;

import com.example.webhookstarter.domain.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {}
