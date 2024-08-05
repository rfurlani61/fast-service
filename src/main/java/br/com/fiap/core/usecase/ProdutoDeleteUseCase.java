package br.com.fiap.core.usecase;

import br.com.fiap.core.port.in.ProdutoDeleteInputPort;
import br.com.fiap.core.port.out.ProdutoDeleteOutputPort;

public class ProdutoDeleteUseCase implements ProdutoDeleteInputPort {

    private final ProdutoDeleteOutputPort produtoDeleteOutputPort;

    public ProdutoDeleteUseCase(ProdutoDeleteOutputPort produtoDeleteOutputPort) {
        this.produtoDeleteOutputPort = produtoDeleteOutputPort;
    }

    @Override
    public void delete(int id) {
        produtoDeleteOutputPort.delete(id);
    }
}
