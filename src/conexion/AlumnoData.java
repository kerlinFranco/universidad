/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        this.con= con.buscarConexion();
    }
    
    public void guardarAlumno(alumno alu){
        String query="INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alu.getDni());
            ps.setString(2,alu.getApellido());
            ps.setString(3,alu.getNombre());
            ps.setString(4, alu.getfNacimiento());
            ps.setBoolean(5,alu.isEstado());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
