package com.logistica.api.infra.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class RestErrorMessage {

    private HttpStatus status;
    private List<String> errors;

    public RestErrorMessage(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public RestErrorMessage(HttpStatus status, String error) {
        this.status = status;
        errors = Arrays.asList(error);
    }

}
