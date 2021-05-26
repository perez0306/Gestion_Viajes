/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Empleado;
import dto.File;
import dto.Item;
import dto.Viaje;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperFile;
import utilidades.GestionArchivos;

/**
 *
 * @author CARITO
 */
@ManagedBean
@SessionScoped
public final class ManejadorBeanEmpleados implements Serializable {

    private List<Empleado> empleados;
    private List<Item> itemsActivos;
    private String destino;
    private String fechaViaje;
    private String nombreArchivo;
    private long idEmpleado;
    private long idItem;
    private long suma = 0;
    private String message;

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<Item> getItemsActivos() {
        return itemsActivos;
    }

    public void setItemsActivos(List<Item> itemsActivos) {
        this.itemsActivos = itemsActivos;
    }

    public long getSuma() {
        return suma;
    }

    public void setSuma(long suma) {
        this.suma = suma;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ManejadorBeanEmpleados() {
        listarEmpelados();
    }

    public void listarEmpelados() {
        GestionArchivos plantaTH = new GestionArchivos();
        setEmpleados(plantaTH.leerArchivoTH("C:\\BD\\DatosProyect\\PlantaTH.txt"));
    }

    public void sumar() {
        Viaje viaje = new Viaje();
        this.suma = viaje.sumarItems(itemsActivos);
    }

    public void crearViaje() {
        GestionArchivos escritura = new GestionArchivos();
        OperFile oper = new OperFile();
        File file = new File();
        Calendar fecha = new GregorianCalendar();
        //usando el método get y el parámetro correspondiente                                                     
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        file.setNombreArchivo(this.nombreArchivo);
        file.setFechaArchivo(dia + "/" + mes + "/" + año);

        Empleado empleadoElegido = null;

        for (Empleado empleado : this.empleados) {
            if (empleado.getId() == this.idEmpleado) {
                empleadoElegido = empleado;
                break;
            }
        }
        if (empleadoElegido == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El empleado no esta en la planta, por favor verifque la tabla"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se guardo el viaje"));
            escritura.escribirArchivo(empleadoElegido, this.destino, this.fechaViaje, this.nombreArchivo, this.itemsActivos, this.suma);
            oper.insert(file);
        }
    }

    public void agregarItem(){
        
    }
    
}
