package br.com.fiap.core.usecase;

import br.com.fiap.core.domain.model.Produto;
import br.com.fiap.core.domain.model.request.ProdutoCreateRequest;
import br.com.fiap.core.domain.model.response.ProdutoResponse;
import br.com.fiap.core.port.in.ProdutoCreateInputPort;
import br.com.fiap.core.port.out.ProdutoSaveOutputPort;

public class ProdutoCreateUseCase implements ProdutoCreateInputPort {

    private final ProdutoSaveOutputPort produtoSaveOutputPort;


    public ProdutoCreateUseCase(ProdutoSaveOutputPort produtoSaveOutputPort) {
        this.produtoSaveOutputPort = produtoSaveOutputPort;
    }

    @Override
    public ProdutoResponse create(ProdutoCreateRequest produtoCreateRequest) {

        var produto = new Produto(
                produtoCreateRequest.categoria(),
                produtoCreateRequest.nome(),
                produtoCreateRequest.descricao(),
                produtoCreateRequest.preco()
        );

        return produtoSaveOutputPort.save(produto);
    }
}
