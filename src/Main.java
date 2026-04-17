import java.util.Scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite horario de início: ");
        String inicio = scanner.nextLine();

        System.out.print("Digite horario de fim: ");
        String fim = scanner.nextLine();

        Cliente cliente = new Cliente(nome, telefone);
        Horario horario = new Horario(inicio, fim);
        Aluguel aluguel = new Aluguel(cliente, horario);

        System.out.println("\n=== Reserva ===");
        System.out.println("cliente: " + cliente.getNome());
        System.out.println("telefone: " + cliente.getTelefone());
        System.out.println("horário: " + horario.getHorarioInicio() + " às " + horario.getHorarioFim());
        System.out.println("valor Total: R$ 100 ");

        scanner.close();
    }
