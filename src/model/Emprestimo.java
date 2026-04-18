package model;

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
        if (devolvido) {
            throw new IllegalStateException("Este emprestimo ja foi devolvido.");
        }
        this.dataDevolucao = LocalDate.now();
        this.devolvido = true;
        livro.incrementarQuantidade();
    }

    public int getId() { return id; }
    public Livro getLivro() { return livro; }
    public Aluno getAluno() { return aluno; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }

    @Override
    public String toString() {
        return "Emprestimo{id=" + id +
                ", livro='" + livro.getTitulo() +
                "', aluno='" + aluno.getNome() +
                "', dataEmprestimo=" + dataEmprestimo +
                ", devolvido=" + devolvido + "}";
    }
}
