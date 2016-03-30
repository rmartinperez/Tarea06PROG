/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog_BIS;

import java.io.File; // Librería para trabajar con ficheros
import java.io.FileInputStream; //Librería para crear el flujo hacia el fichero
import java.io.FileOutputStream; //Librería para crear el flujo hacia el programa
import java.io.IOException;
import java.io.ObjectInputStream; // Librería que envía los datos hacia el fichero
import java.io.ObjectOutputStream; // Librería que envía los datos hacia el programa
import java.util.ArrayList; //Librería para crear ArrayList
import java.util.List; //Librería para crear listas


/**
 *
 * @author Rmartin
 */


public class Archivo_Objetos {
    
    private File ficheroCamareros=new File("camareros.txt");
    private List<Camareros> camarerosArrayList=new ArrayList<>();
    
    
    /**
     * ****************************************************************************
     *                          Camareros 
     * ****************************************************************************
     */ 
    public boolean crearArchivoCamarero(){
        boolean b=false;
        try {
            if (ficheroCamareros.exists()) {
                b = true;
            } else {
                ficheroCamareros.createNewFile();
                System.out.println("Fichero Creado");
                b=true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } 
        return b;
    } // end.crearArchivoCamarero()  
    public void escribirArchivoCamarero(List<Camareros> camarerosArrayList){
        try {
            if(!ficheroCamareros.exists()) ficheroCamareros=new File("camareros.txt");
            FileOutputStream fos = new FileOutputStream(ficheroCamareros);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(camarerosArrayList);
            oos.close();
            fos.close();  
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    } // end.escribirArchivoCamarero()
    public void anadirArchivoCamarero(){
        try {
            if(!ficheroCamareros.exists()) ficheroCamareros=new File("camareros.txt");
            FileOutputStream fos = new FileOutputStream(ficheroCamareros);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(camarerosArrayList);
            oos.close();
            fos.close();  
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    } // end.escribirArchivoCamarero()    
    public List<Camareros> leerArchivoCamareros() {
        try {
            if (ficheroCamareros.canRead()) {
                FileInputStream fis = new FileInputStream(ficheroCamareros);
                ObjectInputStream ois = new ObjectInputStream(fis);
                camarerosArrayList = (ArrayList<Camareros>) ois.readObject();
                ois.close();
                fis.close();

            } else {
                System.err.println("No hay fichero");
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al leer objetos: " + ex);

        } catch (IOException ex) {
            System.err.println("Fichero vacío");
        }
        return camarerosArrayList;
    } // end.leerArchivoCamareros()
    /**
     * ****************************************************************************
     *                          Productos 
     * ****************************************************************************
     */  

     
    /**
     * ****************************************************************************
     *                          Servicio Mesa 
     * ****************************************************************************
     */    
 
     /**
     * ****************************************************************************
     *                          Consumición Mesa 
     * ****************************************************************************
     */    
    
}
