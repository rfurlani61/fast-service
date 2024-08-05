package br.com.fiap.adapter.web.exception;

import br.com.fiap.core.domain.model.response.AppResponse;
import br.com.fiap.core.domain.model.response.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppResponse<Void>> handleException(HttpServletRequest request, Exception ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        AppResponse<Void> response = ResponseUtil.error(errors,
                "Ocorreu um erro",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURL().toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<AppResponse<Void>> handleValidationException(HttpServletRequest request, ValidationException ex) {
        AppResponse<Void> response = ResponseUtil.error(ex.getLocalizedMessage(),
                "Erro de validação",
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURL().toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}