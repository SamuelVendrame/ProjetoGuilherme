package model;

public class Aluguel {

    private Cliente cliente;
    private Horario horario;
    private String status;

    public Aluguel(Cliente cliente, Horario horario) {
        this.cliente = cliente;
        this.horario = horario;
        this.status = "aberto";
    }

    public void finalizar() {
        if (status.equals("finalizado")) {
            throw new IllegalStateException("nao eh possivel finalizar um aluguel ja finalizado.");
        }
        status = "finalizado";
    }

    public double getValor() { return horario.getValor(); }
    public Cliente getCliente() { return cliente; }
    public Horario getHorario() { return horario; }
    public String getStatus() { return status; }
}