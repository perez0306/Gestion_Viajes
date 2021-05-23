/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.Empleado;
import dto.File;
import dto.Item;
import java.util.ArrayList;
import java.util.List;
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
        Empleado i = new Empleado("Omar", 123, "Ingeniero");
        SelectItem item = new SelectItem(i, i.getNombreEmpleado());
        Empleado items = (Empleado) item.getValue();
        List<Item> lista = new ArrayList<Item>();
        Item prueba = new Item();
        prueba.setPrecio(120L);
        prueba.setNombre("Item1");
        lista.add(prueba);
        long suma = 4000L;
        escritura.escribirArchivo(items, "Prueba", "prueba", "Viaje4", lista, suma);
        //file.insert(f);
    }
}




/*@Test
    public void insertarObjetoOKFaker(){
        Faker faker = new Faker(Locale.ITALY);
        
        OperEstudiante oper = new OperEstudiante();
        Estudiante e = new Estudiante();
        long dato = faker.number().numberBetween(0L, 1L);
        
        e.setActivo(new Integer(""+dato));
        String papell  =  faker.name().lastName();
        e.setApellido(papell);
        String pnombre  =  faker.name().firstName();
        e.setNombre(pnombre);
        long iden = faker.num}*/
