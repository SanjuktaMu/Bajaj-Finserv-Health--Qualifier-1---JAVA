package com.example.webhookstarter;

@SpringBootApplication
public class WebhookStarterApplication {

    public static void main(String[] args) {   // first method in file
        SpringApplication.run(WebhookStarterApplication.class, args);
    }

    @Bean                               // place this AFTER main method
    public CommandLineRunner runner(SolutionService solutionService) {
        return args -> {
            solutionService.executeFlowOnStartup();
        };
    }
}
