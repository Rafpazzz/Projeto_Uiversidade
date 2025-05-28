/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplicacao_cadastro_alunos;

import aplicacao_cadastro_alunos.Aluno;
import java.util.List;



/**
 *
 * @author rafae
 */
public interface AlunoDAO1 {
    public boolean isEmpty(List alunos);
    public boolean verificaExistencia(List alunos, Aluno a);
    public void inserirAluno(List alunos, Aluno a);
    public void removerAluno(List alunos, Aluno a);
    public void pesquisarAluno(List alunos, String matricula);
    public void ordenarListaAluno(List alunos);
}
