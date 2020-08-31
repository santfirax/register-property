package com.smolano.registerproperty.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RegisterControllerAdviceImpl implements IRegisterControllerAdvice {
    @Override
    public ResponseEntity<String> parameterNotFound(MissingServletRequestParameterException missingServletRequestParameterException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(missingServletRequestParameterException.getMessage());
    }

    @Override
    public ResponseEntity<String> generalException(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(runtimeException.getMessage());
    }
}
