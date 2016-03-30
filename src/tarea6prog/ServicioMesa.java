/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Rmartin
 */
public class ServicioMesa implements Serializable {

    //private static final long serialVersionUID = 1L;

      
    private int numeroMesa;
    private String nif;
    
    // Instanciamos el objeto Calendar
    Calendar calendar = Calendar.getInstance();
    // Obtenemos el valor del año, mes y día.
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH)+1;
    int date = calendar.get(Calendar.DATE);

    private String fecha=  date + "/" + month + "/" + year;
    private int numeroServicio; 
    private boolean abierta;

    public ServicioMesa() {
    }

    public ServicioMesa(int numeroMesa, String nif, int numeroServicio, boolean abierta, String fecha) {
        this.numeroMesa = numeroMesa;
        this.nif = nif;
        this.numeroServicio = numeroServicio;
        this.abierta = abierta;
        this.fecha = fecha;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    @Override
    public String toString() {
        return "ServicioMesa{" + "numeroMesa=" + numeroMesa + ", nif=" + nif + ", fecha=" + fecha + ", numeroServicio=" + numeroServicio + ", abierta=" + abierta + '}';
    }
    
    
}
