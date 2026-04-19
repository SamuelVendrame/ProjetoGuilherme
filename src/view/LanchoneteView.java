package view;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.time.LocalDate;
import java.util.List;

public class LanchoneteView {

    public void exibirTitulo(String titulo) {
        System.out.println("\n -- " + titulo + " --");
    }

    public void exibirProdutos(List<Produto> produtos) {
        exibirTitulo("Produtos cadastrados");
        produtos.forEach(System.out::println);
    }

    public void exibirItensDoPedido(Pedido pedido) {
        exibirTitulo("itens do pedido-" + pedido.getId());
        pedido.getItens().forEach(System.out::println);
        System.out.println("total parcial: R$" + String.format("%.2f", pedido.getValorTotal()));
    }

    public void exibirPedidoFinalizado(Pedido pedido) {
        System.out.println("Pedido finalizado: " + pedido);
    }

    public void exibirPedidoAberto(Pedido pedido) {
        System.out.println("Pedido aberto: " + pedido);
    }

    public void exibirPedidosPorData(List<Pedido> pedidos, LocalDate data) {
        exibirTitulo("Pedidos de " + data);
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado para esta data.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }

    public void exibirFaturamento(LocalDate data, double valor) {
        System.out.println("Faturamento total em " + data + " (pedidos finalizados): R$" + String.format("%.2f", valor));
    }

    public void exibirErro(String mensagem) {
        System.out.println("Erro esperado: " + mensagem);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
