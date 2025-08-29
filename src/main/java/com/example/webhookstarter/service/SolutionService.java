package com.example.webhookstarter.service;

import com.example.webhookstarter.client.WebhookClient;
import com.example.webhookstarter.domain.Solution;
import com.example.webhookstarter.dto.GenerateWebhookRequest;
import com.example.webhookstarter.repo.SolutionRepository;
import com.example.webhookstarter.util.SqlQueryProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final WebhookClient webhookClient;
    private final SolutionRepository repository;
    private final SqlQueryProvider queryProvider;

    @Value("${app.generate-webhook-url}")
    private String generateWebhookUrl;

    @Value("${app.regNo}")
    private String regNo;

    @Value("${app.name}")
    private String name;

    @Value("${app.email}")
    private String email;

    @Value("${app.test-webhook-url}")
    private String testWebhookUrl;

    public void executeFlowOnStartup() {
        // full method body
    }

    private int determineQuestionIdFromRegNo(String regNoStr) {
        String digits = regNoStr.replaceAll("\\D+", "");
        int lastTwo = digits.length() >= 2 ?
                Integer.parseInt(digits.substring(digits.length() - 2)) :
                Integer.parseInt(digits);
        return (lastTwo % 2 == 1) ? 1 : 2;
    }
}
