/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.Item;
import dto.Viaje;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CARITO
 */
public class testViaje {

    public testViaje() {
    }

    @Test
    public void sumaExitosaProductos() {
        Viaje viaje = new Viaje();
        List<Item> lista = new ArrayList<Item>();
        Item item = new Item();
        item.setPrecio(5);
        lista.add(item);
        Item item2 = new Item();
        item2.setPrecio(10);
        lista.add(item2);

        assertEquals(15, viaje.sumarItems(lista));
    }
}
