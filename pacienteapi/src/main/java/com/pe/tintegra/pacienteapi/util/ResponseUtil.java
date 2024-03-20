package com.pe.tintegra.pacienteapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<T> handleSuccess(T body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<String> handleError(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(message);
    }
}
