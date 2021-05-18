/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author CARITO
 */
public class File {
    private String nombreArchivo;
    private String fechaArchivo;

    public File() {
    }

    public File(String nombreArchivo, String fechaArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.fechaArchivo = fechaArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getFechaArchivo() {
        return fechaArchivo;
    }

    public void setFechaArchivo(String fechaArchivo) {
        this.fechaArchivo = fechaArchivo;
    }

    @Override
    public String toString() {
        return "File{" + "nombreArchivo=" + nombreArchivo + ", fechaArchivo=" + fechaArchivo + '}';
    }
 
}
