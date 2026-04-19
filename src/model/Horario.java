package model;

public class Horario {

    private String horarioInicio;
    private String horarioFim;
    private double valor;

    public Horario(String horarioInicio, String horarioFim, double valor) {

        if (horarioInicio == null || horarioFim == null || horarioFim.isBlank() || horarioInicio.isBlank()) {
            throw new IllegalArgumentException("Horarios nao podem ser nulos");
        }

        if (horarioInicio.equals(horarioFim)) {
            throw new IllegalArgumentException("model.Horario inicial e final nao podem ser iguais");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }

        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.valor = valor;

    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public double getValor(){return valor;}
}