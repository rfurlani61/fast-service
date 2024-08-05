package br.com.fiap.core.port.out;

import br.com.fiap.core.domain.model.ProdutoCategoria;
import br.com.fiap.core.domain.model.response.ProdutoResponse;

import java.util.List;

public interface ProdutoLoadOutputPort {
    ProdutoResponse loadById(int id);

    List<ProdutoResponse> loadByCategoria(ProdutoCategoria categoria);

    List<ProdutoResponse> loadAll();
}
