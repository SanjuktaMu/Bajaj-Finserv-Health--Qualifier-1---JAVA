package com.example.webhookstarter.service;

// imports

@Service
public class SolutionService {
    private static final Logger log = LoggerFactory.getLogger(SolutionService.class);

    private final WebhookClient webhookClient;
    private final SolutionRepository repository;
    private final SqlQueryProvider queryProvider;

    // --- @Value fields under dependencies ---
    @Value("${app.generate-webhook-url}")
    private String generateWebhookUrl;
    @Value("${app.regNo}")
    private String regNo;
    @Value("${app.name}")
    private String name;
    @Value("${app.email}")
    private String email;

    // --- constructor next ---
    public SolutionService(WebhookClient webhookClient, SolutionRepository repository, SqlQueryProvider queryProvider) {
        this.webhookClient = webhookClient;
        this.repository = repository;
        this.queryProvider = queryProvider;
    }

    // --- public methods after constructor ---
    public void executeFlowOnStartup() {
        // full method body
    }

    private int determineQuestionIdFromRegNo(String regNoStr) {
        // helper method
    }
}
