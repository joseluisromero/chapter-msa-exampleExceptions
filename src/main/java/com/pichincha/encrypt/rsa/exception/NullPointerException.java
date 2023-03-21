package com.pichincha.encrypt.rsa.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NullPointerException extends ResponseStatusException {
    public NullPointerException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    @Override
    public HttpHeaders getResponseHeaders() {
        // devolver las cabeceras de la respuesta
        return getResponseHeaders();
    }
}
