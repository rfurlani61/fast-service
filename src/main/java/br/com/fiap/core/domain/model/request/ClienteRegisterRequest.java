package br.com.fiap.core.domain.model.request;

public record ClienteRegisterRequest(
        String nome,
        String cpf,
        String email
) {
}