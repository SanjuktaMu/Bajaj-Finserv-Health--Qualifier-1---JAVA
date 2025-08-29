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
    try {
        // 1) Call generateWebhook
        GenerateWebhookRequest req = new GenerateWebhookRequest(name, regNo, email);
        log.info("Sending generateWebhook request for regNo={}", regNo);
        GenerateWebhookResponse resp = webhookClient.generateWebhook(generateWebhookUrl, req);
        if (resp == null) {
            throw new IllegalStateException("Null response from generateWebhook");
        }
        log.info("Received webhook={}, accessTokenPresent={}", resp.getWebhook(), resp.getAccessToken() != null);

        // 2) Force Question 2 (ignore regNo logic)
        int questionId = 2; 
        log.info("Forced questionId = {}", questionId);

        // 3) Load final SQL (from resources)
        String finalQuery = queryProvider.loadQueryForQuestion(questionId);

        // 4) Persist solution locally
        Solution sol = Solution.builder()
                .regNo(regNo)
                .questionId(questionId)
                .finalQuery(finalQuery)
                .submittedAt(OffsetDateTime.now())
                .build();
        repository.save(sol);
        log.info("Saved solution with id {}", sol.getId());

        // 5) Submit the final query to the webhook with JWT
        webhookClient.submitFinalQuery(resp.getWebhook(), resp.getAccessToken(), finalQuery);
        log.info("Submitted final query to remote webhook successfully.");

    } catch (Exception e) {
        log.error("Error during startup flow:", e);
    }
}


    private int determineQuestionIdFromRegNo(String regNoStr) {
        // helper method
    }
}
