

public class Aluno {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        if (nome != null && !nome.trim().isEmpty()) {
            if (matricula != null && !matricula.trim().isEmpty()) {
                this.id = contadorId++;
                this.nome = nome;
                this.matricula = matricula;
            } else {
                throw new IllegalArgumentException("Matrícula do aluno não pode ser vazia.");
            }
        } else {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio.");
        }
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String toString() {
        return "Aluno{id=" + this.id + ", nome='" + this.nome + "', matricula='" + this.matricula + "'}";
    }
}