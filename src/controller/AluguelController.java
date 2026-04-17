package controller;

import model.Cliente;
import model.Horario;
import model.Aluguel;

public class AluguelController {

    public Aluguel registrarAluguel(String nome, String telefone,
                                    String inicio, String fim) {

        Cliente cliente = new Cliente(nome, telefone);
        Horario horario = new Horario(inicio, fim);
        Aluguel aluguel = new Aluguel(cliente, horario);

        return aluguel;
    }
}