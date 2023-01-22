package com.rewards.web;

import com.rewards.model.Response;
import com.rewards.model.request.RewardRequest;
import com.rewards.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    RoutingService routingService;
    @GetMapping(value = "/getReward")
    public ResponseEntity<Response<Object>> getDateAndTime(@RequestBody RewardRequest rewardRequest) {

        return Response.buildSuccessfulResponse(routingService.getResponse(rewardRequest));
    }
}