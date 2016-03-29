/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Menu {
  
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)); //Objeto de BufferedReader
    private static Camareros camareros = new Camareros();
    private static List<Camareros> camarerosArrayList=new ArrayList<>();   // Objeto arrayList de Camareros
    private static Archivo_Objetos archivo = new Archivo_Objetos(); //Objeto de Archivo_Objetos
 
    

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int opcionElegida = 0;

        //Bucle principal que controla la ejecución del programa. 
        //Se trata de un bucle do-while que ejecuta mientras la opción 
        //introducida sea distinta a 4.
        System.out.println("Selecciona una opción del siguiente menú");
        System.out.println("\t1. Entrada Camareros.");
        System.out.println("\t2. Consultar Camareros.");
        System.out.println("\t3. Entrada Productos.");
        System.out.println("\t4. Consultar Productos.");
        System.out.println("\t5. Abrir Servicio Mesa.");
        System.out.println("\t6. Consumición Mesa.");
        System.out.println("\t7. Total Cuenta de Mesa.");
        System.out.println("\t8. Listado de los servicios de una mesa por fechas.");
        System.out.println("\t9. Listado de los servicios que ha hecho un camarero.");
        System.out.println("\t10. Salir\n");

        //Bucle principal que controla la ejecución del programa. 
        //Se trata de un bucle do-while que ejecuta mientras la opción 
        //introducida sea distinta a 10.
        do {
            System.out.print("Elegir la opción: ___");
            try {
                opcionElegida = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcionElegida) {
                case 1: //Entrada Camareros 
                    registroCamareros();                    

                    break;
                case 2: //Consultar Camareros
                    //buscarCamareroDNI();
                    archivo.listarCamareros();
  
                    break;
                case 3: //Entrada Productos
  
                    break;
                case 4: //Consultar Productos
                
                    break;
                case 5: //Abrir Servicio Mesa          

                    break;
                case 6: //Consumición Mesa

                    break;
                case 7: //Total Cuenta de Mesa

                    break;
                case 8: //Listado de los servicios de una mesa por fechas

                    break;
                case 9: //Listado de los servicios que ha hecho un camarero

                    break;
                case 10: //Salir

                    break;
                default:
            }// end. switch
        } while (opcionElegida != 10);

    } //end void main
    /**
     * ****************************************************************************
     *                          Camareros 
     * ****************************************************************************
     */
    public static  void registroCamareros(){
        try {
            String nif, nombre,telefono,direccion,fecha;
            boolean abrir=true;

            archivo.abrirArchivoCamareros();
            
            
            System.out.print("Introduzca el NIF: ");
            nif = entrada.readLine();
            System.out.print("Introduzca en nombre: ");
            nombre = entrada.readLine();
            System.out.print("Introduzca el teléfono: ");
            telefono = entrada.readLine();
            System.out.print("Introduzca la dirección: ");
            direccion = entrada.readLine();
            //creacción de la fecha
            fecha = camareros.getFechaAlta();
            
            if (camarerosArrayList.isEmpty()) {  // isEmpty -> Indica si la colección está vacía
                camarerosArrayList=new ArrayList<Camareros>(); //creo un objeto del arrayList Camareros 
            }
            Camareros c = new Camareros(nif, nombre, telefono, direccion);
            
            camarerosArrayList.add(c);
             archivo.escribirArchivoCamarero(camarerosArrayList);

            //Menu.escribirArchivoCamarero();
            
         /*  if (abrir == false) {
                archivo.escribirArchivoCamarero(camarerosArrayList);
            } else {
                archivo.anadirArchivoCamarero();
            }
                //archivo.escribirArchivoCamarero();
          */
            System.out.println("****************** Camarero "+ camarerosArrayList.size() +" añadido ********");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }  
    }
    public static void buscarCamareroDNI(){
        try {
            String buscar;
            System.out.println("Introduce el nif del camarero");
            String nif = entrada.readLine();
            archivo.abrirArchivoCamareros();
            int contador = 0;
            boolean encontrado = false;
            for (Camareros camareros1 : camarerosArrayList) {
                if (camareros1.getNIF().equals(nif)) {
                    encontrado = true;
                    System.out.println("Registro nº " + contador + " - " + camareros1.toString());
                }
                contador++;
            }
            if (encontrado) {
                System.err.println("EL CAMARERO NO EXITE");
            }
            
        } catch (Exception ex) {
           System.out.println("Error: "+ex.getMessage());
        }
        
    }
    public void eliminarCamarero(){
        
    }
       
} //end class Menu
