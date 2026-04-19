package controller;

import model.Cliente;
import model.Horario;
import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    private List<Aluguel> alugueis = new ArrayList<>();

    public Aluguel registrarAluguel(String nome, String telefone,
                                    String inicio, String fim, double valor) {

        Cliente cliente = new Cliente(nome, telefone);
        Horario horario = new Horario(inicio, fim, valor);
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
            if (a.getStatus().equals("finalizado")) {
                total += a.getValor();
            }
        }
        return total;
    }
}