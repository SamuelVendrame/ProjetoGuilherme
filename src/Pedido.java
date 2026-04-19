import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contadorId = 1;

    private int id;
    private List<ItemPedido> itens;
    private LocalDate dataPedido;
    private String status;

    public Pedido() {
        this.id = contadorId++;
        this.itens = new ArrayList<>();
        this.dataPedido = LocalDate.now();
        this.status = "ABERTO";
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (status.equals("FINALIZADO")) {
            throw new IllegalStateException("Nao eh possível adicionar itens a um pedido finalizado.");
        }
        itens.add(new ItemPedido(produto, quantidade));
    }

    public void finalizar() {
        if (status.equals("FINALIZADO")) {
            throw new IllegalStateException("Este pedido já foi finalizado.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("nao e possivel finalizar um pedido sem itens");
        }
        this.status = "FINALIZADO";
    }

    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public int getId() { return id; }
    public List<ItemPedido> getItens() { return itens; }
    public LocalDate getDataPedido() { return dataPedido; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Pedido{ id = " + id + ", data = " + dataPedido + ", status = '" + status + "', total = R$" + String.format("%.2f", getValorTotal()) + ", itens=" + itens.size() + "}";
    }
}
