/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CARITO
 */
public class Viaje {
    private Empleado empleado;
    private String destino;
    private Date fechaViaje;
    private ArrayList<Item> items;

    public Viaje(Empleado empleado, String destino, Date fechaViaje, ArrayList<Item> items) {
        this.empleado = empleado;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.items = items;
    }

    public Viaje() {
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Viaje{" + "empleado=" + empleado + ", destino=" + destino + ", fechaViaje=" + fechaViaje + ", items=" + items + '}';
    }

}
