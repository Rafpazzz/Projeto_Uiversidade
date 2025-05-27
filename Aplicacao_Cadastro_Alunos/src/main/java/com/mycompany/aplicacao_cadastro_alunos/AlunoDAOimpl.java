/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacao_cadastro_alunos;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author joaoa
 */
public class AlunoDAOimpl implements AlunoDAO{
    
    public List inserirAluno(List alunos, Aluno a){
        
    }
    
    public List removerAluno(List alunos, Aluno a){
        for(int i = 0; i<alunos.size(); i++) {
            if(alunos.contains(a)) {
                alunos.remove(a);
                break;
            }else{
                throw new RuntimeException("Matricula Invalida");
            }
        }
        return alunos;
    }
        
    
    public List pesquisarAluno(List alunos, String matricula){
                return alunos;

    }
    
    public List BuscaMaisNovo(List alunos){
                return alunos;

    }
    
    public List BuscaMaisVelho(List alunos){
                return alunos;

    }
}
