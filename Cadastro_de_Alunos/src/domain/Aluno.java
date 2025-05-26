package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private String matricula;
    private int idade;
    private String data;
    private String telefone;
    private char[] cpf = new char [11];
    public Scanner read = new Scanner(System.in);

    public void inscreverAluno() {
        System.out.print("Informe a matricula: ");
        matricula = read.nextLine();
        System.out.print("Informe o nome: ");
        nome = read.nextLine();
        System.out.print("Informe telefone: ");
        telefone = read.nextLine();
        System.out.print("Informe data de nascimento: ");
        data = read.nextLine();
        System.out.print("Informe a idade: ");
        idade = read.nextInt();
        read.nextLine();
        System.out.print("Informe CPF: ");
        cpf = read.nextLine().toCharArray();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(matricula).append(", ");
        sb.append(nome).append(", ");
        sb.append(idade);
        sb.append(data).append(", ");
        sb.append(telefone).append(", ");
        sb.append(Arrays.toString(cpf));
        System.out.println("=========");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char[] getCpf() {
        return cpf;
    }

    public void setCpf(char[] cpf) {
        this.cpf = cpf;
    }
}
