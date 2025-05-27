/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacao_cadastro_alunos;

import java.util.List;



/**
 *
 * @author rafae
 */
public interface AlunoDAO {
    public List inserirAluno(List alunos, Aluno a);
    public List removerAluno(List alunos, Aluno a);
    public List pesquisarAluno(List alunos, String matricula);
    public List BuscaMaisNovo(List alunos);
    public List BuscaMaisVelho(List alunos);
}
