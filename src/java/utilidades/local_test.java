/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.Item;
import javax.faces.model.SelectItem;
import web.ManejadorBean;

/**
 *
 * @author CARITO
 */
public class local_test {

    public static void main(String[] args) {

        /* OperFile oper = new OperFile();
        List<File> file =oper.getAll();
        
        
        for (int i = 0; i < file.size(); i++) {
            System.out.println(file.get(i).toString());
        
       }*/
        web.ManejadorBean manejador = new ManejadorBean();

        //   manejador.actualizarPlanta();
        // manejador.guardarViaje();
        GestionArchivos escritura = new GestionArchivos();
        Item i = new Item(0, "nombre", "categoria", 0);
        SelectItem item = new SelectItem(i, "nombre");
        escritura.escribirArchivo(item, "Hola", "hola", "Viaje3");

    }
}
