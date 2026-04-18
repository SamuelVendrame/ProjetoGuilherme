package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaController {

    private List<Livro> livros;
    private List<Aluno> alunos;
    private List<Emprestimo> emprestimos;

    public BibliotecaController() {
        this.livros = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(String titulo, String autor, int quantidade) {
        livros.add(new Livro(titulo, autor, quantidade));
    }

    public void cadastrarAluno(String nome, String matricula) {
        alunos.add(new Aluno(nome, matricula));
    }

    public Emprestimo realizarEmprestimo(int idLivro, int idAluno) {
        Livro livro = buscarLivroPorId(idLivro);
        Aluno aluno = buscarAlunoPorId(idAluno);

        if (livro == null) throw new IllegalArgumentException("Livro nao encontrado.");
        if (aluno == null) throw new IllegalArgumentException("Aluno nao encontrado.");
        if (livro.getQuantidadeDisponivel() == 0) {
            throw new IllegalStateException("Nao ha exemplares disponiveis para emprestimo.");
        }

        Emprestimo emprestimo = new Emprestimo(livro, aluno);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void registrarDevolucao(int idEmprestimo) {
        Emprestimo emprestimo = emprestimos.stream().filter(e -> e.getId() == idEmprestimo).findFirst().orElseThrow(() -> new IllegalArgumentException("emprestimo nao encontrado."));
        emprestimo.registrarDevolucao();
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimos.stream().filter(e -> !e.isDevolvido()).collect(Collectors.toList());
    }

    public List<Aluno> listarAlunosComEmprestimosAbertos() {
        return emprestimos.stream().filter(e -> !e.isDevolvido()).map(Emprestimo::getAluno).distinct().collect(Collectors.toList());
    }

    public List<Livro> getLivros() { return livros; }
    public List<Aluno> getAlunos() { return alunos; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }

    private Livro buscarLivroPorId(int id) {
        return livros.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    private Aluno buscarAlunoPorId(int id) {
        return alunos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }
}
