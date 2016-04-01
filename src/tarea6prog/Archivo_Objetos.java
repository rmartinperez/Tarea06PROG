/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

/**
 *
 * @author Rmartin
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.swing.JOptionPane;

public class Archivo_Objetos {
     private File f;
/** ***************************************************************************
 *                           CAMAREROS
 ******************************************************************************/     
    public boolean CrearArchivoCamareros(){
        boolean b=false;
        try {
            f=new File("tarea6prog_camareros.txt");
            if (f.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public void EscribirArchivoCamareros(Camareros prov){
        try {
            FileOutputStream fich = new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fich);
            oos.writeObject(prov);
            oos.flush();
            oos.close();
            fich.close();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void AnadirArchivoCamareros(Camareros prov) {
        try{
            FileOutputStream fich=new FileOutputStream(f,true);
            MiObjectOutputStream oos = new MiObjectOutputStream(fich);
            oos.writeUnshared(prov);
            oos.flush();
            oos.close();
            fich.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Camareros> LeerArchivoCamareros() {
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        try {
            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fich);
            Camareros prov = new Camareros();
            prov = (Camareros) ois.readObject();
            while (prov != null) {
                c.add(prov);
                prov = (Camareros) ois.readObject();
            }
            ois.close();
            fich.close();
        } catch (EOFException e1) {
// System.out.println ("Fin de fichero");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return c;
    }
/** ***************************************************************************
 *                           PRODUCTOS
 ******************************************************************************/
    public boolean CrearArchivoProductos(){
        boolean b=false;
        try {
            f=new File("tarea6prog_productos.txt");
            if (f.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public void EscribirArchivoProductos(Productos pro){
        FileOutputStream fos = null;
        ObjectOutputStream salida=null;
        try {          
            //Se crea la comunicación con el fichero
            fos = new FileOutputStream(f);
            salida = new ObjectOutputStream(fos);
            //Se crean los objetos Productos a ingresar
            //en este caso nos entra por parámetro un objeto de Productos ->  pro
            // si no sería -> pro = new Productos("12345678A","Tomates", 30);
            //Se escribe el objeto en el fichero
            salida.writeObject(pro);
            //Los recursos asignados al OutputStream se liberan con el método close(). Este método, además, garantiza que los datos que hayamos escrito en el flujo pero que aun no hayan sido enviados (a un archivo, por ejemplo) se manden a su destino. En los casos en que queramos asegurarnos de que los datos han sido enviados, pero no queramos cerrar el flujo, podemos usar el método flush(), que vacía los buffers de salida.
            fos.flush();
            //se cierra la comunicación con el fichero
            fos.close();
            //se cierra la salida de datos hacia el fichero
            salida.close();
              
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void AnadirArchivoProductos(Productos prod) {
        try{
            FileOutputStream fich=new FileOutputStream(f,true);
            MiObjectOutputStream oos = new MiObjectOutputStream(fich);
            oos.writeUnshared(prod);
            oos.flush();
            oos.close();
            fich.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    } 
    public ArrayList<Productos> LeerArchivoProductos() { //Función que nos devuelve un arrayList de Producto
        ArrayList<Productos> c = new ArrayList<Productos>();
        try {
            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fich);
            Productos prod = new Productos();
            prod = (Productos) ois.readObject();
            while (prod != null) {
                // Añadimos el objeto "prod" al ArrayList
                c.add(prod);
                // ois.readObject() lo convierto al objeto prod
                prod = (Productos) ois.readObject(); // el método readObject() que devuelve el objeto del fichero (tipo Object). Es necesario hacer un casting para guardarlo en una variable del tipo adecuado. 
            }
            ois.close();
            fich.close();
        } catch (EOFException e1) {

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return c;
    }  
     /**
     * Función que modifica los valores de un producto, pasando por parámetro
     * el arraylist del producto y su posición.
     * 
     */
    public void ModificaArchivoProductos(ArrayList producto, int pos){ // pos es la posición el array list
        FileOutputStream fos = null;
        ObjectOutputStream salida=null;
        LeerArchivoProductos();
        try {          
            //Se crea la comunicación con el fichero
            fos = new FileOutputStream(f);
            salida = new ObjectOutputStream(fos);
            
            for (int i = 0; i < producto.size(); i++) {
                salida.writeObject(producto.get(i));
             }
            //Los recursos asignados al OutputStream se liberan con el método close(). Este método, además, garantiza que los datos que hayamos escrito en el flujo pero que aun no hayan sido enviados (a un archivo, por ejemplo) se manden a su destino. En los casos en que queramos asegurarnos de que los datos han sido enviados, pero no queramos cerrar el flujo, podemos usar el método flush(), que vacía los buffers de salida.
            fos.flush();
            //se cierra la comunicación con el fichero
            fos.close();
            //se cierra la salida de datos hacia el fichero
            salida.close();
              
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void EliminarProductoArchivo(ArrayList producto, int pos){ //Función que no devuelve el fichero con el elemento eliminado
        FileOutputStream fos = null;
        ObjectOutputStream salida=null;
        LeerArchivoProductos();
        try {          
            //Se crea la comunicación con el fichero
            fos = new FileOutputStream(f);
            salida = new ObjectOutputStream(fos);
            
            for (int i = 0; i < producto.size(); i++) {
                salida.writeObject(producto.get(i));
             }
            //Los recursos asignados al OutputStream se liberan con el método close(). Este método, además, garantiza que los datos que hayamos escrito en el flujo pero que aun no hayan sido enviados (a un archivo, por ejemplo) se manden a su destino. En los casos en que queramos asegurarnos de que los datos han sido enviados, pero no queramos cerrar el flujo, podemos usar el método flush(), que vacía los buffers de salida.
            fos.flush();
            //se cierra la comunicación con el fichero
            fos.close();
            //se cierra la salida de datos hacia el fichero
            salida.close();
              
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }  
    
}
