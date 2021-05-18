/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.File;
import dto.Item;
import java.sql.Connection;
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
public class OperFile implements Operaciones<File> {

    @Override
    public int insert(File dato) {
        return 0;
    }

    @Override
    public List<File> getAll() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<File> listaFile = new ArrayList<File>();
        try {
            String sql = "SELECT * FROM archivos";
            Statement stmt = cActiva.createStatement();
            ResultSet respuesta = stmt.executeQuery(sql);
            if (cActiva != null) {
                try {
                    while (respuesta.next()) {
                        File file = new File(
                            respuesta.getString("nombre"),
                            respuesta.getString("fecha")
                        );
                        listaFile.add(file);
                    }
                    return listaFile;
                } catch (SQLException ex) {
                    System.out.println("Error al listar los archivos....");
                    Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    stmt.close();
                    respuesta.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en listar archivos: Statement o ResultSet...");
            Logger.getLogger(OperItem.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(File dato) {
        return 0;
    }

    /*@Override
    public int insert(Producto dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        try {
            String sql = "INSERT INTO productos(nombre, descripcion, categoria, bodega, peso) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setString(1, dato.getNombre());
                    ps.setString(2, dato.getDescripcion());
                    ps.setString(3, dato.getCategoria());
                    ps.setString(4, dato.getBodega());
                    ps.setFloat(5, dato.getPeso());
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error al crear el usuario...");
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en crear: PreparedStatement...");
            Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public List<Producto> getAll() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Producto> listaProductos = new ArrayList<Producto>();
        try {
            String sql = "SELECT * FROM productos";
            Statement stmt = cActiva.createStatement();
            ResultSet respuesta = stmt.executeQuery(sql);
            if (cActiva != null) {
                try {
                    while (respuesta.next()) {
                        Producto producto = new Producto(
                                respuesta.getInt("id"),
                                respuesta.getString("nombre"),
                                respuesta.getString("descripcion"),
                                respuesta.getString("categoria"),
                                respuesta.getString("bodega"),
                                respuesta.getFloat("peso")
                        );
                        listaProductos.add(producto);
                    }
                    return listaProductos;
                } catch (SQLException ex) {
                    System.out.println("Error al listar los productos....");
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    stmt.close();
                    respuesta.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en listar: Statement o ResultSet...");
            Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public int delete(int id) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        System.out.println(id);
        try {
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setInt(1, id);
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error al elminar producto....");
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en delete: PreparedStatement...");
            Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    
    @Override
    public int update(Producto data) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        try {
            String sql = " UPDATE productos SET nombre=?,descripcion=?, categoria=?, bodega=?, peso=? where id=?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setInt(6, data.getId());
                    ps.setString(1, data.getNombre());
                    ps.setString(2, data.getDescripcion());
                    ps.setString(3, data.getCategoria());
                    ps.setString(4, data.getBodega());
                    ps.setFloat(5, data.getPeso());
                    System.out.println("modificado ok");
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error al elminar producto....");
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en update: PreparedStatement...");
            Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
     */
}
