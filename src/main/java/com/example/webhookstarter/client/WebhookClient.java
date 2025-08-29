package com.example.webhookstarter.client;

// imports

@Component
public class WebhookClient {

    private final WebClient webClient;   // field at top

    public WebhookClient(WebClient webClient) {   // constructor next
        this.webClient = webClient;
    }

    // --- methods after constructor ---

    public GenerateWebhookResponse generateWebhook(String url, GenerateWebhookRequest req) {
        // body...
    }

    public void submitFinalQuery(String webhookUrl, String jwtAccessToken, String finalQuery) {
        // body...
    }
}
