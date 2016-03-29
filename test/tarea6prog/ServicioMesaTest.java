/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6prog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rmartin
 */
public class ServicioMesaTest {
    
    public ServicioMesaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumeroMesa method, of class ServicioMesa.
     */
    @Test
    public void testGetNumeroMesa() {
        System.out.println("getNumeroMesa");
        ServicioMesa instance = new ServicioMesa();
        int expResult = 0;
        int result = instance.getNumeroMesa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroMesa method, of class ServicioMesa.
     */
    @Test
    public void testSetNumeroMesa() {
        System.out.println("setNumeroMesa");
        int numeroMesa = 0;
        ServicioMesa instance = new ServicioMesa();
        instance.setNumeroMesa(numeroMesa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNif method, of class ServicioMesa.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        ServicioMesa instance = new ServicioMesa();
        String expResult = "";
        String result = instance.getNif();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNif method, of class ServicioMesa.
     */
    @Test
    public void testSetNif() {
        System.out.println("setNif");
        String nif = "";
        ServicioMesa instance = new ServicioMesa();
        instance.setNif(nif);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ServicioMesa.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        ServicioMesa instance = new ServicioMesa();
        String expResult = "";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class ServicioMesa.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "";
        ServicioMesa instance = new ServicioMesa();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroServicio method, of class ServicioMesa.
     */
    @Test
    public void testGetNumeroServicio() {
        System.out.println("getNumeroServicio");
        ServicioMesa instance = new ServicioMesa();
        int expResult = 0;
        int result = instance.getNumeroServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroServicio method, of class ServicioMesa.
     */
    @Test
    public void testSetNumeroServicio() {
        System.out.println("setNumeroServicio");
        int numeroServicio = 0;
        ServicioMesa instance = new ServicioMesa();
        instance.setNumeroServicio(numeroServicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAbierta method, of class ServicioMesa.
     */
    @Test
    public void testIsAbierta() {
        System.out.println("isAbierta");
        ServicioMesa instance = new ServicioMesa();
        boolean expResult = false;
        boolean result = instance.isAbierta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAbierta method, of class ServicioMesa.
     */
    @Test
    public void testSetAbierta() {
        System.out.println("setAbierta");
        boolean abierta = false;
        ServicioMesa instance = new ServicioMesa();
        instance.setAbierta(abierta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ServicioMesa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ServicioMesa instance = new ServicioMesa();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
