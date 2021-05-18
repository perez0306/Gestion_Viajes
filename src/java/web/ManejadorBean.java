/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Empleado;
import dto.File;
import dto.Item;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperItem;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import utilidades.LecturaArchivo;

/**
 *
 * @author Vinni
 */
@ManagedBean
@SessionScoped
public final class ManejadorBean implements Serializable {
    
    private String nombreEmpleado;
    private String destino;
    private Date fechaViaje;
    private List<Item> listaItems;
    private List<Item> itemsActivos;
    private List<Empleado> listaEmpleados;
    private List<File> listaArchivos;

    public List<File> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(List<File> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }
    
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public List<Item> getItemsActivos() {
        return itemsActivos;
    }
    
    public void setItemsActivos(List<Item> itemsActivos) {
        this.itemsActivos = itemsActivos;
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
    
    public List<Item> getListaItems() {
        return listaItems;
    }
    
    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }
    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorBean() {
        actualizarPlanta();
    }

    /*
    public void guardar() {
        OperItem oper = new OperItem();
        Item e = new Item(
                this.nombreEmpleado,
                this.destino,
                (Date) this.fechaViaje,
                this.bodega,
        if (oper.insert(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }

    public void editar() {
        OperItem oper = new OperItem();
        Producto e = new Producto(
                this.id,
                this.nombreEmpleado,
                this.descripcion,
                this.categoria,
                this.bodega,
                (float) this.peso);
        System.out.println(e.toString());
        if (oper.update(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Edito el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente al editar el producto, intente mas tarde "));
        }
    }
     public void eliminar(int p) {

        OperItem oper = new OperItem();
        if (oper.delete(p) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Elimino el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en la eliminacion, intente mas tarde "));
        }
    }
     */
    public List<Item> listarItems() {
        OperItem oper = new OperItem();
        List<Item> lista = new ArrayList<Item>();
        lista = oper.getAll();
        return lista;
    }
    
    public List<Item> actualizarItems() {
        return getItemsActivos();
    }
    
    public void actualizarPlanta() {
        LecturaArchivo plantaTH = new LecturaArchivo();
        ArrayList<Empleado> empleados = plantaTH.leerArchivoTH("PlantaTH.txt");  
        setListaEmpleados(empleados);
    }
    
    public void listaArchivos() {
       OperItem oper = new OperItem();
        setListaArchivos(oper.getAll());
    }

    /*    public void leerItem(Item p){
        this.id=p.getId();
        this.nombreEmpleado=p.getNombre();
        this.categoria=p.getCategoria();
        this.precio=p.getPrecio();
        this.peso=p.getPeso();      
    }*/
    public void openLevel1() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("level1", options, null);
    }
    
    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }
}
