package br.com.fiap.core.domain.exception;

public class CpfInvalidException extends RuntimeException {

    public CpfInvalidException(String errorMessage) {
        super(errorMessage);
    }

    public CpfInvalidException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
