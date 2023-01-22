package com.rewards.service;

import com.rewards.model.request.Request;
import com.rewards.model.request.RewardRequest;
import org.springframework.stereotype.Service;

@Service
public class RoutingService {

    RewardCalcService rewardCalcService;

    public Object getResponse(Request request) {

        if (request.getClass() == RewardRequest.class) {
            return rewardCalcService.calculateReward();
        }

        return null;

    }
}
