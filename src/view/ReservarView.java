package view;

import java.util.Scanner;

public class ReservarView {

    Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        try{
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite horario de início: ");
        String inicio = scanner.nextLine();

        System.out.print("Digite horário de fim: ");
        String fim = scanner.nextLine();

        System.out.println("\nReserva solicitada com sucesso:");
        System.out.println("Cliente: " + nome);
        System.out.println("telefone: " + telefone);
        System.out.println("horario: " + inicio + " às " + fim);
        System.out.println("Preço: 100R$");

    } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
    }
    }
}