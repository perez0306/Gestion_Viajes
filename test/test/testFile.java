/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.File;
import logica.OperFile;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author CARITO
 */
public class testFile {

    public testFile() {
    }

    @Test
    public void creacionExitosaFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        dato.setNombreArchivo("Nombre");
        dato.setFechaArchivo("12/12/200");
        assertEquals(1, oper.insert(dato));
    }

    @Test
    public void creacionVaciosFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        dato.setNombreArchivo("");
        dato.setFechaArchivo("");
        assertEquals(0, oper.insert(dato));
    }

    @Test
    public void creacionNullFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        assertEquals(0, oper.insert(dato));
    }

    @Test
    public void creacionVacioNombreFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        dato.setNombreArchivo("");
        dato.setFechaArchivo("12/12/2000");
        assertEquals(0, oper.insert(dato));
    }
    
    @Test
    public void creacionVacioFechaFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        dato.setNombreArchivo("Nombre");
        dato.setFechaArchivo("");
        assertEquals(0, oper.insert(dato));
    }
    
    @Test
    public void creacionIngresoIdFile() {
        File dato = new File();
        OperFile oper = new OperFile();
        dato.setId(2);
        dato.setNombreArchivo("Nombre");
        dato.setFechaArchivo("12/12/2000");
        assertEquals(0, oper.insert(dato));
    }
    
     @Test
    public void eliminacionExitosaFile() {
        OperFile oper = new OperFile();
        int id = 2;
        assertEquals(1, oper.delete(id));
    }
    
    @Test
    public void eliminacionIdIncorrectoFile() {
        OperFile oper = new OperFile();
        int id= -1;
        assertEquals(0, oper.delete(id));
    }

}
