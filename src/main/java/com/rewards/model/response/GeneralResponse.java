package com.rewards.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class GeneralResponse<T> {
    private Boolean success;
    private List<String> errors;
    private T data;



    public static ResponseEntity<GeneralResponse<Object>> buildSuccessfulResponse (Object data) {
        return new ResponseEntity<>(
                GeneralResponse.builder()
                        .success(true)
                        .errors(null)
                        .data(data)
                        .build(),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<GeneralResponse<Object>> buildFailedResponse (List<Exception> errors) {
        return new ResponseEntity<>(
                GeneralResponse.builder()
                        .success(false)
                        .errors(errors.stream().map(Throwable::getMessage).toList())
                        .data(null)
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    public static ResponseEntity<GeneralResponse<Object>> buildFailedResponse (List<Exception> errors, HttpStatus status) {
        return new ResponseEntity<>(
                GeneralResponse.builder()
                        .success(false)
                        .errors(errors.stream().map(Throwable::getMessage).toList())
                        .data(null)
                        .build(),
                status
        );
    }

}
