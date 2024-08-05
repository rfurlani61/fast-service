package br.com.fiap.core.port.in;

import br.com.fiap.core.domain.model.request.ProdutoCreateRequest;
import br.com.fiap.core.domain.model.response.ProdutoResponse;

public interface ProdutoCreateInputPort {
    ProdutoResponse create(ProdutoCreateRequest produtoCreateRequest);
}
