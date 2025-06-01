
package aplicacao_cadastro_alunos;

import javax.swing.JOptionPane;
import aplicacao_cadastro_alunos.Aluno;
import aplicacao_cadastro_alunos.View;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextArea;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author joaoa
 */
public class AlunoDAOimpl implements AlunoDAO{
    
    View banco = new View();
    File file = new File("armazena.csv");
    
    @Override
    public boolean validarData(String data) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);  // Não permite datas inválidas

        try {
            sdf.parse(data);
            return true;  // Data válida
        } catch (ParseException e) {
            return false;  // Data inválida
        }
    } 
    
    @Override
    public int calcularIdade(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            JOptionPane.showMessageDialog(null,"Preencha o campo 'Data de nascimento!' " ,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
        }

        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }
    
    
    @Override
    public boolean isEmpty(List alunos){ //verifica se vazia
       return alunos.isEmpty();
    }
    
    @Override
    public boolean verificaExistencia(List alunos,Aluno AlunoVerificar){
        
        if(isEmpty(alunos)){
            JOptionPane.showMessageDialog(null,"A lista está vazia! Não foi possivel concluir sua operação." ,"Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Aluno não encontrado na lista","Notificação do Sistema",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    @Override
    public boolean verificaPreenchimento(String matricula, String nome, String telefone, String cpf) {
        if (matricula == null || matricula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha a matrícula.");
            return false;
        }

        if (nome == null || telefone.replaceAll("[^0-9]", "").isEmpty()) { // remove tudo que não for número. Se sobrar nada → está vazio!
            JOptionPane.showMessageDialog(null, "Por favor, preencha o nome.");
            return false;
        }

        if (telefone == null || telefone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o telefone.");
            return false;
        }

        if (cpf == null || cpf.replaceAll("[^0-9]", "").isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o CPF.");
            return false;
        }

        return true;  // Tudo preenchido corretamente
    }
    
    
    
    @Override
    public void inserirAluno(List alunos, Aluno alunoInserir){
       if(alunos.contains(alunoInserir)){
           JOptionPane.showMessageDialog(null,"Esse Aluno ja existe no sistema!","Notificação do Sistema",JOptionPane.ERROR_MESSAGE);
       }
       else{
           alunos.add(alunoInserir);
           banco.inserir(banco.conectar(), alunoInserir);
           salvarArquivo(file, alunoInserir, alunos);
           JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
       }
    }
    
    @Override
    public void removerAluno(List<Aluno> alunos, String matricula) {
        Aluno alunoParaRemover = null;
        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            if (a.getMatricula().equals(matricula)) {
                alunoParaRemover = a;
                break;
            }
        }
        if (alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
            banco.remover(banco.conectar(), alunoParaRemover.getMatricula());
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @Override
    public Aluno pesquisarAluno(List<Aluno> alunos, String matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return alunos.get(i);
            }
        }
        return null; // Não encontrou
    }

    @Override
    public void ordenarListaAluno(List alunos){
        if(isEmpty(alunos)) {
           JOptionPane.showMessageDialog(null,"MENSAGEM DE ERRO","Voce tentou efetuar uma busca em uma lista vazia",JOptionPane.ERROR_MESSAGE);
        }else {
            Collections.sort(alunos);
        }
    }
    private void salvarArquivo(File file, Aluno aluno, List alunos){
       try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            alunos.add(aluno);
            bw.write(aluno.toString());
            bw.newLine();    
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
 }    

    

