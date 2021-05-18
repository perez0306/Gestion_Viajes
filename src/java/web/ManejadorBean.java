/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Item;
import dto.Producto;
import dto.Viaje;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.OperItem;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Vinni
 */
@ManagedBean
@SessionScoped
public final class ManejadorBean implements Serializable {

    private String nombre;
    private String destino;
    private Date fechaViaje;
    private List<Item> listaItems;
    private List<Item> itemsActivos;

    public List<Item> getItemsActivos() {
        return itemsActivos;
    }

    public void setItemsActivos(List<Item> itemsActivos) {
        this.itemsActivos = itemsActivos;
    }
    
    private List<Producto> lista;

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
    
    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorBean() {
    }

    /*
    public void guardar() {
        OperItem oper = new OperItem();
        Item e = new Item(
                this.nombre,
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
                this.nombre,
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
    
    public List<Item> actualizarItems(){
        return getItemsActivos();
    }

   
    
    
    
/*    public void leerItem(Item p){
        this.id=p.getId();
        this.nombre=p.getNombre();
        this.categoria=p.getCategoria();
        this.precio=p.getPrecio();
        this.peso=p.getPeso();      
    }*/
    
    
    public void openLevel1() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("level1", options, null);
    }

    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }
}
