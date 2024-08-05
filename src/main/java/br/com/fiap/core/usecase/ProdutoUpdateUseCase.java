package br.com.fiap.core.usecase;

import br.com.fiap.core.domain.model.Produto;
import br.com.fiap.core.domain.model.request.ProdutoUpdateRequest;
import br.com.fiap.core.domain.model.response.ProdutoResponse;
import br.com.fiap.core.port.in.ProdutoUpdateInputPort;
import br.com.fiap.core.port.out.ProdutoSaveOutputPort;
import br.com.fiap.core.port.out.ProdutoUpdateOutputPort;

public class ProdutoUpdateUseCase implements ProdutoUpdateInputPort {

    private final ProdutoUpdateOutputPort produtoUpdateOutputPort;

    public ProdutoUpdateUseCase(ProdutoUpdateOutputPort produtoUpdateOutputPort) {
        this.produtoUpdateOutputPort = produtoUpdateOutputPort;
    }

    @Override
    public ProdutoResponse update(ProdutoUpdateRequest produtoUpdateRequest) {
        return produtoUpdateOutputPort.update(produtoUpdateRequest);
    }
}
