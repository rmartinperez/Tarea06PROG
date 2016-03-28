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
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

public class Archivo_Objetos {
     private File f;
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
    public void removeLineFromFile(String archivo, Object lineToRemove){ //String archivo es el archivo que se va a eliminar y poder crear uno temporal
        try {

        //System.out.println(archivo);
        File inFile = new File(archivo);

        if (!inFile.isFile()) {
            System.out.println("No existe el archivo");
            return;
        }
            //Construir el nuevo archivo que posteriormente se cambiará el nombre al nombre del archivo original,
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            //Leer el archivo original y escribir en el nuevo
            //menos que los datos se adapte al contenido que deben eliminarse.
            Object line = null;
            Object a = null;
            

            //leemos
            ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
            try {
                //FileInputStream entrada = new FileInputStream(f);
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt"));
                ServicioMesa serviMesa = new ServicioMesa();
                //serviMesa = (ServicioMesa) ois.readObject();
                try {
                    /*Recorro el fichero de texto linea a linea*/ 
                    while (true) {
                        c.add(serviMesa);
                        Object o = entrada.readObject();
                        line = (ServicioMesa) o; 
                        /*Si la lia obtenida es igual a la bucada para modificar*/  
                       if (line.equals(lineToRemove) == false) {
                            //escribimos
                                FileOutputStream flujoSalida = null;
                                ObjectOutputStream salida = null;
                            try {
                                flujoSalida = new FileOutputStream("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");
                                salida = new ObjectOutputStream(flujoSalida);
                                salida.writeObject(line);
                                salida.close();
                                /*br.close(); 
                                pw.close();*/
                            } catch (Exception ex) {
                                System.out.println("Error de E/S");
                                ex.printStackTrace();
                            }
                        }
                    }
                } catch (EOFException ex) {
                    System.out.println("Fin de Lectura");
                    entrada.close();
                    pw.close();
                    br.close();
                }

            } catch (EOFException e1) {
                System.out.println ("Fin de fichero"); 
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        File f = new File("D:/Ejercicios_Java/Tarea6PROG/src/tarea6prog/serviciomesa.txt");             
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
   
 /*   public void borrar_ServicioMesa(intc1) {
        // TODO Auto-generated method stub
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        ServicioMesa p;
        try {

            FileInputStream fich = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fich);
            p = (ServicioMesa) oos.readObject();
            
            for (int i = 0; i < p size(); i++) {
                oos.writeObject(c1.remove(i));
            }
            oos.flush();
            oos.close();
            fich.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
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
}
