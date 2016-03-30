/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog_BIS;

import java.util.Calendar;
import java.io.*;

/**
 *
 * @author Rmartin
 */
public class Camareros implements Serializable{
    //Variables miembro
    String NIF;
    String nombre;
    String telefono;
    String direccion;
    
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
    
    public Camareros(String NIF, String nombre, String telefono, String direccion) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        return "Camareros{" + "NIF=" + NIF + ", nombre=" + nombre + ", Tel\u00e9fono=" 
                + telefono + ", Direcci\u00f3n=" + direccion + ", fechaAlta=" + fechaAlta 
                + '}';
    }


    

}
