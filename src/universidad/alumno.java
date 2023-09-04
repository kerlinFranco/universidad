/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.time.LocalDate;

/**
 *
 * @author USURIO
 */
public class alumno {
     private int idAlumno=-1;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fNacimiento;
    private boolean estado;
    
     public alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fNacimiento, boolean estado) {
        this.idAlumno=idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.estado = estado;
    }

    public alumno(int dni, String apellido, String nombre, LocalDate fNacimiento, boolean estado) {
        this.idAlumno=-1;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.estado = estado;
    }
    public alumno(){
        this.idAlumno=-1;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    @Override
    public String toString() {
        return "idAlumno=" + idAlumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", estado=" + estado + fNacimiento ;
    }
    
    
}
