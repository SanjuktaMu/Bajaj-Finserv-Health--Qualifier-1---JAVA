package com.example.webhookstarter.config;

@Configuration                          // top-level annotation
public class WebClientConfig {
    @Bean                               // only method in file
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}
