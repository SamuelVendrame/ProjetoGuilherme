
import java.time.LocalDate;

public class Emprestimo {
    private static int contadorId = 1;
    private int id;
    private Livro livro;
    private Aluno aluno;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Livro livro, Aluno aluno) {
        this.id = contadorId++;
        this.livro = livro;
        this.aluno = aluno;
        this.dataEmprestimo = LocalDate.now();
        this.devolvido = false;
        livro.decrementarQuantidade();
    }

    public void registrarDevolucao() {
        if (this.devolvido) {
            throw new IllegalStateException("Este emprestimo ja foi devolvido.");
        } else {
            this.dataDevolucao = LocalDate.now();
            this.devolvido = true;
            this.livro.incrementarQuantidade();
        }
    }

    public int getId() {return this.id;
    }

    public Livro getLivro() {return this.livro;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean isDevolvido() {
        return this.devolvido;
    }

    public String toString() {
        int var10000 = this.id;
        return "Emprestimo{id=" + var10000 + ", livro='" + this.livro.getTitulo() + "', aluno='" + this.aluno.getNome() + "', dataEmprestimo=" + String.valueOf(this.dataEmprestimo) + ", devolvido=" + this.devolvido + "}";
    }
}