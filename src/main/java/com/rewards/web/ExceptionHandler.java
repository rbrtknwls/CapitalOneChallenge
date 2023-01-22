package com.rewards.web;

import com.rewards.model.response.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<GeneralResponse<Object>> handleException(Exception ex) {
        return GeneralResponse.buildFailedResponse(List.of(ex));
    }

}