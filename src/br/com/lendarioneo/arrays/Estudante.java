package br.com.lendarioneo.arrays;

public class Estudante {
    private String nome;
    private String email;

    public Estudante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public Estudante setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Estudante setEmail(String email) {
        this.email = email;
        return this;
    }
}
