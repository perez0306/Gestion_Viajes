/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author CARITO
 */
public class Empleado {
    private String nombre;
    private int id;
    private String rol;

    public Empleado() {
    }

    public Empleado(String nombre, int id, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Empleado{" + "nombre=" + nombre + ", id=" + id + ", rol=" + rol + '}';
    }
    
}
