package br.com.fiap.core.port.out;

import br.com.fiap.core.domain.model.Produto;
import br.com.fiap.core.domain.model.request.ProdutoUpdateRequest;
import br.com.fiap.core.domain.model.response.ProdutoResponse;

public interface ProdutoUpdateOutputPort {
    ProdutoResponse update(ProdutoUpdateRequest produto);
}
