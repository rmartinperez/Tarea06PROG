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
/**
* Javier Abellán, 20 Marzo 2006
* Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
* al principio del Stream.
*/
//package chuidiang.ejemplos.objeto_fichero;
/**
* Javier Abellán, 20 Marzo 2006
* Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
* al principio del Stream.
*/
//package chuidiang.ejemplos.objeto_fichero;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
* Redefinición de la clase ObjectOuputStream para que no escriba una cabecera
* al inicio del Stream.
* @author Javier Abellán.
*
*/
public class MiObjectOutputStream extends ObjectOutputStream
{
    /** Constructor que recibe OutputStream */
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }
    /** Constructor sin parámetros */
    protected MiObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }
    /** Redefinición del método de escribir la cabecera para que no haga nada. */
    protected void writeStreamHeader() throws IOException
    {
    }
}
