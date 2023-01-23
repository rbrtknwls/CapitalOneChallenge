package com.rewards.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RewardResponse {
    List<RewardResponseData> rewardResponseData;
    long totalPoints;
}
