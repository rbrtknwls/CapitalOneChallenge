package com.rewards.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class RewardResponse {
    int x;

    public RewardResponse() {
        x = 2;
    }
}
