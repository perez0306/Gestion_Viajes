/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dto.Empleado;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author CARITO
 */
public class LecturaArchivo {

    FileReader fr = null;
    BufferedReader br = null;

    public ArrayList<Empleado> leerArchivoTH(String nombreDocumento) {
        int[] datos = null;
        long[] tiempos= null;
        try {
            fr = new FileReader(nombreDocumento);
            br = new BufferedReader(fr);
            ArrayList<Empleado> resultado = new ArrayList<>();

            // Lectura del fichero
            String linea;
            String nombre, rol;
            int id;
            
            while ((linea = br.readLine()) != null) {
                String informacion[] = br.readLine().split("/");
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
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
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
}
