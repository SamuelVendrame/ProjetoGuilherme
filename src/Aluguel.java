public class Aluguel {

    public Cliente cliente;
    public Horario horario;
    public String status = "aberto";
    public double valor = 100.0;

    public Aluguel(Cliente cliente, Horario horario){
        this.cliente = cliente;
        this.horario = horario;
    }

    public void finalizar() {
        if (status.equals("finalizado")) {
            throw new IllegalStateException("nao eh possivel finalizar um aluguel ja finalizado.");
        }
        status = "finalizado";
    }
}