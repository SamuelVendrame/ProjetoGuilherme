package model;

public class Cliente {

    public Long id;
    public String nome;
    public String telefone;

    public Cliente(String nome, String telefone){
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }

        this.nome = nome;

        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
