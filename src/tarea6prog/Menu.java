/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger; 

public class Menu {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public static Camareros camarero = new Camareros();
    public static Productos producto = new Productos();
    public static Archivo_Objetos archivo = new Archivo_Objetos();
    public static ArrayList<Productos> c = new ArrayList<Productos>();
    

    public static void main(String[] args) {
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            switch (opcionElegida) {
                case 1: //Entrada Camareros 
                    entradaCamarero();
                    break;
                case 2: //Consultar Camareros
                    listarCamareros();
                    listarCamarerosDNI();
                    break;
                case 3: //Entrada Productos
                    entradaProductos();
                    break;
                case 4: //Consultar Productos
                    int opcion =0;
                    do {  
                        try{
                            System.out.println("\t Menú de opciones");
                            System.out.println("\t\t 1. Listar Productos.");
                            System.out.println("\t\t 2. Modificar producto dado el nombre.");
                            System.out.println("\t\t 3. Eliminar producto");
                            System.out.println("\t\t 4. Salir del menú");
                            System.out.print("\t Introduce la opción deseada (1-4): ___");
                            opcion = Integer.parseInt(entrada.readLine());
                            switch (opcion){
                                case 1: //listar productos
                                        listarProductos();
                                    break;
                                case 2: // modificar producto
                                        modificarProducto();
                                    break;
                                case 3: // eliminar producto
                                        eliminarProducto();
                                    break;
                                case 4: // salir
                                    break;                                
                            }
                        }catch (NumberFormatException nfe){
                            System.err.println("Sólo son válidos valores enteros entre 1 y 4");
                        }catch(IOException ioe){
                            System.err.println("Error de entrada de datos: "+ioe.getMessage());
                        }                        
                    } while (opcion!=4);
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
/** ***************************************************************************
 *                           CAMAREROS
 ******************************************************************************/  
    public static void entradaCamarero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        char respuesta = 0;
        int bandera = 0;
        camarero = new Camareros();
    /* Solicitamos el nombre */    
        System.out.print("Nombre: ");

        try {
            cadena = (entrada.readLine());
            if (cadena.length() > 0) {
                camarero.setNombre(cadena);
            } else {
                bandera = 1;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    /* Solicitamos el nombre */    
        System.out.print("NIF: ");

        try {
            cadena = (entrada.readLine());
            if (cadena.length() > 0) {
                camarero.setNIF(cadena);
            } else {
                bandera = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }        
    /* La fecha no hace falta solicitarla, se inserta automáticamente con el método getFechaAlta() */         
       // System.out.println("Fecha de alta: ");

            if (cadena.length() > 0) {
                camarero.getFechaAlta();
            } else {
                bandera = 5;
            }

        
        
        if (bandera == 0) {
            System.out.println("Grabar los Datos :");
            try {
                respuesta = entrada.readLine().charAt(0);
                if (respuesta == 's' || respuesta == 'S') {
                    escribeFichero(camarero, 1);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            switch (bandera) {
                case 1:
                    System.out.println("Entradas incorrecta del nombre");
                    break;
                case 2:
                    System.out.println("Entradas incorrecta del NIF");
                    break;
                case 3:
                    System.out.println("Entradas incorrecta del Codigo");
                    break;
                case 4:
                    System.out.println("Entradas incorrecta del Codigo");
                    break;
                case 5:
                    System.out.println("Entradas incorrecta del Fecha de Alta");
                    break;                    
            }
        }// end.if(bandera==0)
    }
    private static void listarCamareros() {
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        Camareros camarero = new Camareros();
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                cadena = cadena + c.get(i).toString() + "\n";
            }
            System.out.println(cadena);
        }
    }
    private static void listarCamarerosDNI() {
        try {
            System.out.print("Dame un DNI para buscar un camarero: ");
            String nif = entrada.readLine();
            ArrayList<Camareros> c = new ArrayList<Camareros>();
            Archivo_Objetos archivo = new Archivo_Objetos();
            Camareros camarero = new Camareros();
            if (archivo.CrearArchivoCamareros()) {
                c = archivo.LeerArchivoCamareros();
                for (int i = 0; i < c.size(); i++) {
                    if (c.get(i).getNIF().equals(nif)) {
                        System.out.println("\tNombre: " + c.get(i).getNombre());
                        System.out.println("\tDirección: " + c.get(i).getDirección());
                    }
                }
                /* int contador =0;
            for (Camareros camareros : c) {
                System.out.println("c: " + c.get(1));
                if (camareros.getNIF().toString().equals(nif)) {
                    System.out.println("Nombre: " + camarero.getNombre() + "Nif: " + camarero.getTeléfono());
                }
                contador++;
            }*/
            }
        } catch (Exception e) {
        }
    }    
/** ***************************************************************************
 *                           PRODUCTOS
 ******************************************************************************/ 
    public static void entradaProductos(){
            int bandera = 0;
            char respuesta = 0;
        try {
            System.out.print("Introduce un código de barras: ");
            String codBarras = entrada.readLine();
            if (codBarras != "") {
                producto.setDenominación(codBarras);
                bandera = 0;
            } else {
                bandera=1;
            }
            System.out.print("Introduce e nombre de un producto: ");
            String nombre = entrada.readLine();
            if (nombre != "") {
                producto.setDenominación(nombre);
                bandera = 0;
            } else {
                bandera=2;
            }            
            
        } catch (IOException ex) {
            
        }
        //Validaciones de entrada por teclado
        if (bandera == 0) {
            //Indicamos si se quiere gravar los datos
            System.out.println("Grabar los Datos :");
            try {
                
                respuesta = entrada.readLine().charAt(0); //Siempre que se quiera separar una cadena de texto a carácteres o sacar un simple carácter de una cadena, para ello se utiliza el método charAt(). 
                if (respuesta == 's' || respuesta == 'S') {
                    escribeFichero(producto, 2);
                }
            } catch (IOException e) { //Las señales que se ha producido una excepción de E / S de algún tipo. Esta clase es la clase general de excepciones producidas por las operaciones fallidas o interrumpidas de E / S.
                e.printStackTrace();
            }
        } else {
            switch(bandera){
                case 1:
                    System.out.println("Debes de introducir un código de barras");
                    break;
                case 2:
                    System.out.println("Debes de introducir una denominación");
                    break;                    
                default:
                    break;
            }
        }
        
    }
    public static void listarProductos(){
        ArrayList<Productos> c = new ArrayList<Productos>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoProductos()) {
            c = archivo.LeerArchivoProductos();
            for (int i = 0; i < c.size(); i++) {
                cadena = cadena + c.get(i).toString() + "\n";
            }
            System.out.println(cadena);
        }        
    }
    /**
     * Función que solicita modificar los valores (Cod. Barras, Cantidad) 
     * de un producto pidiendo el nombre del mismo.
     * 
     */
    public static void modificarProducto(){
        System.out.print("Indica el nombre del producto a modificar: ");
        try {
            String denominacion = entrada.readLine();
              if (archivo.CrearArchivoProductos()) {
                c = archivo.LeerArchivoProductos();
                for (int i = 0; i < c.size(); i++) {
                    if (c.get(i).getDenominación() !=null) { // Debo de poner el condicional pata evitar: Exception in thread "main" java.lang.NullPointerExceptionel 
                        if (c.get(i).getDenominación().equals(denominacion)) {
                            System.out.print("\tNuevo Cod. de Barras: ");
                                String codBarras = entrada.readLine();
                                    c.get(i).setCod_barra(codBarras);
                            System.out.print("\tNueva cantidad: ");
                                int cantidad = Integer.parseInt(entrada.readLine());
                                    c.get(i).setUnidades(cantidad);
                            //Guardamos los cambios pasando los set y la posición del producto dentro del archivo
                            //abría que validar que caundo los números imtroducidos pr teclado son nulos no nos dé el error java.lang.NumberFormatException: For input string: ""
                            archivo.ModificaArchivoProductos(c,i); // i es la posición que ocupa el producto en el arrayList
                        }
                    }
                }
              } 
        } catch (IOException e) {
            e.printStackTrace();
        }         
    }
    public static void eliminarProducto(){
        try {
            System.out.print("Indica el CÓDIFO DE BARRAS del producto a eliminar:");
            String codBarras = entrada.readLine();
            //comprobamos que existe el archivo para poder trabajar
            if (archivo.CrearArchivoProductos()) {
                //Leo lo que hay dentro del archivo y le asigno una variable
                c=archivo.LeerArchivoProductos();
                //Recorro todo el archivo
                for (int i = 0; i < c.size(); i++) {
                    Productos get = c.get(i);
                    if (get.getCod_barra().equals(codBarras)) {
                       // get.getDenominación();
                       c.remove(i);
                       archivo.EliminarProductoArchivo(c,i);

                    }  
                        //escribeFichero(get, 2);
                }
               /* for (int i = 0; i < c.size(); i++) {
                    Productos get = c.get(i);
                    System.out.println(((Object)get).getClass().getName());
                }*/
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void escribeFichero(Object objeto, int valor) {
        boolean abrir;

        if (valor == 1) { // Camareros
            // Primero creo el archivo.
            abrir = archivo.CrearArchivoCamareros();
            //Una vez creado el archivo, creo un objeto de la clase
            Camareros nuevo = new Camareros();
            // Casto el objeto, el objeto que pasamos por parámetro lo convierto al nuevo objeto creado 
            // objeto lo convierto a nuevo
            nuevo = (Camareros) objeto; //es necesario el casting
            // Como ya se ha creado el archivo, abrir será false y se podrá escribir o añadir en él
            //Creado el parámetro que recibe la función como objeto de la clase, éste se
            // lo paso a las funciones de escribir y añadir.
            if (abrir == false) {
                archivo.EscribirArchivoCamareros(nuevo);
            } else {
                archivo.AnadirArchivoCamareros(nuevo);
            }
        } else if (valor == 2){ // Productos
            abrir = archivo.CrearArchivoProductos();
            Productos nuevo = new Productos();
            nuevo = (Productos) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoProductos(nuevo);
            } else {
                archivo.AnadirArchivoProductos(nuevo);
            }
        } 
    }


        
    
    
          
} //end class Menu
