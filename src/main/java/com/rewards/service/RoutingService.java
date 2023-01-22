package com.rewards.service;

import com.rewards.model.request.Request;
import com.rewards.model.request.RewardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;
import java.util.List;

@Service
public class RoutingService {

    @Autowired
    RewardCalcService rewardCalcService;

    public Object route(RewardRequest request) {

        return rewardCalcService.calculateReward(request);


    }
}
