/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.oficinaEmpleo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import poo.OficinaEmpleoEntity.Usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.EntityMode;
import org.hibernate.Criteria;
import org.hibernate.Query;


/**
 *
 * @author Acer
 */

public class UsuarioDao {
     private final Connection connection; 
      private final SessionFactory sessionFactory;
      
    public UsuarioDao(SessionFactory sessionFactory,Connection connection){
        this.sessionFactory = sessionFactory;
        this.connection=connection;
    }
    
    public boolean GuardarUsuario(Usuario usuario)
    {
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
      try {
          
            tx = session.beginTransaction();
            
            session.save(usuario);
            tx.commit();
            return true;
        
         } 
      catch (HibernateException e) 
      {
       if (tx != null) tx.rollback();
         e.printStackTrace(); 
         return false;
      }
      finally 
      {
         session.close(); 
      }
    }
    
    
     public boolean isUsuarioExistente(String nombreUsuario) {
        String lastName = "";
        try {
           
            Statement stmt = connection.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery("SELECT nombreUsuarios FROM usuario WHERE nombreUsuarios = '"+nombreUsuario+"'");
            while (rs.next()) {
                lastName = rs.getString("nombreUsuario");
                if(lastName.equals(nombreUsuario)){
                    return false;
                }
            }
            connection.close();    
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
       
        return true;
    }
    
}
