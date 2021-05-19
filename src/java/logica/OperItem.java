/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
    public int insert(Item dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        try {
            String sql = "INSERT INTO productoServicio(nombre, categoria, precio) VALUES (?,?,?)";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setString(1, dato.getNombre());
                    ps.setString(2, dato.getCategoria());
                    ps.setLong(3, dato.getPrecio());
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

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
    public int delete(int id) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        try {
            String sql = "DELETE FROM productoServicio WHERE id=?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setInt(1, id);
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error al elminar productoServicio....");
                    Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar ProductoServicio: PreparedStatement...");
            Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }


    @Override
    public int update(Item data) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        try {
            String sql = " UPDATE productoServicio SET nombre=?,categoria=?, precio=? where id=?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setInt(4, data.getId());
                    ps.setString(1, data.getNombre());
                    ps.setString(2, data.getCategoria());
                    ps.setLong(3, data.getPrecio());
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en update: PreparedStatement...");
            Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

}
