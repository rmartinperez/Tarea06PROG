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
    /**
     * ****************************************************************************
     *                          Camareros 
     * ****************************************************************************
     */    
    public boolean CrearArchivoCamareros(){
        boolean b=false;
        try {
            f=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/camareros.txt");
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
    public void AñadirArchivoCamareros(Camareros prov) {
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
    /**
     * ****************************************************************************
     *                          Productos 
     * ****************************************************************************
     */  
    public boolean CrearArchivoProductos(){
        boolean b=false;
        try {
            f=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/productos.txt");
            if (f.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public void EscribirArchivoProductos(Productos prov){
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
    public void AñadirArchivoProductos(Productos prov) {
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
    public ArrayList<Productos> LeerArchivoProductos() {
        ArrayList<Productos> c = new ArrayList<Productos>();
        try {
            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fich);
            Productos prov = new Productos();
            prov = (Productos) ois.readObject();
            while (prov != null) {
                c.add(prov);
                prov = (Productos) ois.readObject();
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
    /**
     * ****************************************************************************
     *                          Servicio Mesa 
     * ****************************************************************************
     */    
    public boolean CrearArchivoServicioMesa(){
        boolean b=false;
        try {
            f=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
            if (f.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
    public void EscribirArchivoServicioMesa(ServicioMesa servicio){
        try {
            FileOutputStream fich = new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fich);
            oos.writeObject(servicio);
            oos.flush();
            oos.close();
            fich.close();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void AñadirArchivoServicioMesa(ServicioMesa servicio) {
        try{
            FileOutputStream fich=new FileOutputStream(f,true);
            MiObjectOutputStream oos = new MiObjectOutputStream(fich);
            oos.writeUnshared(servicio);
            oos.flush();
            oos.close();
            fich.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<ServicioMesa> LeerArchivoServicioMesa() {
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        try {
            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fich);
            ServicioMesa serviMesa = new ServicioMesa();
            serviMesa = (ServicioMesa) ois.readObject();
            while (serviMesa != null) {
                c.add(serviMesa);
                serviMesa = (ServicioMesa) ois.readObject();
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
}
