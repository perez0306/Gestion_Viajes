/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author CARITO
 */
public class Empleado implements Serializable{
    private String nombreEmpleado;
    private int id;
    private String rol;

    public Empleado() {
    }

    public Empleado(String nombre, int id, String rol) {
        this.nombreEmpleado = nombre;
        this.id = id;
        this.rol = rol;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombreEmpleado + ", id=" + id + ", rol=" + rol + '}';
    }
    
}
