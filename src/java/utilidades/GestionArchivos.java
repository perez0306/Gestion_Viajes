/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.Empleado;
import dto.Item;
import java.awt.Desktop;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CARITO
 */
public class GestionArchivos {

    FileReader fr = null;
    BufferedReader br = null;
    String ruta = "C:\\BD\\DatosProyect\\HistorialViajes\\";
    String extension = ".txt";
    PrintStream ps = null;

    public List<Empleado> leerArchivoTH(String nombreDocumento) {
        if (nombreDocumento == null) {
            return null;
        }
        if (nombreDocumento.isEmpty()) {
            return null;
        }

        try {
            fr = new FileReader(nombreDocumento);
            br = new BufferedReader(fr);
            List<Empleado> resultado = new ArrayList<>();

            String linea;
            String nombre, rol;
            int id;

            while ((linea = br.readLine()) != null) {
                String informacion[] = linea.split("/");
                id = Integer.parseInt(informacion[0]);
                nombre = informacion[1];
                rol = informacion[2];
                Empleado empleado = new Empleado(nombre, id, rol);
                resultado.add(empleado);
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public int escribirArchivo(Empleado empleado, String destino, String fecha, String nombre, List<Item> lista, long suma) {

        if (empleado == null || destino == null || fecha == null || nombre == null) {
            return 0;
        }
        if (destino.isEmpty() || fecha.isEmpty() || nombre.isEmpty() || empleado.getNombreEmpleado().isEmpty() || empleado.getRol().isEmpty()) {
            return 0;
        }

        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            ps = new PrintStream(ruta + nombre + extension);
            ps.println("-----------" + dtf.format(LocalDateTime.now()) + "---------------");
            ps.println("Empleado - " + empleado.getNombreEmpleado());
            ps.println("Rol - " + empleado.getRol());
            ps.println("Destino - " + destino);
            ps.println("Fecha - " + fecha);
            ps.println("Item:");
            if (!lista.isEmpty()) {
                for (int i = 0; i < lista.size(); i++) {
                    ps.println("- " + lista.get(i).getNombre() + "  $" + lista.get(i).getPrecio());
                }

            }
            ps.println("TOTAL: $" + suma);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public int eliminarArchivo(String nombre) {

        if (nombre == null) {
            return 0;
        }
        if (nombre.isEmpty()) {
            return 0;
        }
        File archivo = new File(ruta + nombre + extension);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
                return 1;
            } else {
                System.out.println("El fichero no puede ser borrado");
                return 0;
            }
        } else {
            System.out.println("No existe el fichero");
        }
        return 0;
    }

    public int abrirArchivo(String nombre) {
        if (nombre == null) {
            return 0;
        }
        if (nombre.isEmpty()) {
            return 0;
        }
        try {
            File objetofile = new File(ruta + nombre + extension);
            Desktop.getDesktop().open(objetofile);
            return 1;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
