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
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

public class Archivo_Objetos {
    
     private File f;
     private static File ficheroServicioMesa=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
     private List<ServicioMesa> serviMesa=new ArrayList<>();
     private File archivoTemporal;
     
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
    public static boolean CrearArchivoServicioMesa(){
        boolean b=false;
        try {
            if (ficheroServicioMesa.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public boolean CrearNuevoArchivoServicioMesa(){
        boolean b=false;
        try {
            archivoTemporal=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa2.txt");
            if (archivoTemporal.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public void removeLineFromFile(String archivo, Object lineToRemove){ //String archivo es el archivo que se va a eliminar y poder crear uno temporal
       //System.out.println(archivo);
        File inFile = new File(archivo);
        int numLineas = 0;

        if (!inFile.isFile()) {
            System.out.println("No existe el archivo");
            return;
        }
        try {
        //Construir el nuevo archivo que posteriormente se cambiará el nombre al nombre del archivo original,
        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            
        } catch (Exception e) {
        }
        
        //Object line = null;
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        int contador = 0;
        try {
            FileInputStream fich = new FileInputStream("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
            ObjectInputStream ois = new ObjectInputStream(fich);
            ServicioMesa line = new ServicioMesa();
            line = (ServicioMesa) ois.readObject();
            while (line != null) {
                c.add(line);
                line = (ServicioMesa) ois.readObject();
                contador++;
            }
            ois.close();
            fich.close();
        } catch (EOFException e1) {
            System.out.println ("Fin de fichero");
            System.out.println("Número de lineas: " + contador);
            ServicioMesa arrayObjetos[]= new ServicioMesa[contador];
        try {
            FileInputStream fich = new FileInputStream("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
            ObjectInputStream ois = new ObjectInputStream(fich);
            ServicioMesa line = new ServicioMesa();
            line = (ServicioMesa) ois.readObject(); 
            int i = 0;
            System.out.println("i: " + i);
            
            while (!line.equals(lineToRemove)) {
               //i++;
               c.add(line);
               line = (ServicioMesa) ois.readObject();
               arrayObjetos[i]=line; 
               //System.out.println("line: " + line);
               // System.out.println("arrayObjetos[i]: " + arrayObjetos[i]);
              //  System.out.println(((Object)arrayObjetos[i]).getClass().getName());
              //  System.out.println("lineToRemove: " + lineToRemove);
              //  System.out.println(((Object)lineToRemove).getClass().getName());
             // System.out.println("arrayObjetos[i].equals(line): " + arrayObjetos[i].equals(line));
             System.out.println("arrayObjetos[i]: " + arrayObjetos[i]);
                if (!arrayObjetos[i].equals(lineToRemove)) {
                    
                    System.out.println("arrayObjetos[i]: " + arrayObjetos[i]);
                    System.out.println("Estoy aqu'i: "+ arrayObjetos[i].equals(line));
                } else {
                    System.out.println("La linea existe[i]: " + lineToRemove);
                }
            }
            ois.close();
            fich.close();
       
           /* ServicioMesa nuevo = new ServicioMesa();
            nuevo = (ServicioMesa) objeto;*/
            //EscribirArchivoServicioMesa(arrayObjetos[i]);
            //EscribirArchivoServicioMesa(arrayObjetos[i]);
            //FileOutputStream fich2 = new FileOutputStream(inFile);
            //ObjectOutputStream oos=new ObjectOutputStream(fich2);
        } catch (Exception e) {
            System.out.println ("Fin de fichero");
        }
        
        try {
           File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
           System.out.println("archivo temporal: " + tempFile);
            FileOutputStream flujoSalida =null;
            ObjectOutputStream salida =null;
            boolean bandera=false;
            if (!tempFile.isFile()) {
                System.out.println("No existe el archivo");
                return;
            }
           System.out.println("arrayObjetos.length: "+ arrayObjetos.length );
            flujoSalida = new FileOutputStream(tempFile);
            salida = new ObjectOutputStream(flujoSalida);
            for (int j = 0; j < arrayObjetos.length; j++) {
                    //j++;
                    System.out.println("j: " + j);
                /*if (arrayObjetos[0].equals(lineToRemove)) {
                    bandera = true;
                    System.out.println("Elemento Eliminado");
                } else {
                    salida.writeObject(arrayObjetos[j]);
                    System.out.println("NarrayObjetos[j]: " + arrayObjetos[j]);
                    flujoSalida.flush();
                    flujoSalida.close();
                    salida.close();
                    
                }*/
            }       
            
        } catch (Exception e) {
            //if (bandera == true) {
                File f = new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
                if (f.exists()) {
                    System.out.println(f.getAbsolutePath());
                    if (f.delete()) {
                        System.out.println("Fichero eliminado");
                    } else {
                        System.out.println("No se ha podido eliminar");
                    }
                } else {
                    System.out.println("El fichero " + f.getAbsolutePath() + " no existe");
                }
            //}
        }
           /* boolean bandera=false;
            System.out.println("bandera: " + bandera);
                try {
            for (int j = 0; j < arrayObjetos.length; j++) {
                //Object l [] = arrayObjetos[i]("%");
                    
               // System.out.println("arrayObjetos[j].equals(lineToRemove): " + arrayObjetos[j].equals(lineToRemove));
                if (arrayObjetos[0].equals(lineToRemove)) {
                    bandera = true;
                    System.out.println("Elemento Eliminado");
                } else {
                    EscribirArchivoServicioMesa(arrayObjetos[j]);
                }
            }
            if (bandera) {
                System.out.println("No se encontró la línea");
            }
                } catch (Exception e) {
                }
   
            //oos.flush();
           // oos.close();
           // fich.close();
            if (numLineas==1 && bandera==true) {
                inFile.delete();
            }
    
            
            */
            
            
        } catch (Exception e2) {
            e2.printStackTrace();
        }
       // PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        //Leer el archivo original y escribir en el nuevo
        //menos que los datos se adapte al contenido que deben eliminarse.
        
        

        //leemos
        //ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));

        /*Recorro el fichero de texto linea a linea*/
        //while (line = br.r) {

        //}


       /* File f = new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
        if (f.exists()) {
            System.out.println(f.getAbsolutePath());
            if (f.delete()) {
                System.out.println("Fichero eliminado");
            } else {
                System.out.println("No se ha podido eliminar");
            }
        } else {
            System.out.println("El fichero " + f.getAbsolutePath() + " no existe");
        }*/
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
        /************************
     * Función que nos escribe el ArrayList en el fichero de disco.
     */
    public void escribirArchivoServicioMesa(){
        try{
             
            FileOutputStream fos = new FileOutputStream(ficheroServicioMesa);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serviMesa);
            oos.close();
            fos.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
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
            FileInputStream fich = new FileInputStream(ficheroServicioMesa);
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
    public void verDatosServicioMesa(){
            if(!ficheroServicioMesa.exists()){
                System.err.println("NO EXISTEN DATOS");
            } else {
                abrirArchivoServicioMesa();
                //serviMesa
                System.out.println(serviMesa);
                if (serviMesa != null) {
                    int contador=1;
                    for (ServicioMesa servicioMesa : serviMesa) {
                         System.out.println("Registro nº "+contador+" - "+servicioMesa.toString());
                    contador++;
                    }
                    
                }
            }
    }
    public void abrirArchivoServicioMesa(){
        try{
            if(!ficheroServicioMesa.exists()){
                CrearArchivoServicioMesa();
            }else{
                if(ficheroServicioMesa.canRead()){
                    FileInputStream fis = new FileInputStream(ficheroServicioMesa);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    serviMesa = (ArrayList<ServicioMesa>)ois.readObject();
                    ois.close();
                    fis.close();
                }else{
                    System.err.println("FICHERO VACÍO");
                }
            }
        }catch(IOException | ClassNotFoundException ex){
            System.err.println("Error: "+ex.getMessage());
        }
    }
    public void modifiicar_ServicioMesa(ArrayList<ServicioMesa> c1) {
        // TODO Auto-generated method stub

        try {

            FileOutputStream fich = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fich);
            for (int i = 0; i < c1.size(); i++) {
                c1.get(i).setAbierta(true);
                oos.writeObject(c1.get(i));
            }
            oos.flush();
            oos.close();
            fich.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
     /**
     * ****************************************************************************
     *                          Consumición Mesa 
     * ****************************************************************************
     */    
    public boolean CrearArchivoConsumicionMesa(){
        boolean b=false;
        try {
            f=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/consumicionmesa.txt");
            if (f.exists())
            b=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }  
    public void EscribirArchivoConsumicionMesa(ConsumicionMesa consumicion){
        try {
            FileOutputStream fich = new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fich);
            oos.writeObject(consumicion);
            oos.flush();
            oos.close();
            fich.close();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }  
    public void AñadirArchivoConsumicionMesa(ConsumicionMesa consumicion) {
        try{
            FileOutputStream fich=new FileOutputStream(f,true);
            MiObjectOutputStream oos = new MiObjectOutputStream(fich);
            oos.writeUnshared(consumicion);
            oos.flush();
            oos.close();
            fich.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<ConsumicionMesa> LeerArchivoConsumicionMesa() {
        ArrayList<ConsumicionMesa> c = new ArrayList<ConsumicionMesa>();
        try {
            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fich);
            ConsumicionMesa consuMesa = new ConsumicionMesa();
            consuMesa = (ConsumicionMesa) ois.readObject();
            while (consuMesa != null) {
                c.add(consuMesa);
                consuMesa = (ConsumicionMesa) ois.readObject();
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
    public void EliminarArchivo(){
        f=new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/camareros.txt");
        
         if(f.exists()){
            System.out.println(f.getAbsolutePath());
            if(f.delete()){
                System.out.println("Fichero eliminado");
            }  else{
                System.out.println("No se ha podido eliminar");
            }
        }  else{
            System.out.println("El fichero " + f.getAbsolutePath() + " no existe");
        } 
     }
}
