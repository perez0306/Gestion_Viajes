package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Santiago Vargas
 */
public class EscrituraArchivo {

    BufferedWriter bw = null;

    public EscrituraArchivo() {
    }
    
    public void escribirArchivo(SelectItem item, String destino, String fecha, String nombre) {
        String ruta = "C:\\BD\\DatosProyect\\HistorialViajes\\";
        String archivo = nombre + ".txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + archivo));

            bw.write("Item: " + item);
            bw.newLine();
            bw.write("Destino: " + destino);
            bw.newLine();
            bw.write("Fecha: " + fecha);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != bw) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
