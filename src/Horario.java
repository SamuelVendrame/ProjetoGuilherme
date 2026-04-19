public class Horario {

    private String horarioInicio;
    private String horarioFim;

    public Horario(String horarioInicio, String horarioFim) {

        if (horarioInicio == null || horarioFim == null || horarioFim.isBlank() || horarioInicio.isBlank()) {
            throw new IllegalArgumentException("horarios nao podem ser nulos");
        }

        if (horarioInicio.equals(horarioFim)) {
            throw new IllegalArgumentException("horario inicial e final nao podem ser iguais");
        }

        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }
}