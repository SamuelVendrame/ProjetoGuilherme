package model;

public class Produto {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(String nome, String descricao, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome do produto nao pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("preco do produto deve ser maior que zero.");
        }
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome='" + nome + "', preco=R$" + String.format("%.2f", preco) + "}";
    }
}
