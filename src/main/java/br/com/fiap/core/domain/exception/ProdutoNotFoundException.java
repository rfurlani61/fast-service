package br.com.fiap.core.domain.exception;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public ProdutoNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
