package aplicacao_cadastro_alunos;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raf
 */
public class View {
    public static Connection conectar() {
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
    
    public static void inserir(Connection conn, String matricula, String nome, int idade, String data, String telefone ,char[] cpf) {
        try {
            if(conn != null) {
                String sql = "INSERT INTO ALUNO (MATRICULA, NOME, IDADE, DT_NAS,TELEFONE,CPF) VELUES(?,?,?,?,?,?)";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1,matricula);
                stm.setString(2,nome);
                stm.setString(3,String.valueOf(idade));
                stm.setString(3, data);
                stm.setString(4, telefone);
                stm.setString(5, String.valueOf(cpf));
                
                stm.close();
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void remover(Connection conn, String matricula) {
        String sql = "DELETE FROM ALUNO WHERE MATRICULA = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, matricula);
            stm.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
        Connection conn = Test02.conectar();

        try {
            if (conn != null){
                 String sql = "INSERT INTO ALUNO (MATRICULA, NOME) VALUES(?,?)";
                 
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, "123");
                stm.setString(2, "Rafael");
                
                int linhasAfetadas = stm.executeUpdate();
                System.out.println("Inserção realizada com sucesso. Linhas afetadas: " + linhasAfetadas);
                
                stm.close();
                conn.close();
            } 
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    */
    
}
