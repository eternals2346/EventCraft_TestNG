package com.swp391.eventcraft.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
    private Long transactionId;
    private Long walletId;
    private Long bookingId;
    private BigDecimal amount;
    private String type;
    private String status;
    private String paymentReference;
    private String description;
    private LocalDateTime createdAt;
}