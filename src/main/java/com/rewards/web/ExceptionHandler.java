package com.rewards.web;

import com.rewards.exception.CouldNotFindContent;
import com.rewards.exception.CouldNotFindData;
import com.rewards.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<Response<Object>> handleException(Exception ex) {
        return Response.buildFailedResponse(List.of(ex));
    }

}