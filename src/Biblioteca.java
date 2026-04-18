import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return this.livros;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void cadastrarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Emprestimo realizarEmprestimo(int idLivro, int idAluno) {
        Livro livro = this.buscarLivroPorId(idLivro);
        Aluno aluno = this.buscarAlunoPorId(idAluno);
        if (livro == null) {
            throw new IllegalArgumentException("livro nao encontrado.");
        } else if (aluno == null) {
            throw new IllegalArgumentException("aluno nao encontrado.");
        } else if (livro.getQuantidadeDisponivel() == 0) {
            throw new IllegalStateException("N ha exemplares disponiveis para emprestimo.");
        } else {
            Emprestimo emprestimo = new Emprestimo(livro, aluno);
            this.emprestimos.add(emprestimo);
            return emprestimo;
        }
    }

    public void registrarDevolucao(int idEmprestimo) {
        Emprestimo emprestimo = this.emprestimos.stream().filter((e) -> e.getId() == idEmprestimo).findFirst().orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado."));
        emprestimo.getLivro().incrementarQuantidade();
        emprestimo.registrarDevolucao();
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return this.emprestimos.stream().filter((e) -> !e.isDevolvido()).collect(Collectors.toList());
    }

    public List<Aluno> listarAlunosComEmprestimosAbertos() {
        return this.emprestimos.stream().filter((e) -> !e.isDevolvido()).map(Emprestimo::getAluno).distinct().collect(Collectors.toList());
    }

    private Livro buscarLivroPorId(int id) {
        return this.livros.stream().filter((l) -> l.getId() == id).findFirst().orElse(null);
    }

    private Aluno buscarAlunoPorId(int id) {
        return this.alunos.stream().filter((a) -> a.getId() == id).findFirst().orElse(null);
    }
}