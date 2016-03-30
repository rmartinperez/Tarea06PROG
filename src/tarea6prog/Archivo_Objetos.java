/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

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
    public void abrirArchivoCamareros() { // si lo pongo como public static void no podría leer esta función en el archivo Menu. 
        try {
            if (!ficheroCamareros.exists()) {
                crearArchivoCamarero();
            } else {
                if (ficheroCamareros.canRead()) {
                    FileInputStream fis= new FileInputStream(ficheroCamareros);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    camarerosArrayList = (ArrayList<Camareros>)ois.readObject();
                    ois.close();
                    fis.close();
            } 
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al leer objetos: " + ex);
            
        }catch (IOException ex) {
            System.err.println("Fichero vacío");
        }
    } // end.abrirArchivoCamareros()
    public void crearArchivoCamarero(){
        try {
            ficheroCamareros.createNewFile();
            System.out.println("Fichero Creado");
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } 
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
            FileOutputStream fich = new FileOutputStream(ficheroCamareros, true);
            ObjectOutputStream oos = new ObjectOutputStream(fich);
            oos.writeObject(camarerosArrayList);
            oos.flush();
            oos.close();
            fich.close();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    } // end.anadirArchivoCamarero()   
    public void listarCamareros(){
        if (!ficheroCamareros.exists()) {
            System.err.println("NO HAY FICHERO CREADO DE CAMAREROS");
        } else {
            
           abrirArchivoCamareros();
            if (camarerosArrayList !=null) {
                int contador = 1;
                for (Camareros variableCamarero : camarerosArrayList) {
                    System.out.println("Registro nº " + contador + " - "+ variableCamarero.toString());
                    contador++; //incrementamos el contador
                }
            } else {
            }
        }
    } // end.listarCamareros()  
    public void leerArchivoCamarero(){
        
    }
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
