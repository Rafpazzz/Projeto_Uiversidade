/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplicacao_cadastro_alunos;
import java.time.LocalDate;
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
    public boolean validarData(String data);
    public boolean verificaPreenchimento(String matricula, String nome, String telefone, String cpf);
    public int calcularIdade(LocalDate dataNascimento);
    public boolean verificaExistencia(List alunos,Aluno AlunoVerificar);
    public void inserirAluno(List alunos, Aluno alunoInserir);
    public void removerAluno(List<Aluno> alunos, String matricula);
    public Aluno pesquisarAluno(List<Aluno> alunos, String matricula);
    public void ordenarListaAluno (List alunos);
}
