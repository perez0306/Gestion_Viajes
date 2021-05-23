/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.File;
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
public class OperFile implements Operaciones<File> {

    public OperFile() {
    }

    @Override
    public int insert(File dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();

        if (dato == null || dato.getNombreArchivo() == null || dato.getFechaArchivo() == null) {
            return 0;
        }
        if (dato.getId() > 0
                || dato.getNombreArchivo().isEmpty()
                || dato.getFechaArchivo().isEmpty()) {
            return 0;
        }

        try {
            String sql = "INSERT INTO archivos (nombre, fecha) VALUES (?,?)";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setString(1, dato.getNombreArchivo());
                    ps.setString(2, dato.getFechaArchivo());
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
                                respuesta.getInt("id"),
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
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();

        if (id < 1) {
            return 0;
        }

        try {
            String sql = "DELETE FROM archivos WHERE id=?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            if (cActiva != null) {
                try {
                    ps.setInt(1, id);
                    return ps.executeUpdate();
                    
                } catch (SQLException ex) {
                    System.out.println("Error al elminar archivo....");
                    Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ps.close();
                    c.desconectase(cActiva);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar archivo: PreparedStatement...");
            Logger.getLogger(OperFile.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public int update(File dato) {
        return 0;
    }

  
}
