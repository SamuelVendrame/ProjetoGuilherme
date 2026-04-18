
public class Livro {
    private static int contadorId = 1;
    private int id;
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidadeDisponivel) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            if (quantidadeDisponivel < 0) {
                throw new IllegalArgumentException("Quantidade disponível não pode ser negativa.");
            } else {
                this.id = contadorId++;
                this.titulo = titulo;
                this.autor = autor;
                this.quantidadeDisponivel = quantidadeDisponivel;
            }
        } else {
            throw new IllegalArgumentException("Título do livro não pode ser vazio.");
        }
    }

    public void decrementarQuantidade() {
        if (this.quantidadeDisponivel <= 0) {
            throw new IllegalStateException("Livro indisponível para empréstimo.");
        } else {
            --this.quantidadeDisponivel;
        }
    }

    public void incrementarQuantidade() {
        ++this.quantidadeDisponivel;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getQuantidadeDisponivel() {
        return this.quantidadeDisponivel;
    }

    public String toString() {
        return "Livro{id=" + this.id + ", titulo='" + this.titulo + "', autor='" + this.autor + "', disponivel=" + this.quantidadeDisponivel + "}";
    }
}