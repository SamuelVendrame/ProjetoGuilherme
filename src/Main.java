import controller.LanchoneteController;
import model.Pedido;
import model.Produto;
import view.LanchoneteView;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // criando o controller pra gerenciar tudo
        LanchoneteController c = new LanchoneteController();
        LanchoneteView view = new LanchoneteView();

        // cadastrando os produtos (tudo minusculo pra ir rapido)
        c.cadastrarProduto("x-burguer", "hamburguer com queijo e alface", 18.50);
        c.cadastrarProduto("coca-cola 350ml", "refrigerante gelado", 6.00);
        c.cadastrarProduto("batata frita", "porcao grande crocante", 12.00);

        view.exibirProdutos(c.getProdutos());

        Produto p1 = c.getProdutos().get(0);
        Produto p2 = c.getProdutos().get(1);
        Produto p3 = c.getProdutos().get(2);

        view.exibirTitulo("abrindo pedido 1 e colocando os itens");
        Pedido ped1 = c.abrirPedido();
        c.adicionarItemAoPedido(ped1.getId(), p1.getId(), 2);
        c.adicionarItemAoPedido(ped1.getId(), p2.getId(), 2);
        c.adicionarItemAoPedido(ped1.getId(), p3.getId(), 1);
        view.exibirItensDoPedido(ped1);

        view.exibirTitulo("finalizando o pedido 1");
        c.finalizarPedido(ped1.getId());
        view.exibirPedidoFinalizado(ped1);

        view.exibirTitulo("testando erro de finalizar pedido vazio");
        Pedido ped2 = c.abrirPedido();
        try {
            c.finalizarPedido(ped2.getId());
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirTitulo("tentado mexer em pedido que ja fechou");
        try {
            c.adicionarItemAoPedido(ped1.getId(), p2.getId(), 1);
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirPedidosPorData(c.consultarPedidosPorData(LocalDate.now()), LocalDate.now());

        view.exibirFaturamento(LocalDate.now(), c.calcularFaturamentoPorData(LocalDate.now()));
        view.exibirTitulo("testando erro de nome vazio");
        try {
            c.cadastrarProduto("", "desc", 10.0);
        } catch (IllegalArgumentException e) {
         view.exibirErro(e.getMessage());
        }

        view.exibirTitulo("testando erro de preco negativo");
        try {
            c.cadastrarProduto("suco", "natural", -5.0);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }
    }
}