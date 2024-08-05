package br.com.fiap.core.domain.model.request;

import br.com.fiap.core.domain.model.ProdutoCategoria;

public record ProdutoCreateRequest(
        ProdutoCategoria categoria,
        String nome,
        String descricao,
        double preco
) {
}