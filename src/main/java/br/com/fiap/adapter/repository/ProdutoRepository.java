package br.com.fiap.adapter.repository;

import br.com.fiap.adapter.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.adapter.repository.mapper.ProdutoMapper;
import br.com.fiap.core.domain.exception.ClienteNotFoundException;
import br.com.fiap.core.domain.exception.PersistenceException;
import br.com.fiap.core.domain.exception.ProdutoNotFoundException;
import br.com.fiap.core.domain.model.Produto;
import br.com.fiap.core.domain.model.ProdutoCategoria;
import br.com.fiap.core.domain.model.request.ProdutoUpdateRequest;
import br.com.fiap.core.domain.model.response.ProdutoResponse;
import br.com.fiap.core.port.out.ProdutoDeleteOutputPort;
import br.com.fiap.core.port.out.ProdutoLoadOutputPort;
import br.com.fiap.core.port.out.ProdutoSaveOutputPort;
import br.com.fiap.core.port.out.ProdutoUpdateOutputPort;

import java.util.List;

public class ProdutoRepository implements
        ProdutoSaveOutputPort,
        ProdutoUpdateOutputPort,
        ProdutoDeleteOutputPort,
        ProdutoLoadOutputPort {

    private final ProdutoJpaRepository produtoJpaRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoRepository(ProdutoJpaRepository produtoJpaRepository,
                             ProdutoMapper produtoMapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoResponse save(Produto produto) {
        try {
            var produtoJpa = produtoMapper.toProdutoJpa(produto);
            var produtoSaved = produtoJpaRepository.save(produtoJpa);
            return produtoMapper.toProdutoResponse(produtoSaved);
        } catch (RuntimeException ex) {
            throw new PersistenceException("Ocorreu um erro ao tentar processar o cadastro do produto", ex);
        }
    }

    @Override
    public ProdutoResponse update(ProdutoUpdateRequest produtoUpdateRequest) {
        try {
            var produtoJpa = produtoJpaRepository.findById(produtoUpdateRequest.id())
                    .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado (ID: " + produtoUpdateRequest.id() + ")"));

            produtoJpa.setCategoria(produtoUpdateRequest.categoria());
            produtoJpa.setDescricao(produtoUpdateRequest.descricao());
            produtoJpa.setNome(produtoUpdateRequest.nome());
            produtoJpa.setPreco(produtoUpdateRequest.preco());

            produtoJpa = produtoJpaRepository.save(produtoJpa);

            return produtoMapper.toProdutoResponse(produtoJpa);
        } catch (RuntimeException ex) {
            throw new PersistenceException("Ocorreu um erro ao tentar processar a alteração do produto", ex);
        }
    }

    @Override
    public ProdutoResponse loadById(int id) {
        var produto = produtoJpaRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado (ID: " + id + ")"));
        return produtoMapper.toProdutoResponse(produto);
    }

    @Override
    public List<ProdutoResponse> loadByCategoria(ProdutoCategoria categoria) {
        return produtoJpaRepository.findByCategoria(categoria)
                .stream()
                .map(produtoMapper::toProdutoResponse)
                .toList();
    }

    @Override
    public List<ProdutoResponse> loadAll() {
        return produtoJpaRepository.findAll()
                .stream()
                .map(produtoMapper::toProdutoResponse)
                .toList();
    }

    @Override
    public void delete(int id) {
        var produtoJpa = produtoJpaRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado (ID: " + id + ")"));
        produtoJpaRepository.delete(produtoJpa);
    }
}
