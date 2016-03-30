/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog_BIS;

import java.io.Serializable;

/**
 *
 * @author Rmartin
 */
public class ConsumicionMesa implements Serializable {
    
    private String cod_barra; // Producto
    private int unidades;
    private int numeroServicio; // Es el número que tiene cada mesa
    private float total;

    public ConsumicionMesa() {
    }

    public ConsumicionMesa(String cod_barra, int unidades, int numeroServicio, float total) {
        this.cod_barra = cod_barra;
        this.unidades = unidades;
        this.numeroServicio = numeroServicio;
        this.total = total;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ConsumicionMesa{" + "cod_barra=" + cod_barra + ", unidades=" + unidades + ", numeroMesa=" + numeroServicio + ", total=" + total + '}';
    }
    
    
}
