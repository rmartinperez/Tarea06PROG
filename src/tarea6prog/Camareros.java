/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.util.Calendar;
import java.io.*;

/**
 *
 * @author Rmartin
 */
public class Camareros implements Serializable{
    //Variables miembro
    String NIF;
    String Nombre;
    String Teléfono;
    String Dirección;
    
    // Instanciamos el objeto Calendar
    Calendar calendar = Calendar.getInstance();
    // Obtenemos el valor del año, mes y día.
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int date = calendar.get(Calendar.DATE);
    
    String fechaAlta=  date + "/" + month + "/" + year;
    /*
     public static void main(String[] args) {
    System.out.println("AÑO ACTUAL: " + year);
    System.out.println("MES ACTUAL: " + (month+1));
    System.out.println("DÍA ACTUAL: " + date);
    
    }
    */
    public Camareros() {
    }
    
    public Camareros(String NIF, String Nombre, String Teléfono, String Dirección, String fechaAlta) {
        this.NIF = NIF;
        this.Nombre = Nombre;
        this.Teléfono = Teléfono;
        this.Dirección = Dirección;
        this.fechaAlta = fechaAlta;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(String Teléfono) {
        this.Teléfono = Teléfono;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Camareros{" + "NIF=" + NIF + ", Nombre=" + Nombre + ", Tel\u00e9fono=" 
                + Teléfono + ", Direcci\u00f3n=" + Dirección + ", fechaAlta=" + fechaAlta 
                + '}';
    }


    

}
