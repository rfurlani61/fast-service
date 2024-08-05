package br.com.fiap.core.domain.model.response;

public class ClienteResponse {
    int id;
    String nome;
    String cpf;
    String email;
    String path;

    public ClienteResponse() {
    }

    public ClienteResponse(int id, String nome, String cpf, String email, String path) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}