/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacao_cadastro_alunos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class RemocaoAlunoDAO implements AlunoDAO {
    Scanner read = new Scanner(System.in);

    @Override
    public List removerAluno(List alunos, Aluno a) {

        for(int i = 0; i<alunos.size(); i++) {
            if(alunos.contains(a)) {
                alunos.remove(a);
                break;
            }else{
                throw new RuntimeException("Matricula Invalida");
            }
        }

        return List.of();
    }
}
