package com.rewards.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardResponseData {
    String Date;
    int rule1Count;
    int rule2Count;
    int rule3Count;
    int rule4Count;
    int rule5Count;
    int rule6Count;
    int rule7Count;


}
