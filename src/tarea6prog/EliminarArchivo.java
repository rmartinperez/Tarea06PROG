/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.io.File;

/**
 *
 * @author Rmartin
 */
public class EliminarArchivo {
     public static void main(String[] args){
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
}
