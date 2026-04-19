public class ItemPedido {

    private static int contadorId = 1;

    private int id;
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (quantidade < 1) {
            throw new IllegalArgumentException("Quantidade deve ser pelo menos 1.");
        }
        this.id = contadorId++;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public int getId() { return id; }
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return "ItemPedido{produto='" + produto.getNome() + "', quantidade=" + quantidade + ", subtotal=R$" + String.format("%.2f", getSubtotal()) + "}";
    }
}
