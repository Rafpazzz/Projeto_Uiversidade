package aplicacao_cadastro_alunos;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raf
 */
public class View {
    public Connection conectar() {
        Connection conecxao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/escola";
            String usuario = "root";
            String senha = "12345";
            
            conecxao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conectado dom sucesso");
            
        }catch(ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        
        return conecxao;
    }
    
    public void inserir(Connection conn, Aluno aluno) {
        try {
            if(conn != null) {
                String sql = "INSERT INTO ALUNO (MATRICULA, NOME, IDADE, DATANAS,TELEFONE,CPF) VALUES(?,?,?,?,?,?)";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1,aluno.getMatricula());
                stm.setString(2,aluno.getNome());
                stm.setString(3,String.valueOf(aluno.getIdade()));
                stm.setString(4,String.valueOf(aluno.getData()));
                stm.setString(5, aluno.getTelefone());
                stm.setString(6, String.valueOf(aluno.getCpf()));
                
                int linhasAfetadas = stm.executeUpdate();
                System.out.println("Inserção realizada com sucesso. Linhas afetadas: " + linhasAfetadas);
                
                stm.close();
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remover(Connection conn, String matricula) {
        String sql = "DELETE FROM ALUNO WHERE MATRICULA = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, matricula);
            stm.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void retornaValoresBanco(Connection conn, List<Aluno> alunos) {
        String sql = "SELECT * FROM ALUNO";
        
        try(PreparedStatement stm = conn.prepareStatement(sql)) {
            System.out.println("Iniciando Carregamento de Alunos");
            ResultSet rs = null;
            rs = stm.executeQuery();
            while(rs.next()) {
                
                java.sql.Date dataSql = rs.getDate("dataNas");
                LocalDate dataNascimento = null;
                if (dataSql != null) {dataNascimento = dataSql.toLocalDate();}
              
                String str = rs.getString("cpf").trim();
                char[] cpf = str.toCharArray();
                Aluno a = new Aluno(rs.getString("nome"),rs.getString("matricula"), rs.getInt("idade"), dataNascimento, rs.getString("telefone"), cpf);
                alunos.add(a); 
                System.out.println("Aluno carregado");
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
