package com.swp391.eventcraft.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MockDepositRequest {
    private BigDecimal amount;
}