package aplicacao_cadastro_alunos;


import aplicacao_cadastro_alunos.Aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author joaoa
 */
public class AlunoDAOimpl implements AlunoDAO1{
    
    @Override
    public boolean isEmpty(List alunos){ //verifica se vazia
       return alunos.isEmpty();
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
       if(alunos.contains(alunoInserir)){
                    System.out.println("Aluno ja existe no sistema");
                }
       else{
           alunos.add(alunoInserir);
           System.out.println("");
       }
    }
    
    public void removerAluno(List alunos, Aluno a){
        for(int i = 0; i<alunos.size(); i++) {
            if(alunos.contains(a)) {
                alunos.remove(a);
                break;
            }else{
                throw new RuntimeException("Matricula Invalida");
            }
        }
    }
    
    public void pesquisarAluno(List alunos, String matricula){
        
       System.out.print("aaaaa");
    }
    
    //TORNAR ESSA SO UMA >> ORDENAR LISTA QUE RECEBE UMA LISTA E ORDENA (NO INTERFACE)
    public void ordenarListaAluno (List alunos){
        if(isEmpty(alunos)) {
            throw new RuntimeException("Lista nao criada ou vazia");
        }else {
            Collections.sort(alunos);
        }
    }    
    
}
