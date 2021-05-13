/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Vinni 
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String bodega;
    private float peso;
 

    public Producto(String nombre, String descripcion, String categoria, String bodega, float peso) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.bodega = bodega;
        this.peso = peso;
    }
    
    public Producto(int id, String nombre, String descripcion, String categoria, String bodega, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.bodega = bodega;
        this.peso = peso;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id
                + ", nombre=" + nombre 
                + ", descripcion=" + descripcion 
                + ", categoria=" + categoria 
                + ", bodega=" + bodega 
                + ", peso=" + peso + '}';
    }

}
