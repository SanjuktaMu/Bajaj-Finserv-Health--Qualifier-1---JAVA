package com.example.webhookstarter.domain;

// imports

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regNo;
    private int questionId;

    @Lob
    private String finalQuery;

    private OffsetDateTime submittedAt;
}
