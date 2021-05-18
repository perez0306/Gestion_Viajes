/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Producto;
import database.Conexiones;
import dto.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Vinni
 */
public class OperItem implements Operaciones<Item> {

    @Override
    public int insert(Item dato) { return 0;   }

    @Override
    public List<Item> getAll() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Item> listaItems = new ArrayList<Item>();
        try {
            String sql = "SELECT * FROM productoServicio";
            Statement stmt = cActiva.createStatement();
            ResultSet respuesta = stmt.executeQuery(sql);
            if (cActiva != null) {
                try {
                    while (respuesta.next()) {
                        Item item = new Item(
                                respuesta.getInt("id"),
                                respuesta.getString("nombre"),
                                respuesta.getString("categoria"),
                                respuesta.getLong("precio")
                        );
                        listaItems.add(item);
                    }
                    return listaItems;
                } catch (SQLException ex) {
                    System.out.println("Error al listar los items....");
                    Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    stmt.close();
                    respuesta.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en listar Items: Statement o ResultSet...");
            Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

   
    
    @Override
    public int delete(int id) { return 0; }

    /**
     *
     * @param data
     * @param id
     * @return
     */
    @Override
    public int update(Item data) { return 0; }

}
