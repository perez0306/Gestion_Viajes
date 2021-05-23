/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.Empleado;
import dto.Item;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utilidades.GestionArchivos;

/**
 *
 * @author CARITO
 */
public class testGestionArchivos {

    public testGestionArchivos() {
    }

    @Test
    public void lecturaNombreVacioFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = "";
        assertEquals(null, oper.leerArchivoTH(archivo));
    }

    @Test
    public void lecturaNombreNullFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = null;
        assertEquals(null, oper.leerArchivoTH(archivo));
    }

    @Test
    public void escrituraNullFile() {
        GestionArchivos oper = new GestionArchivos();
        Empleado empleado = new Empleado();
        String archivo = null;
        List<Item> lista = new ArrayList<Item>();
        Item item = new Item();
        item.setPrecio(120L);
        lista.add(item);
        long suma = 0;
        assertEquals(0, oper.escribirArchivo(empleado, archivo, archivo, archivo, lista, suma));
    }

    @Test
    public void escrituraNullNombreFile() {
        GestionArchivos oper = new GestionArchivos();
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado("Nombre");
        empleado.setRol("Ingeniero");
        String archivo = null;
        List<Item> lista = new ArrayList<Item>();
        Item item = new Item();
        item.setPrecio(120L);
        lista.add(item);
        long suma = 0;
        assertEquals(0, oper.escribirArchivo(empleado, archivo, archivo, archivo, lista, suma));
    }

    @Test
    public void escrituraVacioNombreFile() {
        GestionArchivos oper = new GestionArchivos();
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado("Nombre");
        empleado.setRol("Ingeniero");
        String archivo = "";
        List<Item> lista = new ArrayList<Item>();
        Item item = new Item();
        item.setPrecio(120L);
        lista.add(item);
        long suma = 0;
        assertEquals(0, oper.escribirArchivo(empleado, archivo, archivo, archivo, lista, suma));
    }

    @Test
    public void escrituraVacioEmpleadoFile() {
        GestionArchivos oper = new GestionArchivos();
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado("");
        empleado.setRol("Ingeniero");
        String archivo = "Nombre";
        List<Item> lista = new ArrayList<Item>();
        Item item = new Item();
        item.setPrecio(120L);
        lista.add(item);
        long suma = 0;
        assertEquals(0, oper.escribirArchivo(empleado, archivo, archivo, archivo, lista, suma));
    }

    @Test
    public void eliminarVacioFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = "";
        assertEquals(0, oper.eliminarArchivo(archivo));
    }

    @Test
    public void eliminarNullFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = null;
        assertEquals(0, oper.eliminarArchivo(archivo));
    }

    @Test
    public void abrirExitosoFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = "Viaje3";
        assertEquals(1, oper.abrirArchivo(archivo));
    }

    @Test
    public void abrirVacioFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = "";
        assertEquals(0, oper.abrirArchivo(archivo));
    }

    @Test
    public void abrirNullFile() {
        GestionArchivos oper = new GestionArchivos();
        String archivo = null;
        assertEquals(0, oper.abrirArchivo(archivo));
    }

}
