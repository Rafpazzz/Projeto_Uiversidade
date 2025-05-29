/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplicacao_cadastro_alunos;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextArea;



/**
 *
 * @author joaoa
 */
interface AlunoDAO {
    public boolean isEmpty(List alunos);
    public boolean verificaExistencia(List alunos,Aluno AlunoVerificar);
    public void inserirAluno(List alunos, Aluno alunoInserir);
    public void removerAluno(List alunos, Aluno a);
    public void pesquisarAluno(List alunos, Aluno a,JTextArea resultadoArea);
    public void ordenarListaAluno (List alunos);
}
