package br.com.fiap.core.usecase;

import br.com.fiap.core.domain.model.ProdutoCategoria;
import br.com.fiap.core.domain.model.response.ProdutoResponse;
import br.com.fiap.core.port.in.ProdutoLoadInputPort;
import br.com.fiap.core.port.out.ProdutoLoadOutputPort;

import java.util.List;

public class ProdutoLoadUseCase implements ProdutoLoadInputPort {

    private final ProdutoLoadOutputPort produtoLoadOutputPort;

    public ProdutoLoadUseCase(ProdutoLoadOutputPort produtoLoadOutputPort) {
        this.produtoLoadOutputPort = produtoLoadOutputPort;
    }

    @Override
    public ProdutoResponse loadById(int id) {
        return produtoLoadOutputPort.loadById(id);
    }

    @Override
    public List<ProdutoResponse> loadByCategoria(ProdutoCategoria categoria) {
        return produtoLoadOutputPort.loadByCategoria(categoria);
    }

    @Override
    public List<ProdutoResponse> loadAll() {
        return produtoLoadOutputPort.loadAll();
    }
}
