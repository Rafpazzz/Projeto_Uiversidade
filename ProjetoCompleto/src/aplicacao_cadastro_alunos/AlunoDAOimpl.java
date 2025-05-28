package aplicacao_cadastro_alunos;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import aplicacao_cadastro_alunos.Aluno;
import com.mycompany.aplicacao_cadastro_alunos.AlunoDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author joaoa
 */
public class AlunoDAOimpl implements AlunoDAO{
    
    @Override
    public boolean isEmpty(List alunos){ //verifica se vazia
       return alunos == null || alunos.isEmpty();
    }
    
    @Override
    public boolean verificaExistencia(List alunos,Aluno AlunoVerificar){
        
        if(isEmpty(alunos)){
            System.out.println("Lista Vazia");
            return false; //nao encontrado
        }
      
        else{
            int i;
            for(i = 0; i < alunos.size(); i++){
                Aluno alunoAtual = (Aluno) alunos.get(i);
                if(alunoAtual.getMatricula().equals(AlunoVerificar.getMatricula())){
                    return true;
                }
            }
            
            return false;
        }
           
    }
    
    public void inserirAluno(List alunos, Aluno alunoInserir){
       if(verificaExistencia(alunos,alunoInserir)){
           System.out.println("Aluno existe na lista!");
       }
       else{
           alunos.add(alunoInserir);
           System.out.println("");
       }
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
        //fazer esse
    }
    
    
    //TORNAR ESSA SO UMA >> ORDENAR LISTA QUE RECEBE UMA LISTA E ORDENA (NO INTERFACE)
    public List BuscaMaisNovo(List alunos){
    }
    
    public List BuscaMaisVelho(List alunos){
    }

    
}
