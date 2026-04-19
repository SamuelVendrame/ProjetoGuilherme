package view;

import controller.AluguelController;
import model.Aluguel;

public class ReservarView {

    public void iniciar() {

        AluguelController controller = new AluguelController();

        System.out.println("clientes cadastrados:\n");

        Aluguel a1 = controller.registrarAluguel("samuel vendrame", "11999999999", "19:00", "20:00", 100.0);
        Aluguel a2 = controller.registrarAluguel("maria silva", "11988888888", "20:00", "21:00", 100.0);

        System.out.println("cliente{nome='" + a1.getCliente().getNome() + "', telefone='" + a1.getCliente().getTelefone() + "'}");
        System.out.println("cliente{nome='" + a2.getCliente().getNome() + "', telefone='" + a2.getCliente().getTelefone() + "'}");

        System.out.println("\nabrindo aluguel 1...\n");
        System.out.println("aluguel criado:");
        System.out.println("aluguel{cliente='" + a1.getCliente().getNome() + "', horario=" + a1.getHorario().getHorarioInicio() + "-" + a1.getHorario().getHorarioFim() + ", status='" + a1.getStatus() + "', total=r$100,00}");

        System.out.println("\nfinalizando aluguel 1...\n");

        a1.finalizar();
        System.out.println("aluguel finalizado:");
        System.out.println("aluguel{cliente='" + a1.getCliente().getNome() + "', horario=" + a1.getHorario().getHorarioInicio() + "-" + a1.getHorario().getHorarioFim() + ", status='" + a1.getStatus() + "', total=r$100,00}");


        System.out.println("\ntentando finalizar novamente:\n");

        try{a1.finalizar();
        } catch (Exception e) {
            System.out.println("erro esperado: " + e.getMessage());
        }
        System.out.println("\nverificando alugueis:\n");


        for(Aluguel a : controller.listar()) {
            System.out.println("aluguel{cliente='" + a.getCliente().getNome() + "', horario=" + a.getHorario().getHorarioInicio() + "-" + a.getHorario().getHorarioFim() + ", status='" + a.getStatus() + "', total=r$100,00}");
        }

        System.out.println("\nfaturamento do dia:\n");
        System.out.println("total faturado hoje: r$" + String.format("%.2f", controller.faturamento()));
        System.out.println("\ntestando erro de nome vazio:\n");

        try {
            controller.registrarAluguel("", "123", "10:00", "11:00", 100.0);
        } catch (Exception e) {
            System.out.println("erro : " + e.getMessage());
        }
        System.out.println("\ntestando erro de horario invalido:\n");
        try {
            controller.registrarAluguel("joao", "999", "20:00", "20:00", 100.0);
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}