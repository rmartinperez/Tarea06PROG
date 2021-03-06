/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog_ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public static Camareros camarero = new Camareros();
    public static Productos producto = new Productos();
    public static ServicioMesa servicioMesa = new ServicioMesa();
    public static ConsumicionMesa consumicion = new ConsumicionMesa();
    public static Archivo_Objetos archivo = new Archivo_Objetos();
    public static ArrayList<Productos> c = new ArrayList<Productos>();
    public static ArrayList<ServicioMesa> c1 = new ArrayList<ServicioMesa>();

    public static void main(String[] args) {
        int opcionElegida = 1;
                //Bucle principal que controla la ejecución del programa. 
        //Se trata de un bucle do-while que ejecuta mientras la opción 
        //introducida sea distinta a 10.
        do {
            if (opcionElegida < 1 || opcionElegida > 10)
                System.err.println("Introduzca únicamente un valor entre 1 y 10");
            try {
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

                System.out.println("Selecciona una opción del menú");
                
                opcionElegida = Integer.parseInt(entrada.readLine());

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
                        int opcion2 = 0;
                        do {
                            try {
                                System.out.println("\t Menú de opciones");
                                System.out.println("\t\t 1. Listar Productos.");
                                System.out.println("\t\t 2. Modificar producto dado el nombre.");
                                System.out.println("\t\t 3. Eliminar producto");
                                System.out.println("\t\t 4. Salir del menú");
                                System.out.print("\t Introduce la opción deseada (1-4): ___");
                                opcion2 = Integer.parseInt(entrada.readLine());
                                switch (opcion2) {
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
                            } catch (NumberFormatException nfe) {
                                System.err.println("Sólo son válidos valores enteros entre 1 y 4");
                            } catch (IOException ioe) {
                                System.err.println("Error de entrada de datos: " + ioe.getMessage());
                            }
                        } while (opcion2 != 4);
                        break;
                    case 5: //Abrir Servicio Mesa
                        abrirServicioMesa();
                        listarServicios();
                        break;
                    case 6: //Consumición Mesa
                        //consumicionMesa();
                        listarConsumiciones();
                        break;
                    case 7: //Total Cuenta de Mesa
                        totalCuenta();
                        break;
                    case 8: //Listado de los servicios de una mesa por fechas
                        listarServicioMesaxFecha();
                        break;
                    case 9: //Listado de los servicios que ha hecho un camarero
                        listarServiciosCamarero();
                        break;
                    case 10: //Salir
                        break;
                    default:
                }// end. switch
            } catch (NumberFormatException e) {
                System.err.println("Debes de introducir un número");
                
            } catch (IOException e) {
                System.err.println("Error de entrada de datos: " + e.getMessage());
            }

        } while (opcionElegida != 10);

    } //end void main

    /**
     * ***************************************************************************
     * CAMAREROS
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

    /**
     * ***************************************************************************
     * PRODUCTOS
     * ****************************************************************************
     */
    public static void entradaProductos() {
        int bandera = 0;
        char respuesta = 0;
        float precio = 0F;
        String codBarras = "";
        int cantidad = 0;
        try {
            System.out.print("Introduce un código de barras: ");
            codBarras = entrada.readLine();
            if (codBarras != "") {
                producto.setCod_barra(codBarras);
                bandera = 0;
            } else {
                bandera = 1;
            }
            System.out.print("Introduce el nombre de un producto: ");
            String nombre = entrada.readLine();
            if (nombre != "") {
                producto.setDenominación(nombre);
                bandera = 0;
            } else {
                bandera = 2;
            }
            System.out.print("Introduce el precio: ");
            precio = Float.parseFloat(entrada.readLine());
            if (nombre != "") {
                producto.setPvp(precio);
                bandera = 0;
            } else {
                bandera = 2;
            }
            System.out.print("Introduce la cantidad: ");
            cantidad = Integer.parseInt(entrada.readLine());
            if (nombre != "") {
                producto.setUnidades(cantidad);
                bandera = 0;
            } else {
                bandera = 2;
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
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
            switch (bandera) {
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

    public static void listarProductos() {
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
     * Función que solicita modificar los valores (Cod. Barras, Cantidad) de un
     * producto pidiendo el nombre del mismo.
     *
     */
    public static void modificarProducto() {
        System.out.print("Indica el nombre del producto a modificar: ");
        try {
            String denominacion = entrada.readLine();
            if (archivo.CrearArchivoProductos()) {
                c = archivo.LeerArchivoProductos();
                for (int i = 0; i < c.size(); i++) {
                    if (c.get(i).getDenominación() != null) { // Debo de poner el condicional pata evitar: Exception in thread "main" java.lang.NullPointerExceptionel 
                        if (c.get(i).getDenominación().equals(denominacion)) {
                            System.out.print("\tNuevo Cod. de Barras: ");
                            String codBarras = entrada.readLine();
                            c.get(i).setCod_barra(codBarras);
                            System.out.print("\tNueva cantidad: ");
                            int cantidad = Integer.parseInt(entrada.readLine());
                            c.get(i).setUnidades(cantidad);
                            //Guardamos los cambios pasando los set y la posición del producto dentro del archivo
                            //abría que validar que caundo los números imtroducidos pr teclado son nulos no nos dé el error java.lang.NumberFormatException: For input string: ""
                            archivo.ModificaArchivoProductos(c, i); // i es la posición que ocupa el producto en el arrayList
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarProducto() {
        try {
            System.out.print("Indica el CÓDIFO DE BARRAS del producto a eliminar:");
            String codBarras = entrada.readLine();
            //comprobamos que existe el archivo para poder trabajar
            if (archivo.CrearArchivoProductos()) {
                //Leo lo que hay dentro del archivo y le asigno una variable
                c = archivo.LeerArchivoProductos();
                //Recorro todo el archivo
                for (int i = 0; i < c.size(); i++) {
                    Productos get = c.get(i);
                    if (get.getCod_barra().equals(codBarras)) {
                        // get.getDenominación();
                        c.remove(i);
                        archivo.EliminarProductoArchivo(c, i);

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

    /**
     * ***************************************************************************
     * SERVICIO MESA
     * ****************************************************************************
     */
    public static void abrirServicioMesa() {
        int bandera = 0;
        String respuesta = "";
        char respuesta2 = 0;
        int numMesa = 0;
        boolean noCamarero, mesaAbierta;
        boolean repetir = false;
        try {
            do { // Buble para solicitar un nuevo servicio
                System.err.print("QUIERES AÑADIR UN NUEVO SERVICIO");
                respuesta = entrada.readLine().toUpperCase();
                repetir = false;
                if (respuesta.equals("S")) {
                    repetir=true;
                    try {
                        do {
                            System.out.print("Introduce el nº de mesa (1/12): ");
                            numMesa = Integer.parseInt(entrada.readLine());
                            mesaAbierta = true;
                //Ahora tengo que consultar si la mesa introducida aún está abierta o no
                            //Creo una función que me devuelva el estado de la mesa, si es true, 
                            // no puedo abrir el servicio en ella 
                            mesaAbierta = comprobarEstadoMesa(numMesa);
                            if (mesaAbierta) {
                                System.err.println("La mesa está abierta ");
                            }
                            if (numMesa < 0 || numMesa > 12) {
                                System.err.println("Debes de introducir un nº de mesa correcto(1/12)");
                            }
                            servicioMesa.setNumeroMesa(numMesa);
                        } while ((mesaAbierta) || ((numMesa <= 0) || (numMesa > 12)));

                        System.out.print("Introduce el NIF del camarero: ");
                        String nif = entrada.readLine();
                        if (nif != "") {
                            //Comprobamos que existe el camarero insertado
                            noCamarero = comprobarCamarero(nif);
                            if (!noCamarero) {
                                bandera = 2;
                            } else {
                                servicioMesa.setNif(nif);
                            }
                        } else {
                            bandera = 2;
                        }
                        //La fecha la automatizo
                        servicioMesa.getFecha();
            //El nº de servicio auto-autoinccrementa
                        // debería leer el último servicio realizado y sumarle uno, para ello debo leer
                        // el archivo y obtener el valor del getNumeroServicio del último registro ingresado
                        // de momento creo lo siguiente
                        servicioMesa.getNumeroServicio();
                        int contador = 0;
                        if (servicioMesa.getNumeroServicio() == 0) {
                            contador = contador + 1;
                            servicioMesa.setNumeroServicio(contador);
                            //System.out.println(" "+ contador);
                        } else {
                            contador = servicioMesa.getNumeroServicio() + 1;
                            servicioMesa.setNumeroServicio(contador);
                            //System.out.println(" "+ contador);
                        }
                        // Al abrir el servicio, el estado de la mesa será true
                        servicioMesa.setAbierta(true);
                        // Paso a las validaciones de la entrada de datos
                        if (bandera == 0) {
                            System.out.println("Grabar los Datos :");
                            try {

                                respuesta2 = entrada.readLine().charAt(0); //Siempre que se quiera separar una cadena de texto a carácteres o sacar un simple carácter de una cadena, para ello se utiliza el método charAt(). 
                                if (respuesta2 == 's' || respuesta2 == 'S') {
                                    escribeFichero(servicioMesa, 3);
                                }
                            } catch (IOException e) { //Las señales que se ha producido una excepción de E / S de algún tipo. Esta clase es la clase general de excepciones producidas por las operaciones fallidas o interrumpidas de E / S.
                                e.printStackTrace();
                            }
                        } else {
                            switch (bandera) {
                                case 1:
                                    System.out.println("Debes de introducir un nº de mesa");
                                    break;
                                case 2:
                                    System.out.println("Debes de introducir un NIF");
                                    break;
                                default:
                                    break;
                            }
                        }

                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                 } //end. if (respuesta.equals("S"))
            } while (repetir);

        } catch (IOException e) {
            System.err.println("Error de entrada de datos: " + e.getMessage());
        }

    }

    public static void listarServicios() {
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
    }

    public static boolean comprobarEstadoMesa(int numMesa) {
        boolean estado = false;
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoServicioMesa()) {
            c = archivo.LeerArchivoServicioMesa();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNumeroMesa() == numMesa) {
                    estado = c.get(i).isAbierta();
                }
            }
        }
        return estado;
    }

    public static boolean comprobarCamarero(String nif) {
        boolean nifCanarero = false;
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNIF().equals(nif)) {
                    nifCanarero = true;
                }
            }
        }
        return nifCanarero;
    }

    /**
     * ***************************************************************************
     * CONSUMICIÓN MESA
     * ****************************************************************************
     */
    public static void consumicionMesa() {
        int bandera = 0;
        char respuesta = 0;
        int numMesa = 0;
        boolean mesaAbierta, cod;
        float precioProducto = 0F;
        float importe = 0F;
        int cantidad = 0;
        try {
            // Introducimos la cantidad de producto
            System.out.print("Introduce la cantidad: ");
            cantidad = Integer.parseInt(entrada.readLine());
            if (cantidad != 0) {
                consumicion.setUnidades(cantidad);
                bandera = 0;
            } else {
                bandera = 2;
            }
            // Solicitamos el cod. barras del producto
            do {
                cod = false;
                System.out.print("Introduce el cod de barras de un producto: ");
                String codBarras = entrada.readLine();
                if (codBarras != "") {
                    if (!comprobarProducto(codBarras)) {
                        System.err.println("No existe el producto");
                    }
                    cod = comprobarProducto(codBarras);
                    consumicion.setCod_barra(codBarras);
                    // Obtenemos el impote total, que será la cantidad que se ha introducido anteriormente 
                    // por el importe del precio del producto
                    precioProducto = obtenerPrecioProducto(codBarras);
                    importe = cantidad * precioProducto;
                    System.err.println("precioProducto: " + precioProducto);
                    System.err.println("cantidad: " + cantidad);
                    System.err.println("importe: " + importe);
                    consumicion.setTotal(importe);

                } else {
                    bandera = 1;
                }

            } while (!cod);
            // Solicitamos el nº de mesa
            do {
                System.out.print("Introduce el nº de mesa (1/12): ");
                numMesa = Integer.parseInt(entrada.readLine());
                mesaAbierta = true;
                //Ahora tengo que consultar si la mesa introducida aún está abierta o no
                //Creo una función que me devuelva el estado de la mesa, si es true, 
                // no puedo abrir el servicio en ella 
                mesaAbierta = comprobarEstadoMesa(numMesa);
                if (!mesaAbierta) {
                    System.err.println("La mesa está cerrada ");
                }
                if (numMesa < 0 || numMesa > 12) {
                    System.err.println("Debes de introducir un nº de mesa correcto(1/12)");
                }
                consumicion.setNumeroServicio(numMesa);
            } while ((!mesaAbierta) || ((numMesa <= 0) || (numMesa > 12)));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //Validaciones de entrada por teclado
        if (bandera == 0) {
            //Indicamos si se quiere gravar los datos
            System.out.println("Grabar los Datos :");
            try {

                respuesta = entrada.readLine().charAt(0); //Siempre que se quiera separar una cadena de texto a carácteres o sacar un simple carácter de una cadena, para ello se utiliza el método charAt(). 
                if (respuesta == 's' || respuesta == 'S') {
                    escribeFichero(consumicion, 4);
                }
            } catch (IOException e) { //Las señales que se ha producido una excepción de E / S de algún tipo. Esta clase es la clase general de excepciones producidas por las operaciones fallidas o interrumpidas de E / S.
                e.printStackTrace();
            }
        } else {
            switch (bandera) {
                case 1:
                    System.out.println("Debes de introducir un código de barras");
                    break;
                case 2:
                    System.out.println("Debes de introducir una cantidad");
                    break;
                default:
                    break;
            }
        }
    }

    public static float obtenerPrecioProducto(String codProducto) {
        float precio = 0F;
        ArrayList<Productos> c = new ArrayList<Productos>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoProductos()) {
            c = archivo.LeerArchivoProductos();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getCod_barra().toString().equals(codProducto)) {
                    precio = c.get(i).getPvp();
                }
            }
        }
        return precio;
    }

    public static boolean comprobarProducto(String codProducto) {
        boolean cod = false;
        ArrayList<Productos> c = new ArrayList<Productos>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoProductos()) {
            c = archivo.LeerArchivoProductos();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getCod_barra().equals(codProducto)) {
                    cod = true;
                }
            }
        }
        return cod;
    }

    public static void listarConsumiciones() {
        ArrayList<ConsumicionMesa> c = new ArrayList<ConsumicionMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoConsumicionMesa()) {
            c = archivo.LeerArchivoConsumicionMesa();
            for (int i = 0; i < c.size(); i++) {
                cadena = cadena + c.get(i).toString() + "\n";
            }
            System.out.println(cadena);
        }
    }

    /**
     * ***************************************************************************
     * TOTAL CUENTA
     * ****************************************************************************
     */
    public static void totalCuenta() {
        try {
            System.out.print("Dame la mesa: ");
            int numMesa = Integer.parseInt(entrada.readLine());
            if (comprobarEstadoMesa(numMesa)) {
                System.err.println("La mesa está abierta");
            }
            obtenerTotalConsumiciones(numMesa);

            System.err.println("Total: " + obtenerTotalConsumiciones(numMesa));
            if (!modificarEstadoMesa(numMesa)) {
                System.err.println("La mesa está cerrado");
            }

        } catch (IOException e) { //Las señales que se ha producido una excepción de E / S de algún tipo. Esta clase es la clase general de excepciones producidas por las operaciones fallidas o interrumpidas de E / S.
            e.printStackTrace();
        }
    }

    public static float obtenerTotalConsumiciones(int numMesa) {
        float total = 0F;
        ArrayList<ConsumicionMesa> c = new ArrayList<ConsumicionMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        String cadena = "";
        if (archivo.CrearArchivoConsumicionMesa()) {
            c = archivo.LeerArchivoConsumicionMesa();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNumeroServicio() == numMesa) {
                    total = total + c.get(i).getTotal();
                }
            }
        }
        return total;
    }

    public static boolean modificarEstadoMesa(int numMesa) {
        boolean estado = true;
        if (archivo.CrearArchivoServicioMesa()) {
            c1 = archivo.LeerArchivoServicioMesa();
            for (int i = 0; i < c1.size(); i++) {
                if (c1.get(i).getNumeroMesa() != 0) { // Debo de poner el condicional pata evitar: Exception in thread "main" java.lang.NullPointerExceptionel 
                    if (c1.get(i).getNumeroMesa() == numMesa) {
                        c1.get(i).setAbierta(false);
                        //Guardamos los cambios pasando los set y la posición del producto dentro del archivo
                        //abría que validar que caundo los números imtroducidos pr teclado son nulos no nos dé el error java.lang.NumberFormatException: For input string: ""
                        archivo.ModificaArchivoServicioMesa(c1, i); // i es la posición que ocupa el producto en el arrayList
                        estado = false;
                    }
                }
            }
        }
        return estado;
    }

    /**
     * ***************************************************************************
     * LISTADO DE SERVICIOS DE UNA MESA POR FECHAS
     * ****************************************************************************
     */
    public static void listarServicioMesaxFecha() {
        Archivo_Objetos archivo = new Archivo_Objetos();
        int cadena = 0;
        int numMesa = 0;
        String fechaIni = "";
        String fechaFin = "";
        int bandera = 0;
        boolean noMesa = false;
        boolean noFecha = false;
        do {
            /* Solicitamos la mesa */
            System.out.print("Introduce el número de mesa: ");
            try {
                cadena = Integer.parseInt(entrada.readLine());
                if ((cadena > 0) && (cadena <= 12)) {
                    numMesa = cadena;
                    do {
                        /* Solicitamos la fecha inicial */
                        System.out.print("Introduce la fecha inicial (dd/mm/aaaa): ");
                        fechaIni = entrada.readLine();
                        /* Solicitamos la fecha FINAL */
                        System.out.print("Introduce la fecha final (dd/mm/aaaa): ");
                        fechaFin = entrada.readLine();
                        //Indicamos el formato para la fecha
                        DateFormat formatoDelTexto = DateFormat.getDateInstance(DateFormat.SHORT);
                        try {
                            if ((fechaIni != "") && (fechaFin != "")) {
                                //System.out.println("Estoy aqyí");
                                Date date1 = formatoDelTexto.parse(fechaIni);
                                Date date2 = formatoDelTexto.parse(fechaFin);
                                ObtenerServiciosDeMesas(numMesa, date1, date2);
                                noMesa = true;
                                noFecha = true;
                            }
                        } catch (ParseException pe) {
                            System.err.println("Formato de fechas no válido");
                            noFecha = false;
                            noMesa = true;
                        } catch (Exception e) {
                            System.err.println("El formato de fecha no es correcto");
                        }
                    } while (!noFecha);
                } else {
                    System.err.println("Introduce un número entre el 1 y 12");
                    noMesa = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!noMesa);
    }  //end listarServicioMesaxFecha()    

    public static void ObtenerServiciosDeMesas(int NumMesa, Date fechaIni, Date fechaFin) {
        int totalServicios = 0;
        boolean noHay = false;
        /**
         * Obtenemos la fecha del sistema y la convertirmos al String con el
         * formato en el que vamos a trabajar
         */
        DateFormat formatoDelTexto = DateFormat.getDateInstance(DateFormat.SHORT);
        ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        ServicioMesa servicioMesa = new ServicioMesa();
        if (archivo.CrearArchivoServicioMesa()) {
            c = archivo.LeerArchivoServicioMesa();
            for (int i = 0; i < c.size(); i++) {
                Date date1;
                try {
                    date1 = formatoDelTexto.parse(c.get(i).getFecha());
                    if ((c.get(i).getNumeroMesa() == NumMesa && fechaIni.before(date1) && fechaFin.after(date1))) {
                        totalServicios++;
                        System.out.println("Total de los servicios de la mesa nº " + NumMesa + ": " + totalServicios);
                        noHay = true;
                    } else if ((c.get(i).getNumeroMesa() == NumMesa && fechaIni.equals(date1) && fechaFin.equals(date1))) {
                        totalServicios++;
                        System.out.println("Total de los servicios de la mesa nº " + NumMesa + ": " + totalServicios);
                        noHay = true;
                    } else {
                        noHay = false;
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
            if (!noHay) {
                System.err.println("No hay servicios para la mesa nº " + NumMesa + " entre las fechas indicadas");
            }

        }
    }

    /**
     * ***************************************************************************
     * LISTADO DE SERVICIOS QUE HA HECHO UN CAMARERO
     * ****************************************************************************
     */
    public static void listarServiciosCamarero() {
        boolean noCamarero;
        String nif = "";
        String fecha = "";
        int numServicios = 0;
        try {

            do {
                /* Solicitamos la mesa */
                System.out.print("Introduce el nif de un camarero: ");
                nif = entrada.readLine();
                noCamarero = comprobarCamarerosDNI(nif);
                if (!noCamarero) {
                    System.err.println("No existe el camarero");
                }
                System.out.print("Introduce una fecha: ");
                fecha = entrada.readLine();
                numServicios = listarServiciosCamarero(nif, fecha);
                System.out.println("El camarero " + nif + " ha realizado " + numServicios + " servicios el día " + fecha);
            } while (!noCamarero);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean comprobarCamarerosDNI(String nif) {
        boolean noCamarero = false;
        ArrayList<Camareros> c = new ArrayList<Camareros>();
        Archivo_Objetos archivo = new Archivo_Objetos();
        Camareros camarero = new Camareros();
        if (archivo.CrearArchivoCamareros()) {
            c = archivo.LeerArchivoCamareros();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getNIF().equals(nif)) {
                    c.get(i).toString();
                    noCamarero = true;
                }
            }
        }
        return noCamarero;
    }

    public static int listarServiciosCamarero(String nif, String fecha1) {
        String fecha2;
        int contador = 0;
        try {
            /**
             * Obtenemos la fecha del sistema y la convertirmos al String con el
             * formato en el que vamos a trabajar
             */
            DateFormat formatoDelTexto = DateFormat.getDateInstance(DateFormat.SHORT);
            Date date1 = formatoDelTexto.parse(fecha1);
            ArrayList<ServicioMesa> c = new ArrayList<ServicioMesa>();
            Archivo_Objetos archivo = new Archivo_Objetos();

            if (archivo.CrearArchivoServicioMesa()) {
                c = archivo.LeerArchivoServicioMesa();
                for (int i = 0; i < c.size(); i++) {
                    fecha2 = c.get(i).getFecha().toString();
                    Date date2 = formatoDelTexto.parse(fecha2);
                    if ((c.get(i).getNif().equals(nif)) && (date2.equals(date1))) {
                        contador++;
                    }
                }
            }
        } catch (ParseException pe) {
            System.err.println("Formato de fechas no válido");
        }
        return contador;
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
        } else if (valor == 2) { // Productos
            abrir = archivo.CrearArchivoProductos();
            Productos nuevo = new Productos();
            nuevo = (Productos) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoProductos(nuevo);
            } else {
                archivo.AnadirArchivoProductos(nuevo);
            }
        } else if (valor == 3) { // ServicioMesa
            abrir = archivo.CrearArchivoServicioMesa();
            ServicioMesa nuevo = new ServicioMesa();
            nuevo = (ServicioMesa) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoServicioMesa(nuevo);
            } else {
                archivo.AnadirArchivoServicioMesa(nuevo);
            }
        } else if (valor == 4) { // ConsumicionMesa
            abrir = archivo.CrearArchivoConsumicionMesa();
            ConsumicionMesa nuevo = new ConsumicionMesa();
            nuevo = (ConsumicionMesa) objeto;
            if (abrir == false) {
                archivo.EscribirArchivoConsumicionMesa(nuevo);
            } else {
                archivo.AnadirArchivoConsumicionMesa(nuevo);
            }
        }
    }
} //end class Menu
