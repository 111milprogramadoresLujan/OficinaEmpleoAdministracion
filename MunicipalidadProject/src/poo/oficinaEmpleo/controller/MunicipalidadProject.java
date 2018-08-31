/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.oficinaEmpleo.controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import poo.OficinaEmpleoEntity.Usuario;
import sun.util.calendar.BaseCalendar.Date;




/**
 *
 * @author Acer
 */
public class MunicipalidadProject {
    
 private static SessionFactory factory; 
  private static Connection connection; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
  
  
    try {
        
         factory = new AnnotationConfiguration().configure().
                   //addPackage("com.xyz") //add package if used.
                   addAnnotatedClass(Usuario.class).
                   buildSessionFactory();
         getConnection();
      } 
    catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    
       new GestorOficanaEmpleo(factory,connection).run();
      
   }
    

    public static Connection getConnection() throws Exception {
        
           if(connection == null)
           {
            String url = "jdbc:mysql://localhost:3306/oficinaempleo";
            connection = DriverManager.getConnection(url, "root", "root");
           }
            return connection;
    }
    
    public static void closeConnection(Connection conn) {

        try {

            connection.close();

        } catch (SQLException e) {

        }

    }

 
        
//    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        SessionFactory sessionFactory = null;
//        
//        // A SessionFactory is set up once for an application!
//	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
//			.build();
//	try {
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//	}
//	catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy( registry );
//            
//            throw e;
//	} 
    }
    

