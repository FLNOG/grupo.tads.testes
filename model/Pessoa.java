package model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setId(int id) { this.id = id; }
}