package com.swp391.eventcraft.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletResponse {
    private Long walletId;
    private Integer userId;
    private BigDecimal availableBalance;
    private BigDecimal escrowBalance;
    private LocalDateTime updatedAt;
}