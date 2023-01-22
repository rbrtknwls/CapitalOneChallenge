package com.rewards.web;

import com.rewards.model.response.GeneralResponse;
import com.rewards.model.request.RewardRequest;
import com.rewards.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.ServiceNotFoundException;

@RestController
@RequestMapping(value = "/v1/")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    RoutingService routingService;
    @GetMapping(value = "/getReward")
    public ResponseEntity<GeneralResponse<Object>> getDateAndTime(@RequestBody RewardRequest request)  {

        return GeneralResponse.buildSuccessfulResponse(routingService.route(request));
    }
}