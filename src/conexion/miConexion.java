/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USURIO
 */
public class miConexion {
    private String url;
    private String usuario;
    private String pasword;
    
    private Connection conexion=null;

    public miConexion(String url, String usuario, String pasword) {
        this.url = url;
        this.usuario = usuario;
        this.pasword = pasword;
    }
    
    //Carga los drivers y conecta con la base de datos
    
    public Connection buscarConexion(){
        if(conexion==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                this.conexion=DriverManager.getConnection(url,usuario,pasword);
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectar");
            }
            
            
        }
        return conexion;
    }

    @Override
    public String toString() {
        return "miConexion{" + "url=" + url + ", usuario=" + usuario + ", pasword=" + pasword + ", conexion=" + conexion + '}';
    }
    
    
}

