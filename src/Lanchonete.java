import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lanchonete {

    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public Lanchonete() {
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Pedido abrirPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;
    }

    public void adicionarItemAoPedido(int idPedido, int idProduto, int quantidade) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        Produto produto = buscarProdutoPorId(idProduto);

        if (pedido == null) throw new IllegalArgumentException("Pedido nao encontrado.");
        if (produto == null) throw new IllegalArgumentException("Produto nao encontrado.");

        pedido.adicionarItem(produto, quantidade);
    }

    public void finalizarPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido == null) throw new IllegalArgumentException("Pedido não encontrado.");
        pedido.finalizar();
    }

    public List<Pedido> consultarPedidosPorData(LocalDate data) {
        return pedidos.stream().filter(p -> p.getDataPedido().equals(data)).collect(Collectors.toList());
    }

    public double calcularFaturamentoPorData(LocalDate data) {
        return consultarPedidosPorData(data).stream().filter(p -> p.getStatus().equals("FINALIZADO")).mapToDouble(Pedido::getValorTotal).sum();
    }

    private Pedido buscarPedidoPorId(int id) {
        return pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    private Produto buscarProdutoPorId(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Produto> getProdutos() { return produtos; }
    public List<Pedido> getPedidos() { return pedidos; }
}
