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
public class materia {
   
    private int idMateria=-1;
    private String nombre;
    private int anio;
    private boolean estado;

    
    
    
    public materia(int idMateria, String nombre, int anio, boolean estado) {
        this.idMateria=idMateria;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public materia(String nombre, int anio, boolean estado) {
        this.idMateria=-1;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    
    
    public materia() {
         this.idMateria=-1;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "idMateria=" + idMateria + ", nombre=" + nombre + ", anio=" + anio + ", estado=" + estado ;
    }
    
    
    
    
}
