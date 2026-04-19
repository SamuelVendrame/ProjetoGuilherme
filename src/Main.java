import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Aluguel> alugueis = new ArrayList<>();

        System.out.println("clientes cadastrados:\n");
        Cliente c1 = new Cliente("Samuel Vendrame", "11999999999");
        Cliente c2 = new Cliente("Maria Silva", "11988888888");

        System.out.println("cliente{nome='" + c1.getNome() + "', telefone='" + c1.getTelefone() + "'}");
        System.out.println("cliente{nome='" + c2.getNome() + "', telefone='" + c2.getTelefone() + "'}");

        System.out.println("\nabrindo aluguel 1...\n");

        Horario h1 = new Horario("19:00", "20:00");
        Aluguel a1 = new Aluguel(c1, h1);
        alugueis.add(a1);

        System.out.println("aluguel criado:");
        System.out.println("aluguel{cliente='" + a1.cliente.getNome() +
                "', horario=" + a1.horario.getHorarioInicio() + "-" + a1.horario.getHorarioFim() + ", status='" + a1.status + "', total=r$100,00}");

        System.out.println("\nfinalizando aluguel 1...\n");

        a1.finalizar();

        System.out.println("aluguel finalizado:");
        System.out.println("aluguel{cliente='" + a1.cliente.getNome() +
                "', horario=" + a1.horario.getHorarioInicio() + "-" + a1.horario.getHorarioFim() + ", status='" + a1.status + "', total=r$100,00}");

        System.out.println("\ntentando finalizar novamente:\n");
        try {
            a1.finalizar();
        } catch (Exception e) {
            System.out.println("erro esperado: " + e.getMessage());}

        System.out.println("\nabrindo aluguel 2...\n");

        Horario h2 = new Horario("20:00", "21:00");
        Aluguel a2 = new Aluguel(c2, h2);
        alugueis.add(a2);

        System.out.println("aluguel{cliente='" + a2.cliente.getNome() + "', horario=" + a2.horario.getHorarioInicio() + "-" + a2.horario.getHorarioFim() + ", status='" + a2.status + "', total=r$100,00}");

        System.out.println("\nverificando alugueis:\n");

        for (Aluguel a : alugueis) {
            System.out.println("aluguel{cliente='" + a.cliente.getNome() + "', horario=" + a.horario.getHorarioInicio() + "-" + a.horario.getHorarioFim() + ", status='" + a.status + "', total=r$100,00}");
        }

        System.out.println("\nfaturamento do dia:\n");
        double total = 0;
        for (Aluguel a : alugueis) {
            if (a.status.equals("finalizado")) {
                total += a.valor;
            }
        }

        System.out.println("total faturado hoje: r$" + String.format("%.2f", total));

        System.out.println("\ntestando erro de nome vazio:\n");

        try {
            Cliente erro = new Cliente("", "123");
        } catch (Exception e) {
            System.out.println("erro esperado: " + e.getMessage());}

        System.out.println("\ntestando erro de horario invalido:\n");

        try {
            Horario erro = new Horario("20:00", "20:00");
        }catch (Exception e) {System.out.println("erro esperado: " + e.getMessage());}

    }
}