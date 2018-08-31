/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.oficinaEmpleo.controller;

import java.sql.Connection;
import org.hibernate.SessionFactory;
import poo.oficinaEmpleo.dao.UsuarioDao;
import poo.oficinaEmpleo.ui.AltaUsuario;
import poo.OficinaEmpleoEntity.Usuario;

/**
 *
 * @author Acer
 */
public class GestorOficanaEmpleo {
    
    private UsuarioDao usuarioDao;
    
     public GestorOficanaEmpleo(SessionFactory sessionFactory,Connection connection) {
        // creamos las instancias de los objetos de acceso a datos
       this.usuarioDao = new UsuarioDao(sessionFactory,connection);
    }

    public void run () {
          new AltaUsuario(this).setVisible(true);
    }
    
    public boolean GuardarUsuario(String nombre, String apellido,String email,String contraseña,String nombreUsuario)
    {
        Usuario usuario=new Usuario(nombreUsuario,contraseña,nombre,apellido,email);
         return  usuarioDao.GuardarUsuario(usuario);
                 
    }
    
    public boolean isUsuarioExistente(String nombreUsuario){
        return usuarioDao.isUsuarioExistente(nombreUsuario);
    }
    
}
