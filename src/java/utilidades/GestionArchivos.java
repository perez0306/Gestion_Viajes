/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.Empleado;
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
    BufferedWriter bw = null;
    String ruta = "C:\\BD\\DatosProyect\\HistorialViajes\\";
    String extension = ".txt";

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

    public void escribirArchivo(SelectItem item, String destino, String fecha, String nombre) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + nombre + extension));

            bw.write("Item: " + item);
            bw.newLine();
            bw.write("Destino: " + destino);
            bw.newLine();
            bw.write("Fecha: " + fecha);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
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
