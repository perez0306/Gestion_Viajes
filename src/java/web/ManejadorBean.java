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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import logica.OperFile;
import logica.OperItem;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import utilidades.EscrituraArchivo;
import utilidades.LecturaArchivo;

/**
 *
 * @author Vinni
 */
@FacesConverter(value = "SelectItemToEntityConverter")
@ManagedBean
@SessionScoped
public final class ManejadorBean implements Serializable, Converter {

    private String nombreEmpleado;
    private String destino;
    private Date fechaViaje;
    private List<Item> itemsActivos;
    private List<File> listaArchivos;
    private List<Item> listaProductos;
    private ArrayList<SelectItem> itemsEmpleados;
    private ArrayList<SelectItem> listaItem;
    private SelectItem item;
    private SelectItem empleadoSeleccionado;
    private int idItem;
    private String nombreItem;
    private String categoriaItem;
    private long precioItem;

    public List<Item> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Item> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getCategoriaItem() {
        return categoriaItem;
    }

    public void setCategoriaItem(String categoriaItem) {
        this.categoriaItem = categoriaItem;
    }

    public long getPrecioItem() {
        return precioItem;
    }

    public void setPrecioItem(long precioItem) {
        this.precioItem = precioItem;
    }
   
    public SelectItem getItem() {
        return item;
    }

    public void setItem(SelectItem item) {
        this.item = item;
    }

    public ArrayList<SelectItem> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }

    public SelectItem getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(SelectItem empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public ArrayList<SelectItem> getItemsEmpleados() {
        return itemsEmpleados;
    }

    public void setItemsEmpleados(ArrayList<SelectItem> itemsEmpleados) {
        this.itemsEmpleados = itemsEmpleados;
    }

    public List<File> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(List<File> listaArchivos) {
        this.listaArchivos = listaArchivos;
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
        listarItems();
    }

    @PostConstruct
    public void init() {
    }

    public void listarItems() {
        OperItem oper = new OperItem();
        List<Item> lista = new ArrayList<Item>();
        lista = oper.getAll();
        listaItem = new ArrayList<>();
        if (lista != null) {
            for (Item producto : lista) {
                SelectItem item = new SelectItem(producto.getId(), producto.getNombre());
                listaItem.add(item);
            }
        }
    }

    public void agregarItem() {
        System.out.println("----------------------------------------\n" + this.item + "--------------------------------\n\n\n\n\n\n\n\n");
    }

    public void guardarViaje() {
        EscrituraArchivo escritura = new EscrituraArchivo();
        escritura.escribirArchivo(this.empleadoSeleccionado, this.destino, this.destino, "Viaje3");

    }

    public void actualizarPlanta() {
        LecturaArchivo plantaTH = new LecturaArchivo();
        List<Empleado> empleados = plantaTH.leerArchivoTH("C:\\BD\\DatosProyect\\PlantaTH.txt");
        itemsEmpleados = new ArrayList<>();
        if (empleados != null) {
            for (Empleado empleado : empleados) {
                SelectItem item = new SelectItem(empleado.getId(), empleado.getNombreEmpleado());
                itemsEmpleados.add(item);
            }
        }
    }

    public void listaItems() {
        OperFile oper = new OperFile();
        setListaArchivos(oper.getAll());
    }

    public void listaArchivos() {
        OperFile oper = new OperFile();
        setListaArchivos(oper.getAll());
    }
    
    public void listarProductos() {
        OperItem oper = new OperItem();
        setListaProductos(oper.getAll());
    }
    
    public void eliminarProducto(int id){
        OperItem oper = new OperItem();
        if (oper.delete(id) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en la eliminacion, intente mas tarde..."));
        }
    }
    
    public void guardarProducto() {
        OperItem oper = new OperItem();
        Item e = new Item(
                this.idItem,
                this.nombreItem,
                this.categoriaItem,
                this.precioItem);
        if (oper.insert(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }
    
    public void leerProducto(Item p){
        this.idItem=p.getId();
        this.nombreItem=p.getNombre();
        this.categoriaItem=p.getCategoria();
        this.precioItem=p.getPrecio();      
    }
    
    public void editarProducto() {
        OperItem oper = new OperItem();
        Item e = new Item(
                this.idItem,
                this.nombreItem,
                this.categoriaItem,
                this.precioItem);
        if (oper.update(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Edito el producto"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente al editar el producto, intente mas tarde "));
        }
    }
    
    public void openLevel1() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("level1", options, null);
    }

    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String s = "";
        if (o != null) {
            s = o.toString();
        }
        return s;
    }
}
