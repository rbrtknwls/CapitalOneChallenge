package com.rewards.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardResponseData {
    String Date;
    long totalsport;
    long totalsub;
    long totaltim;
    long totaloth;
}
