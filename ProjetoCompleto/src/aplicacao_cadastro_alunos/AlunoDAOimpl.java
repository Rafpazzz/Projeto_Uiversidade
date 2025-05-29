
package aplicacao_cadastro_alunos;

<<<<<<< HEAD
import javax.swing.JOptionPane;
=======

import aplicacao_cadastro_alunos.Aluno;
import aplicacao_cadastro_alunos.View;

>>>>>>> main
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextArea;


/**
 *
 * @author joaoa
 */
public class AlunoDAOimpl implements AlunoDAO{
    
    View banco = new View();
    
    @Override
    public boolean isEmpty(List alunos){ //verifica se vazia
       return alunos.isEmpty();
    }
    
    @Override
    public boolean verificaExistencia(List alunos,Aluno AlunoVerificar){
        
        if(isEmpty(alunos)){
            JOptionPane.showMessageDialog(null,"Mensagem de Erro" ,"A lista está vazia, nao foi possivel concluir sua operação",JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        else{
            int i;
            for(i = 0; i < alunos.size(); i++){
                Aluno alunoAtual = (Aluno) alunos.get(i);
                if(alunoAtual.getMatricula().equals(AlunoVerificar.getMatricula())){
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null,"Notificação do Sistema","Aluno não encontrado na lista",JOptionPane.ERROR_MESSAGE);
            return false;
        }
           
    }
    
    public void inserirAluno(List alunos, Aluno alunoInserir){
       if(alunos.contains(alunoInserir)){
<<<<<<< HEAD
           JOptionPane.showMessageDialog(null,"Esse Aluno ja existe no sistema!","Notificação do Sistema",JOptionPane.ERROR_MESSAGE);
       }
       else{
           alunos.add(alunoInserir);
           JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
=======
            System.out.println("Aluno ja existe no sistema");
        }
       else{
           alunos.add(alunoInserir);
           banco.inserir(banco.conectar(), alunoInserir);
           System.out.println("");
>>>>>>> main
       }
    }
    
    public void removerAluno(List alunos, Aluno a){
        for(int i = 0; i<alunos.size(); i++) {
            if(alunos.contains(a)) {
                alunos.remove(a);
<<<<<<< HEAD
                JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
=======
                banco.remover(banco.conectar(), a.getMatricula());
>>>>>>> main
                break;
            }else{
                JOptionPane.showMessageDialog(null,"MENSAGEM DE ERRO","Não foi possível deletar pois, o aluno não foi encontrado na lista.",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void pesquisarAluno(List alunos, Aluno alunoPesquisar,JTextArea resultadoArea){
        if(verificaExistencia(alunos, alunoPesquisar)){
            resultadoArea.setText("Aluno encontrado!\n");
            resultadoArea.append("Nome: " + alunoPesquisar.getNome() + "\n");
            resultadoArea.append("Matrícula: " + alunoPesquisar.getMatricula() + "\n");
        }
        else {
           JOptionPane.showMessageDialog(null,"MENSAGEM DE ERRO","Não ha resultados para sua busca. Tente inserir um aluno que está na lista!",JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void ordenarListaAluno(List alunos){
        if(isEmpty(alunos)) {
           JOptionPane.showMessageDialog(null,"MENSAGEM DE ERRO","Voce tentou efetuar uma busca em uma lista vazia",JOptionPane.ERROR_MESSAGE);
        }else {
            Collections.sort(alunos);
        }
    }


    
 }    

    

