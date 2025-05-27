package domain;

import java.util.List;
import java.util.Scanner;

public class RemocaoAlunoDAO implements AlunoDAO{
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


