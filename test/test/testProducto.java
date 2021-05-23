/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.Item;
import logica.OperItem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CARITO
 */
public class testProducto {

    public testProducto() {
    }

    @Test
    public void creacionExitosaProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setNombre("Item de prueba");
        item.setPrecio(10L);
        item.setCategoria("Alimentacion");

        assertEquals(1, oper.insert(item));
    }

    @Test
    public void creacionVaciosProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setNombre("");
        item.setCategoria("");
        item.setPrecio(0L);
        assertEquals(0, oper.insert(item));
    }

    @Test
    public void creacionNullProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        assertEquals(0, oper.insert(item));
    }

    @Test
    public void creacionVacioNombreProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setNombre("");
        item.setCategoria("Alimentacion");
        item.setPrecio(2000L);
        assertEquals(0, oper.insert(item));
    }

    @Test
    public void creacionVacioCategoriaProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setNombre("Nombre1");
        item.setCategoria("");
        item.setPrecio(2000L);
        assertEquals(0, oper.insert(item));
    }

    @Test
    public void creacionVacioPrecioProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setNombre("Nombre1");
        item.setCategoria("Alimentacion");
        item.setPrecio(0L);
        assertEquals(0, oper.insert(item));
    }

    @Test
    public void eliminarVacioProducto() {
        OperItem oper = new OperItem();
        int id = 0;
        assertEquals(0, oper.delete(id));
    }

    @Test
    public void eliminarExitosoProducto() {
        OperItem oper = new OperItem();
        int id = 2;
        assertEquals(1, oper.delete(id));
    }

    @Test
    public void editarExitosoProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setId(1);
        item.setNombre("Nombre");
        item.setCategoria("Transporte");
        item.setPrecio(10000L);
        assertEquals(1, oper.update(item));
    }

    @Test
    public void editarVaciosProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setId(0);
        item.setNombre("");
        item.setCategoria("");
        item.setPrecio(0L);
        assertEquals(0, oper.update(item));
    }

    @Test
    public void editarVacioIdProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setId(0);
        item.setNombre("Nombre");
        item.setCategoria("transporte");
        item.setPrecio(10000L);
        assertEquals(0, oper.update(item));
    }

    @Test
    public void editarVacioStringProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setId(2);
        item.setNombre("");
        item.setCategoria("");
        item.setPrecio(0L);
        assertEquals(0, oper.update(item));
    }

    @Test
    public void editarVacioPrecioProducto() {
        Item item = new Item();
        OperItem oper = new OperItem();
        item.setId(2);
        item.setNombre("Nombre");
        item.setCategoria("Alimentacion");
        item.setPrecio(0L);
        assertEquals(0, oper.update(item));
    }
}
