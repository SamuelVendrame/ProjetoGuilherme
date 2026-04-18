import controller.BibliotecaController;
import model.Emprestimo;
import model.Livro;
import view.BibliotecaView;

public class Main {

    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        BibliotecaView view = new BibliotecaView();

        controller.cadastrarLivro("Dom Casmurro", "Machado de Assis", 3);
        controller.cadastrarLivro("O Cortico", "Aluisio Azevedo", 1);

        controller.cadastrarAluno("Carlos Silva", "2024001");
        controller.cadastrarAluno("Ana Souza", "2024002");

        view.exibirLivros(controller.getLivros());
        view.exibirAlunos(controller.getAlunos());

        view.exibirTitulo("Realizando Emprestimos");

        int idLivro1 = controller.getLivros().get(0).getId();
        int idLivro2 = controller.getLivros().get(1).getId();
        int idAluno1 = controller.getAlunos().get(0).getId();
        int idAluno2 = controller.getAlunos().get(1).getId();

        Emprestimo emp1 = controller.realizarEmprestimo(idLivro1, idAluno1);
        view.exibirEmprestimoRealizado(emp1);

        Emprestimo emp2 = controller.realizarEmprestimo(idLivro2, idAluno2);
        view.exibirEmprestimoRealizado(emp2);

        view.exibirTitulo("Tentando Emprestar Livro sem Estoque");
        try {
            controller.realizarEmprestimo(idLivro2, idAluno1);
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirEmprestimosAtivos(controller.listarEmprestimosAtivos());
        view.exibirAlunosComPendencias(controller.listarAlunosComEmprestimosAbertos());

        view.exibirTitulo("Registrando Devolucao");
        controller.registrarDevolucao(emp1.getId());
        Livro livro1 = controller.getLivros().get(0);
        view.exibirDevolucaoRealizada(livro1.getTitulo(), livro1.getQuantidadeDisponivel());

        view.exibirEmprestimosAtivos(controller.listarEmprestimosAtivos());

        view.exibirTitulo("Tentando Cadastrar Livro com Titulo Vazio");
        try {
            controller.cadastrarLivro("", "Autor X", 2);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirTitulo("Tentando Cadastrar Livro com Quantidade Negativa");
        try {
            controller.cadastrarLivro("Livro Y", "Autor Y", -5);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }
    }
}
