/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.OficinaEmpleoEntity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "usuario")
public class Usuario 
{
    @Id @GeneratedValue
   @Column(name = "id_usuarios")
    private int id;
   @Column(name = "nombreUsuarios")
    private String nombreUsuario;  
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "mail")
    private String mail;
    @Column(name = "fecha")
    private Date fecha;
    
    public Usuario(String nombreUsuario, String contraseña,String nombre,String apellido,String mail)
    {
        this.apellido=apellido;
        this.contraseña=contraseña;
        this.nombre=nombre;
        this.nombreUsuario=nombreUsuario;
        this.fecha = new Date();
        this.mail= mail;
    }
    
    public Usuario()
    {
    }
    
    public void setMail( String mail ) {
      this.mail = mail;
   }
    
    
     public String getMail() {
        return mail;
    }

    public void setId( int id_usuarios ) {
      this.id = id_usuarios;
   }
    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuarios) {
        this.nombreUsuario = nombreUsuarios;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
     public void setFechaActual(Date fechaActual) {
        this.fecha  = fechaActual;
    }
     
     
      public Date getFechaActual() {
        return fecha;
    }


    /**
     * @return the fechaSession
     */
    

   
}
