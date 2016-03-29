/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6;

/**
 *
 * @author Rmartin
 */
import java.io.Serializable;

public class Cliente implements Serializable{
    //public static final long serialVersionUID = 1L;
    private String nif;
    private String nombre;
    private long telefono;
    private String direccion;
    private float deuda;
    
    public Cliente(String nif, String nombre, long telefono, String direccion, float deuda){
        this.nif=nif;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.deuda=deuda;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    @Override
    /**
     * Método sobreescrito para obtener todos los datos del cliente por pantalla
     */
    public String toString(){
        return "Nombre: "+getNombre()+", NIF: "+getNif()+", Dirección: "+getDireccion()+", Teléfono: "+getTelefono()+", Deuda: "+getDeuda();
    }
    
    
   

}

