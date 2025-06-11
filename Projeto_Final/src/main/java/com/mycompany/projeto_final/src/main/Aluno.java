package com.mycompany.projeto_final.src.main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "Alunos")
public class Aluno implements Comparable<Aluno> {

    @Id
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private int idade;
    @Column(name = "data_nas")
    private LocalDate data;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "cpf")
    private char[] cpf = new char[11];
    
    public Aluno() {}

    public Aluno(String nome, String matricula, int idade, LocalDate data, String telefone, char[] cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.data = data;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(matricula).append(", ");
        sb.append(nome).append(", ");
        sb.append(idade).append(", ");
        sb.append(data).append(", ");
        sb.append(telefone).append(", ");
        sb.append(Arrays.toString(cpf));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public int compareTo(Aluno o) {
        if (this.getIdade() < o.getIdade()) {
            return -1;
        } else if (this.getIdade() == o.getIdade()) {
            return 0;
        } else {
            return 1;
        }
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
        if (cpf.length == 11) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF deve contar 11 caracteres!");
        }
    }
}
