package br.com.fiap.adapter.repository.model;

import br.com.fiap.core.domain.model.Produto;
import br.com.fiap.core.domain.model.ProdutoCategoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "produto")
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_categoria_nome", columnNames = { "categoria", "nome" }) })
public class ProdutoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    ProdutoCategoria categoria;
    @Column(nullable = false)
    String nome;
    String descricao;
    @Column(nullable = false)
    double preco;

    public ProdutoJpa(ProdutoCategoria categoria, String nome, String descricao, double preco) {
        this.id = null;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
