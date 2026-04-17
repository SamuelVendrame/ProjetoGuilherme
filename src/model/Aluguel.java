package model;

public class Aluguel {

    public Cliente cliente;
    public Horario horario;

    public Aluguel(Cliente cliente, Horario horario){
        this.cliente = cliente;
        this.horario = horario;
    }
}
