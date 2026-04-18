package model;

public class Aluno {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno nao pode ser vazio.");
        }
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matricula do aluno nao pode ser vazia.");
        }
        this.id = contadorId++;
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", nome='" + nome + "', matricula='" + matricula + "'}";
    }
}
