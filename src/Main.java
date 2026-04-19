import controller.LanchoneteController;
import model.Pedido;
import model.Produto;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // criando o controller pra gerenciar tudo
        LanchoneteController c = new LanchoneteController();

        // cadastrando os produtos (tudo minusculo pra ir rapido)
        c.cadastrarProduto("x-burguer", "hamburguer com queijo e alface", 18.50);
        c.cadastrarProduto("coca-cola 350ml", "refrigerante gelado", 6.00);
        c.cadastrarProduto("batata frita", "porcao grande crocante", 12.00);

        System.out.println("produtos cadastrados:");
        c.getProdutos().forEach(System.out::println);

        // pegando os produtos da lista pra usar no pedido
        Produto p1 = c.getProdutos().get(0);
        Produto p2 = c.getProdutos().get(1);
        Produto p3 = c.getProdutos().get(2);

        System.out.println("\nabrindo pedido 1 e colocando os itens...");
        Pedido ped1 = c.abrirPedido();
        c.adicionarItemAoPedido(ped1.getId(), p1.getId(), 2);
        c.adicionarItemAoPedido(ped1.getId(), p2.getId(), 2);
        c.adicionarItemAoPedido(ped1.getId(), p3.getId(), 1);

        System.out.println("itens que estao no pedido 1:");
        ped1.getItens().forEach(System.out::println);
        System.out.println("total parcial ate agora: r$" + String.format("%.2f", ped1.getValorTotal()));

        System.out.println("\nfinalizando o pedido 1 agora");
        c.finalizarPedido(ped1.getId());
        System.out.println("pedido finalizado: " + ped1);

        System.out.println("\ntestando erro de finalizar pedido vazio:");
        Pedido ped2 = c.abrirPedido();
        try {
            c.finalizarPedido(ped2.getId());
        } catch (IllegalStateException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\ntentando mexer em pedido que ja fechou:");
        try {
            c.adicionarItemAoPedido(ped1.getId(), p2.getId(), 1);
        } catch (IllegalStateException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\nverificando pedidos de hoje:");
        c.consultarPedidosPorData(LocalDate.now()).forEach(System.out::println);

        System.out.println("\nfaturamento do dia:");
        double fat = c.calcularFaturamentoPorData(LocalDate.now());
        System.out.println("total faturado hoje: r$" + String.format("%.2f", fat));

        System.out.println("\ntestando erro de nome vazio:");
        try {
            c.cadastrarProduto("", "desc", 10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\ntestando erro de preco negativo:");
        try {
            c.cadastrarProduto("suco", "natural", -5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }
    }
}