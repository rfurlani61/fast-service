package br.com.fiap.adapter.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cliente")
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_cpf", columnNames = { "cpf" }) })
public class ClienteJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(nullable = false)
    private String cpf;
    private String email;

    public ClienteJpa(String nome, String cpf, String email) {
        this.id = null;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
