/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import conexion.AlumnoData;
import conexion.miConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USURIO
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//            Connection conexion=DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp","root","");
            
//            String alu1="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
//                    + "VALUES(38018311,'Kerlin','Franco',1994-08-08,1)";
//            PreparedStatement ps1=conexion.prepareStatement(alu1);
//            ps1.executeUpdate();
            
//            String alu2="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
//                    + "VALUES(38018312,'Kerling','Fran',1994-08-09,1)";
//            PreparedStatement ps2=conexion.prepareStatement(alu2);
//            ps2.executeUpdate();
////            
//            String alu3="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
//                    + "VALUES(38018411,'Herlin','Joan',1996-08-18,1)";
//            PreparedStatement ps3=conexion.prepareStatement(alu3);
//            ps3.executeUpdate();
//            String mat1="INSERT INTO `materia` VALUES (null,'Analisis',1,1)";
//            PreparedStatement ps4=conexion.prepareStatement(mat1);
//            ps4.executeUpdate();
//            String mat2="INSERT INTO `materia` VALUES (null,'Derecho comercial',1,1)";
//            PreparedStatement ps5=conexion.prepareStatement(mat2);
//            ps5.executeUpdate();
//            String mat3="INSERT INTO `materia` VALUES (null,'Algo',1,1)";
//             PreparedStatement ps6=conexion.prepareStatement(mat3);
//            ps6.executeUpdate();
//            String mat4="INSERT INTO `materia` VALUES (null,'Algo 2',2,1)";
//             PreparedStatement ps7=conexion.prepareStatement(mat4);
//            ps7.executeUpdate();
//            
//         String insc="INSERT INTO inscripcion VALUES(null,9,5,3)";
//         PreparedStatement ps=conexion.prepareStatement(insc);
//         ps.executeUpdate();
//         String insc2="INSERT INTO inscripcion VALUES(null,6,5,4)";
//         PreparedStatement ps2=conexion.prepareStatement(insc2);
//         ps2.executeUpdate();
         
//        String cons="SELECT * FROM inscripcion JOIN alumno ON (alumno.idAlumno=inscripcion.idAlumno) WHERE nota >6";
//         PreparedStatement ps=conexion.prepareStatement(cons);
//         ResultSet notas=ps.executeQuery();
//         while(notas.next()){
//             System.out.println("Nombre "+notas.getString("nombre"));
//             System.out.println("Apellido "+notas.getString("apellido"));
//             System.out.println("Nota "+notas.getInt("nota"));
//             System.out.println("-----------------------------");
//         }
//        
//         String del="DELETE FROM inscripcion WHERE inscripcion.idAlumno=5 AND inscripcion.idMateria=4";
//         PreparedStatement ps=conexion.prepareStatement(del);
//         ps.executeUpdate();
//         
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null,"Error al cargar driver");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Error al conectar");
//        }
       alumno alu2= new alumno(45098333,"Francisco", "Juan",LocalDate.of(1995,8,30),true);
       new Universidad().conectar(alu2);
       

    }
    public void conectar(alumno alu){
       miConexion conexion=new miConexion("jdbc:mariadb://localhost:3306/universidadulp","root","");
       AlumnoData aluData= new AlumnoData(conexion);
//       aluData.guardarAlumno(alu);
       aluData.borrarAlumno(8);
       
    }
    
}
