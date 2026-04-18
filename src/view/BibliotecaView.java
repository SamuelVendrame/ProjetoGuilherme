package view;

import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.util.List;

public class BibliotecaView {

    public void exibirTitulo(String titulo) {
        System.out.println("\n=== " + titulo + " ===");
    }

    public void exibirLivros(List<Livro> livros) {
        exibirTitulo("Livros Cadastrados");
        livros.forEach(System.out::println);
    }

    public void exibirAlunos(List<Aluno> alunos) {
        exibirTitulo("Alunos Cadastrados");
        alunos.forEach(System.out::println);
    }

    public void exibirEmprestimosAtivos(List<Emprestimo> emprestimos) {
        exibirTitulo("Emprestimos Ativos");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo ativo no momento.");
        } else {
            emprestimos.forEach(System.out::println);
        }
    }

    public void exibirAlunosComPendencias(List<Aluno> alunos) {
        exibirTitulo("Alunos com Livros em Aberto");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno com pendencias.");
        } else {
            alunos.forEach(System.out::println);
        }
    }

    public void exibirEmprestimoRealizado(Emprestimo emprestimo) {
        System.out.println("Emprestimo realizado com sucesso: " + emprestimo);
    }

    public void exibirDevolucaoRealizada(String tituloLivro, int quantidade) {
        System.out.println("Devolucao registrada. Quantidade disponivel de '" + tituloLivro + "': " + quantidade);
    }

    public void exibirErro(String mensagem) {
        System.out.println("Erro esperado: " + mensagem);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
