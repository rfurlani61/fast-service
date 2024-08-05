package br.com.fiap.core.domain.model;

import java.util.Objects;

public class Produto {

    ProdutoCategoria categoria;
    String nome;
    String descricao;
    double preco;

    public Produto() {
    }

    public Produto(ProdutoCategoria categoria, String nome, String descricao, double preco) {
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ProdutoCategoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Double.compare(preco, produto.preco) == 0 && categoria == produto.categoria && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, nome, descricao, preco);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "categoria=" + categoria +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
