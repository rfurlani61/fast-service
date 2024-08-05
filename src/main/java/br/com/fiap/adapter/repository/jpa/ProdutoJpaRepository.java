package br.com.fiap.adapter.repository.jpa;

import br.com.fiap.adapter.repository.model.ProdutoJpa;
import br.com.fiap.core.domain.model.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoJpa, Integer> {
    List<ProdutoJpa> findByCategoria(ProdutoCategoria categoria);
}
