/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Producto;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.OperProducto;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Vinni
 */
@ManagedBean
@SessionScoped
public final class ManejadorBean implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String bodega;
    private float peso;
    private List<Producto> lista;


    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
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



    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorBean() {
    }

    public void guardar() {
        OperProducto oper = new OperProducto();
        Producto e = new Producto(
                this.nombre,
                this.descripcion,
                this.categoria,
                this.bodega,
                (float) this.peso);
        if (oper.insert(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }

    public void editar() {
        OperProducto oper = new OperProducto();
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

    public void listar() {
        OperProducto oper = new OperProducto();
        setLista(oper.getAll());
    }

    public void eliminar(int p) {

        OperProducto oper = new OperProducto();
        if (oper.delete(p) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Elimino el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en la eliminacion, intente mas tarde "));
        }
    }
    
     public void openLevel1() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("level1", options, null);
    }

    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }
    
    public void leerID(Producto p){
        this.id=p.getId();
        this.nombre=p.getNombre();
        this.descripcion=p.getDescripcion();
        this.categoria=p.getCategoria();
        this.bodega=p.getBodega();
        this.peso=p.getPeso();      
    }
}
