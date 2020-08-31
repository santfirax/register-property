package com.smolano.registerproperty.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IRegisterControllerAdvice {
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    ResponseEntity<String> parameterNotFound(MissingServletRequestParameterException missingServletRequestParameterException);
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> generalException(RuntimeException runtimeException);


}
