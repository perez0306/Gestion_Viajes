/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.File;
import dto.Item;
import javax.faces.model.SelectItem;
import logica.OperFile;
import web.ManejadorBean;

/**
 *
 * @author CARITO
 */
public class local_test {

    public static void main(String[] args) {


        web.ManejadorBean manejador = new ManejadorBean();
        logica.OperFile file = new OperFile();
        String nombre = "Viaje4";
        File f = new File();
        
        f.setNombreArchivo(nombre);
        f.setFechaArchivo("12/20/2000");
        
        GestionArchivos escritura = new GestionArchivos();
        Item i = new Item(0, "nombre", "categoria", 0);
        SelectItem item = new SelectItem(i, "nombre");
        
  
        escritura.escribirArchivo(item, "Prueba", "prueba", "Viaje4");
        file.insert(f);
    }
}
