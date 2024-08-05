package br.com.fiap.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Calm down, it's only a test exception :)")
public class TestException extends RuntimeException {

    public TestException(String errorMessage) {
        super(errorMessage);
    }
}
