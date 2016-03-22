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

    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    static Camareros camarero = null;
    static Productos producto = new Productos();
    static ServicioMesa servMesa = new ServicioMesa();

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
                    //listarCamareros();
                    break;
                case 2: //Consultar Camareros
                    listarCamareros();
                    listarCamarerosDNI(consultarnombre(2));
                    break;
                case 3: //Entrada Productos
                    entradaProducto();
                    listarProductos();
                    break;
                case 4: //Consultar Productos
                    listarProductos();
                    listarProductosCodBarras(consultarnombre(1));                    
                    break;
                case 5: //Abrir Servicio Mesa
                    entradaServivioMesa();
                    
                    break;
                case 6: //Consumición Mesa
                    listarServicioMesa();
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
                bandera = 2;
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
    public static Camareros listarCamarerosDNI(String cadena) {
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        Camareros camarero = new Camareros();
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNIF().equals(cadena)) {
                    System.out.println(c.get(i).toString());
                }
            }
        }
        return camarero;
    }
    private static void listarCamareros() {

        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        //Camareros camarero = new Camareros();
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                cadena = cadena + c.get(i).toString() + "\n";
            }
            System.out.println(cadena);
        }
    }
    /**
     * ****************************************************************************
     *                              Productos 
     * ****************************************************************************
     */
    public static void entradaProducto() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        char respuesta = 0;
        int bandera = 0;
        /* Solicitamos el nombre */
        System.out.print("Denominación: ");

        try {
            cadena = entrada.readLine();
            if (cadena.length() > 0) {
                producto.setDenominación(cadena);
            } else {
                bandera = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        /* Solicitamos el Código de Barra */
        System.out.print("Código de Barra: ");

        try {
            cadena = (entrada.readLine());
            if (cadena.length() > 0) {
                producto.setCod_barra(cadena);
            } else {
                bandera = 2;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        /* Solicitamos el Precio */
        System.out.print("Precio: ");

        try {
            cadena = (entrada.readLine());
            if (cadena.length() > 0) {
                // mediante Float.valueOf() convertimos String cadena a Float
                producto.setPvp(Float.valueOf(cadena));
            } else {
                bandera = 3;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        /* Solicitamos las unidades */
        System.out.print("Unidades: ");

        try {
            cadena = (entrada.readLine());
            if (cadena.length() > 0) {
                producto.setUnidades(Integer.parseInt(cadena));
            } else {
                bandera = 4;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bandera == 0) {
            System.out.println("Grabar los Datos :");
            try {
                respuesta = entrada.readLine().charAt(0);
                if (respuesta == 's' || respuesta == 'S') {
                    // Le paso valor 2 para indicarle que estoy creando un producto
                    escribeFichero(producto, 3);
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
                    System.out.println("Entradas incorrecta del Código de Barra");
                    break;
                case 3:
                    System.out.println("Entradas incorrecta del Precio");
                    break;
                case 4:
                    System.out.println("Entradas incorrecta del Unidades");
                    break;
            }
        }// end.if(bandera==0)
    }// end.entradaProducto()
    private static void listarProductos() {

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
    }  //end listarProductos() 
    public static Productos listarProductosCodBarras(String cadena) {
        ArrayList<Productos> c = new ArrayList<Productos>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        Productos producto = new Productos();
        if (archivo.CrearArchivoProductos()) {
            c = archivo.LeerArchivoProductos();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getCod_barra().equals(cadena)) {
                    System.out.println(c.get(i).toString());
                }
            }
        }
        return producto;
    }  
     /* ****************************************************************************
     *                              Servicio en mesa
     * ****************************************************************************
     */
    public static void entradaServivioMesa() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String nifCamarero="";
        int cadena = 0;
        char respuesta = 0;
        int bandera = 0;
        servMesa = new ServicioMesa();
/* Solicitamos el nombre */
        System.out.print("Introduce el número de servicio: ");

        try {
            cadena = Integer.parseInt(entrada.readLine());
            if (cadena > 0) {
                servMesa.setNumeroServicio(cadena);                
            } else {
                bandera = 1;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
/* Solicitamos el número de mesa */
        System.out.print("Introduce el número de mesa (1/12): ");

        try {
            //PASAR UN STRING A UN INT (DE CADENA A ENTERO)
            cadena = Integer.parseInt(entrada.readLine());
            if ((cadena > 0) && (cadena <= 12)) {
                //buscarServivioMesaNumeroServicio(cadena);
                if (buscarUltimoServicioMesaNumero(cadena)>0) {
                    System.out.println("Debes de dar de baja la mesa " + cadena + " en el servcio número: " + buscarUltimoServicioMesaNumero(cadena));
                         bandera = 3;
                } else {
                    servMesa.setNumeroMesa(cadena);
                    servMesa.setAbierta(true);
                }
              

            } else {
                bandera = 2;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
/* La fecha no hace falta solicitarla, se inserta automáticamente con el método getFecha() */
        // System.out.println("Fecha de alta: ");

        if (cadena > 0) {
            servMesa.getFecha();
        } 
/* Solicitamos el NIF camarero */
        System.out.print("Introduce el NIF del camarero: ");

        try {
            
            nifCamarero = entrada.readLine();
            if (nifCamarero != "") {
                //buscarServivioMesaNumeroServicio(cadena);
                if (comprobarCamarerosDNI(nifCamarero) != "") {
                     servMesa.setNif(nifCamarero);
                } else {
                    bandera = 4;
                }
             } else {
                bandera = 4;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }       
     
        if (bandera == 0) {
            System.out.println("Grabar los Datos :");
            try {
                respuesta = entrada.readLine().charAt(0);
                if (respuesta == 's' || respuesta == 'S') {
                    escribeFichero(servMesa, 2);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            switch (bandera) {
                case 1:
                    System.out.println("Entradas incorrecta del número de servicio");
                    break;
                case 2:
                    System.out.println("Entradas incorrecta del número de mesa");
                    break;
                case 3:
                    System.out.println("La mesa aún está activa");
                    break;
                case 4:
                    System.out.println("No existe el camarero");
                    break;
                case 5:
                    System.out.println("Entradas incorrecta del Fecha de Alta");
                    break;
            }
        }// end.if(bandera==0)
    }  
    private static void listarServicioMesa() {

        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoServicioMesa()) {
            c = archivo.LeerArchivoServicioMesa();
            for (int i = 0; i < c.size(); i++) {
                cadena = cadena + c.get(i).toString() + "\n";
            }
            System.out.println(cadena);
        }
    }  //end listarServicioMesa()
    public static int buscarUltimoServicioMesaNumero(int numMesa) {
        int bandera = 0;
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        ServicioMesa servicio = new ServicioMesa();
        if (archivo.CrearArchivoServicioMesa()) {
            c = archivo.LeerArchivoServicioMesa();
            int contador = 0;
            for (int i = 0; i < c.size(); i++) {
                if ((c.get(i).getNumeroMesa() == numMesa) && (c.get(i).isAbierta()==true)){
                        bandera=c.get(i).getNumeroServicio();
                 }
            }

            //System.out.println("contador: " + bandera );
           
        }        
        return bandera;        
    }
            public static String comprobarCamarerosDNI(String cadena) {
        String nifCamarero = "";
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        Camareros camarero = new Camareros();
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNIF().equals(cadena)) {
                    //System.out.println(c.get(i).toString());
                    nifCamarero = c.get(i).getNIF();
                }
            }
        }
        return nifCamarero;
    }
    
    /**
     * ****************************************************************************
     *                              Funciones comunes 
     * ****************************************************************************
     */
    public static void escribeFichero(Object objeto, int valor){
        
        boolean abrir;
        
        Archivo_Objetos archivo = new Archivo_Objetos();

        if (valor == 1) {
            abrir = archivo.CrearArchivoCamareros();
            Camareros nuevo = new Camareros();
            nuevo = (Camareros) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoCamareros(nuevo);
            } else {
                archivo.AñadirArchivoCamareros(nuevo);
            }
        } else if (valor == 2){
            abrir = archivo.CrearArchivoServicioMesa();
            ServicioMesa nuevo = new ServicioMesa();
            nuevo = (ServicioMesa) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoServicioMesa(nuevo);
            } else {
                archivo.AñadirArchivoServicioMesa(nuevo);
            }
        } else {
            abrir = archivo.CrearArchivoProductos();
            Productos nuevo = new Productos();
            nuevo = (Productos) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoProductos(nuevo);
            } else {
                archivo.AñadirArchivoProductos(nuevo);
            }
        }
    } //end escribeFichero()
    public static String consultarnombre(int v) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        String texto = "";
        texto = ((v > 1) ? "NIF :" : "Código de Barra");
        /*
        *
        * if(v>1)
        * texto="Nombre";
        * else
        * texto="Denominacion";
         */
        System.out.print(texto);
        try {
            cadena = entrada.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cadena;
    }

} //end class Menu
