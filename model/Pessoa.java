package model;

import repository.PessoaRepository;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private static int contador = 1;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.id = contador++;
    }
    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}