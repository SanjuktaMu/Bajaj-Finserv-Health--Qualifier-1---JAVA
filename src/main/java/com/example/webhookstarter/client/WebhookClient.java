package com.example.webhookstarter.client;

import com.example.webhookstarter.dto.GenerateWebhookRequest;
import com.example.webhookstarter.dto.GenerateWebhookResponse;
import com.example.webhookstarter.dto.TestWebhookRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebhookClient {

    private final WebClient webClient;

    public WebhookClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public GenerateWebhookResponse generateWebhook(String url, GenerateWebhookRequest req) {
        return webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(req)
                .retrieve()
                .bodyToMono(GenerateWebhookResponse.class)
                .block();
    }

    public void submitFinalQuery(String webhookUrl, String jwtToken, String finalQuery) {
        TestWebhookRequest payload = new TestWebhookRequest(finalQuery);
        webClient.post()
                .uri(webhookUrl)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
