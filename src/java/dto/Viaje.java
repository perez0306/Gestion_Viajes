/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CARITO
 */
public class Viaje implements Serializable{
    private Empleado empleado;
    private String destino;
    private String fechaViaje;
    private List<Item> items;

    public Viaje(Empleado empleado, String destino, String fechaViaje, List<Item> items) {
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

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
    public long sumarItems(List<Item> lista ){
        long suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i).getPrecio();
        }
        return suma;
    }
    

    @Override
    public String toString() {
        return "Viaje{" + "empleado=" + empleado + ", destino=" + destino + ", fechaViaje=" + fechaViaje + ", items=" + items + '}';
    }

}
