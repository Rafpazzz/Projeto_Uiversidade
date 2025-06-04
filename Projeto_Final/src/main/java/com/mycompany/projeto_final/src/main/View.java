package com.mycompany.projeto_final.src.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raf
 */
public class View {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuBD"); //NESSA LINHA CRIA UMA CONECXÃO COM O BANCO DE DADOS.

    public static EntityManager getEntityManager() {
        return emf.createEntityManager(); //CHAMADA PARA CONECTAR COM O BANCO.
    }

    public void salvarBanco(Aluno aluno) {
        EntityManager entidade = View.getEntityManager(); //CRIA UMA CONECXÃO COM O MEU BANCO
        EntityTransaction tx = null;//REPRESENTA UMA FUNÇÃO DO MEU BANCO (EX:INSERT,SELECT,UPDATE...)
        
        try {
            tx = entidade.getTransaction();
            tx.begin();//INICICA A TRANSAÇÃO/METODOS
            entidade.persist(aluno);//NESSA LINHA FALA PARA O JPA SALVAR ESSE OBJETO NO MEU BANCO
            tx.commit();//CONFIRMAR A AÇÃO
            System.out.println("Aluno salvo com sucesso");
        }catch(Exception e) {
            if(tx != null) tx.rollback(); //EM VIRTUDE DE ALGUM ERRO REFAZER A AÇÃO, PARA ASSIM NAO CAUSAR NENHUM COMFLITO DE DADOS
            e.printStackTrace();
        }finally {
            entidade.close();
        }

    }
    
    public void removerDoBanco(Aluno aluno) {
        EntityManager entidade = View.getEntityManager();
        EntityTransaction tx = null;
        
        try {
            tx = entidade.getTransaction();
            tx.begin();
            Aluno alunoManaged = entidade.merge(aluno);
            entidade.remove(alunoManaged);
            tx.commit();
            System.out.println("Aluno removido com sucesso");
        }catch(Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            entidade.close();
        }
    }
    
    public void mostrarLista(List<Aluno> alunos) {
        EntityManager em = View.getEntityManager();
        
        try {
            TypedQuery<Aluno> q = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
            List<Aluno> resultado = q.getResultList();
            
            alunos.addAll(resultado);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        
    }

}

