

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 3);
        Livro livro2 = new Livro("O Cortico", "Aluisio Azevedo", 1);
        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        Aluno aluno1 = new Aluno("Carlos Silva", "2024001");
        Aluno aluno2 = new Aluno("Ana Souza", "2024002");
        biblioteca.cadastrarAluno(aluno1);
        biblioteca.cadastrarAluno(aluno2);

        System.out.println("=== Livros cadastrados ===");
        biblioteca.getLivros().forEach(System.out::println);

        System.out.println("\n=== Realizando emprestimos ===");
        Emprestimo emp1 = biblioteca.realizarEmprestimo(livro1.getId(), aluno1.getId());
        System.out.println("Emprestimo realizado: " + emp1);

        Emprestimo emp2 = biblioteca.realizarEmprestimo(livro2.getId(), aluno2.getId());
        System.out.println("Emprestimo realizado: " + emp2);

        System.out.println("\n=== Tentando emprestar livro sem estoque ===");
        try {
            biblioteca.realizarEmprestimo(livro2.getId(), aluno1.getId());
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== Emprestimos ativos ===");
        biblioteca.listarEmprestimosAtivos().forEach(System.out::println);

        System.out.println("\n=== Alunos com livros em aberto ===");
        biblioteca.listarAlunosComEmprestimosAbertos().forEach(System.out::println);

        System.out.println("\n=== Registrando devolucao do emp1 ===");
        biblioteca.registrarDevolucao(emp1.getId());
        System.out.println("Devolucao registrada.");
        System.out.println("Quantidade disponivel de '" + livro1.getTitulo() + "': " + livro1.getQuantidadeDisponivel());

        System.out.println("\n=== Emprestimos ativos apos devolucao ===");
        biblioteca.listarEmprestimosAtivos().forEach(System.out::println);

        System.out.println("\n=== Tentando cadastrar livro com titulo vazio ===");
        try {
            new Livro("", "Autor X", 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== Tentando cadastrar livro com quantidade negativa ===");
        try {
            new Livro("Livro Y", "Autor Y", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
