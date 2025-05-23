package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formulario {
    List<Aluno> listAlunos = new ArrayList<Aluno>();


    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        int escolha;
        Scanner r = new Scanner(System.in);
        File file = new File("ListagemAlunos.txt");

        do {
            System.out.println("Formulario de alunos");
            System.out.println("[1].Add Aluno");
            System.out.println("[2].Mostrar Alunos");
            System.out.println("[3].Remover Aluno");
            System.out.println("[4].Aluno mais velho e mais novo");
            System.out.println("Escolha : ");
            escolha = r.nextInt();
            r.nextLine();

            switch (escolha) {
                case 1:
                    try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
                        aluno.inscreverAluno();
                        if (!listAlunos.contains(aluno)) {
                            listAlunos.add(aluno);
                            bw.write(aluno.toString());
                        } else {
                            throw new RuntimeException("Elemento adicionado");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Informe a matricula do Aluno: ");
                    String m = r.nextLine();
                    aluno.setMatricula(m);
                    for(int i = 0; i<listAlunos.size(); i++) {
                        if(listAlunos.get(i).equals(aluno)){
                            System.out.println("Aluno: " + listAlunos.get(i));
                        }
                    }
                    System.out.println("Quantidade de alunos no sistema: " + listAlunos.size());
                    break;

                case 3:
                    RemocaoAlunoDAO remover = new RemocaoAlunoDAO();
                    System.out.print("Informe a matricula do aluno: ");
                    String matricula;
                    matricula = r.nextLine();
                    aluno.setMatricula(matricula);
                    remover.removerAluno(listAlunos, aluno);
                    break;

                case 4:
                    System.out.println(listAlunos);
                default:
                    System.out.println("Escolha errada");
            }

        } while (escolha <= 5);
    }

    public static String[] comparacaoIdade(List lista) {
        String maior, menor;
        for(int i = 0; i<lista.size(); i++){

        }
    }
}
