package br.com.fiap.core.domain.exception;

public class PersistenceException extends RuntimeException {

    public PersistenceException(String errorMessage) {
        super(errorMessage);
    }

    public PersistenceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
