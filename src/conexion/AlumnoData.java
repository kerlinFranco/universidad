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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidad.alumno;

/**
 *
 * @author USURIO
 */
public class AlumnoData {
    private Connection con=null;

    public AlumnoData(miConexion conexion) {
       
            this.con = conexion.buscarConexion();
            System.out.println("\"Conectado a la base de datos\"");
            System.out.println(conexion);
       /*
            try {
            connection = conexion.getConexion();
            mensaje("Conectado a la base de datos");

        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en AlumnoData");
        }
       */
        
    }
    //Inserta un alumno en la base de datos 
    public void guardarAlumno(alumno alu){
        System.out.println();
        String query="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alu.getDni());
            ps.setString(2,alu.getApellido());
            ps.setString(3,alu.getNombre());
            ps.setDate(4, Date.valueOf(alu.getfNacimiento()));
            ps.setBoolean(5,alu.isEstado());
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
        
       
        
       
    }
    
     //Buscar alumno con la id
    public alumno buscarAlumno(int id){
            alumno alu=null;
            String sql= "SELECT * FROM alumno WHERE id=?";
            PreparedStatement ps;
                try{
                    ps=con.prepareStatement(sql);
                    ps.setInt(1, id);
                    ResultSet rs=ps.executeQuery();
                    while (rs.next()){
                        alu=new alumno();
                        alu.setIdAlumno(rs.getInt("idAlumno"));
                        alu.setDni(rs.getInt("dni"));
                        alu.setApellido(rs.getString("apellido"));
                        alu.setNombre(rs.getString("nombre"));
                        alu.setfNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                        alu.setEstado(rs.getBoolean("estado"));
                    
                    }
                    ps.close();
                }catch(SQLException ex){
                    System.out.println(""+ex);
                }
            return alu;
        }
     //Buscar alumnos 
    
    public List<alumno> listaAlumnos(){
            alumno alu=null;
            List<alumno> alumnos= new ArrayList<>();
            String sql= "SELECT * FROM alumno";
            PreparedStatement ps;
                try{
                    ps=con.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    while (rs.next()){
                        alu=new alumno();
                        alu.setIdAlumno(rs.getInt("idAlumno"));
                        alu.setDni(rs.getInt("dni"));
                        alu.setApellido(rs.getString("apellido"));
                        alu.setNombre(rs.getString("nombre"));
                        alu.setfNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                        alu.setEstado(rs.getBoolean("estado"));
                        alumnos.add(alu);
                    }
                    ps.close();
                }catch(SQLException ex){
                    System.out.println(""+ex);
                }
            return alumnos;
    }
    //borrar de manera logica
    
   public void borrarAlumno(int id){
       String upd="UPDATE alumno SET estado=0 WHERE idAlumno=?";
       PreparedStatement ps;
        try {
            
            ps = con.prepareStatement(upd);
            ps.setInt(1, id);
            int registro= ps.executeUpdate();
            if(registro==0){
            System.out.println("No se encontro el empleado");
            }else{
            System.out.println("Empleado borrado");
       }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   }
    
    
}
