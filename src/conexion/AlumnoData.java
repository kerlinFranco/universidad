/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidad.alumno;

/**
 *
 * @author USURIO
 */
public class AlumnoData {
    private Connection con=null;

    public AlumnoData(miConexion con) {
       
             this.con = con.buscarConexion();
            System.out.println("\"Conectado a la base de datos\"");
       
       /*
            try {
            connection = conexion.getConexion();
            mensaje("Conectado a la base de datos");

        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en AlumnoData");
        }
       */
        
    }
    
    public void guardarAlumno(alumno alu){
        System.out.println();
        String query="INSERT INTO `alumno`(dni) "
                + "VALUES (49)";
        
        try {
            PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alu.getDni());
//            ps.setString(2,alu.getApellido());
//            ps.setString(3,alu.getNombre());
//            ps.setDate(4, Date.valueOf(alu.getfNacimiento()));
//            ps.setBoolean(5,alu.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                alu.setIdAlumno(rs.getInt(1));
            }else{
                System.out.println("no se pudo tener id ");
                ps.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        public void guardarAlumno(Alumno alumno) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO alumno VALUES (NULL, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDate(3, Date.valueOf(alumno.getFecha_nac()));
            ps.setInt(4, alumno.getLegajo());
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
                mensaje("Se ha guardado al alumno " + alumno.getNombre() + " correctamente");
            } else {
                mensaje("No se ha guardado al alumno" + alumno.getNombre() + " correctamente");
            }
        } catch (SQLException ex) {
            mensaje("Error al guardar al alumno: " + ex.getMessage());
        }
    }
        */
        
    }
    
}
