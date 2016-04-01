/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.io.Serializable;

/**
 *
 * @author Rmartin
 */
public class Productos implements Serializable{
    String cod_barra;
    String denominación;
    float pvp;
    int unidades;

    public Productos() {
    }

    public Productos(String cod_barra, String denominación, float pvp, int unidades) {
        this.cod_barra = cod_barra;
        this.denominación = denominación;
        this.pvp = pvp;
        this.unidades = unidades;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getDenominación() {
        return denominación;
    }

    public void setDenominación(String denominación) {
        this.denominación = denominación;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Productos{" + "cod_barra=" + cod_barra + ", denominaci\u00f3n=" + denominación + ", pvp=" + pvp + ", unidades=" + unidades + '}';
    }
    

}
