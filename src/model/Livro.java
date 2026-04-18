package model;

public class Livro {

    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidadeDisponivel) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo do livro nao pode ser vazio.");
        }
        if (quantidadeDisponivel < 0) {
            throw new IllegalArgumentException("Quantidade disponivel nao pode ser negativa.");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void decrementarQuantidade() {
        if (quantidadeDisponivel <= 0) {
            throw new IllegalStateException("Livro indisponivel para emprestimo.");
        }
        quantidadeDisponivel--;
    }

    public void incrementarQuantidade() {
        quantidadeDisponivel++;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }

    @Override
    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "', disponivel=" + quantidadeDisponivel + "}";
    }
}
