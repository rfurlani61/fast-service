package br.com.fiap.core.domain.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public ClienteNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
