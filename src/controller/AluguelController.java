package controller;

import model.Cliente;
import model.Horario;
import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    private List<Aluguel> alugueis = new ArrayList<>();

    public Aluguel registrarAluguel(String nome, String telefone,
                                    String inicio, String fim) {

        Cliente cliente = new Cliente(nome, telefone);
        Horario horario = new Horario(inicio, fim);
        Aluguel aluguel = new Aluguel(cliente, horario);

        alugueis.add(aluguel);

        return aluguel;
    }

    public List<Aluguel> listar() {
        return alugueis;
    }

    public double faturamento() {
        double total = 0;
        for (Aluguel a : alugueis) {
            if (a.status.equals("finalizado")) {
                total += a.valor;
            }
        }
        return total;
    }
}