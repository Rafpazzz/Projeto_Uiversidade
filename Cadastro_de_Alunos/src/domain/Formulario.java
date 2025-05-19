package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formulario {
    public static void main(String[] args) {
        List<Aluno> Escola1 = new ArrayList<Aluno>();
        int escolha;
        Scanner r = new Scanner(System.in);
        File file = new File("ListagemAlunos.txt");

        do {
            System.out.println("Formulario de alunos");
            System.out.println("[1].add Aluno");
            System.out.println("[2].mostrar Aluno");
            System.out.println("[3].Remover Aluno");
            System.out.println("Escolha : ");
            escolha = r.nextInt();

            switch (escolha) {
                case 1:
                    try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
                        Aluno aluno = new Aluno();
                        aluno.inscreverAluno();
                        if (!Escola1.contains(aluno)) {
                            Escola1.add(aluno);
                            bw.write(aluno.toString());
                        } else {
                            throw new RuntimeException("Elemento adicionado");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try(FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr)) {
                        String linha;
                        while((linha = br.readLine()) != null) {
                            System.out.println(linha);
                        }
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    RemocaoAlunoDAO remover = new RemocaoAlunoDAO();
                    remover.removerAluno(Escola1, );
                default:
                    System.out.println("Escolha errada");
            }

        } while (escolha <= 3);
    }
}
