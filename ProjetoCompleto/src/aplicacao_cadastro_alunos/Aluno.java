/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacao_cadastro_alunos;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class Aluno {
    private String nome;
    private String matricula;
    private int idade;
    private String data;
    private String telefone;
    private char[] cpf = new char [11];
    public static final Scanner read = new Scanner(System.in);
    
    public Aluno(String nome, String matricula, int idade, String data, String telefone, char[] cpf){
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
        if(cpf.length == 11){
            this.cpf = cpf;
        }
        else{
            System.out.println("CPF deve contar 11 caracteres!");
        }
    }
}
