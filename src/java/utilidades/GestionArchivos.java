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
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

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

    public void escribirArchivo(Empleado empleado, String destino, String fecha, String nombre) {

        try {

            ps = new PrintStream(ruta + nombre + extension);

            ps.println("Empleado - " + empleado.getNombreEmpleado());
            ps.println("Rol - " + empleado.getRol());
            ps.println("Codigo - " + empleado.getId());
            ps.println("Destino - " + destino);
            ps.println("Fecha - " + fecha);

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
    }

    public void eliminarArchivo(String nombre) {
        File archivo = new File(ruta + nombre + extension);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero no puede ser borrado");
            }
        } else {
            System.out.println("No existe el fichero");
        }

    }

    public void abrirArchivo(String nombre) {
        try {
            File objetofile = new File(ruta + nombre + extension);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
