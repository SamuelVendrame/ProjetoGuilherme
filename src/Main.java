import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Lanchonete lanchonete = new Lanchonete();

        Produto p1 = new Produto("x-burguer", "hamburguer com queijo e alface", 18.50);
        Produto p2 = new Produto("coca-cola 350ml", "refrigerante gelado", 6.00);
        Produto p3 = new Produto("batata frita", "porcao grande crocante", 12.00);
        lanchonete.cadastrarProduto(p1);
        lanchonete.cadastrarProduto(p2);
        lanchonete.cadastrarProduto(p3);

        System.out.println("produtos cadastrados");
        lanchonete.getProdutos().forEach(System.out::println);

        System.out.println("\nabrindo pedido 1 e adicionando itens");
        Pedido pedido1 = lanchonete.abrirPedido();
        lanchonete.adicionarItemAoPedido(pedido1.getId(), p1.getId(), 2);
        lanchonete.adicionarItemAoPedido(pedido1.getId(), p2.getId(), 2);
        lanchonete.adicionarItemAoPedido(pedido1.getId(), p3.getId(), 1);
        System.out.println("itens do pedido 1:");
        pedido1.getItens().forEach(System.out::println);
        System.out.println("total parcial: r$" + String.format("%.2f", pedido1.getValorTotal()));

        System.out.println("\nfinalizando pedido 1");
        lanchonete.finalizarPedido(pedido1.getId());
        System.out.println(pedido1);

        System.out.println("\nabrindo pedido 2 e tentando finalizar sem itens");
        Pedido pedido2 = lanchonete.abrirPedido();
        try {
            lanchonete.finalizarPedido(pedido2.getId());
        } catch (IllegalStateException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\ntentando adicionar item a pedido ja finalizado");
        try {
            lanchonete.adicionarItemAoPedido(pedido1.getId(), p2.getId(), 1);
        } catch (IllegalStateException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\nconsulta de pedidos de hoje");
        List<Pedido> pedidosHoje = lanchonete.consultarPedidosPorData(LocalDate.now());
        pedidosHoje.forEach(System.out::println);

        System.out.println("\nfaturamento do dia");
        double faturamento = lanchonete.calcularFaturamentoPorData(LocalDate.now());
        System.out.println("faturamento total (pedidos finalizados): r$" + String.format("%.2f", faturamento));

        System.out.println("\ntentando cadastrar produto com nome vazio");
        try {
            new Produto("", "desc", 10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }

        System.out.println("\ntentando cadastrar produto com preco negativo");
        try {
            new Produto("suco", "natural", -5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("erro esperado: " + e.getMessage());
        }
    }
}