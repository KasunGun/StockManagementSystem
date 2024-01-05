/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package asc;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class ASCStockItemTest {

    public ASCStockItemTest() {
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
     * Test of getCode method, of class ASCStockItem.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        String expResult = "RUN1234567";
        String result = instance.getCode();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ASCStockItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        String expResult = "RunEverywhere";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ASCStockItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        String expResult = "Great trainers for running cross country,8850,50";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPricePounds method, of class ASCStockItem.
     */
    @Test
    public void testGetUnitPricePounds() {
        System.out.println("getUnitPricePounds");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        int expResult = 10;
        int result = instance.getUnitPricePounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPricePence method, of class ASCStockItem.
     */
    @Test
    public void testGetUnitPricePence() {
        System.out.println("getUnitPricePence");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        int expResult = 99;
        int result = instance.getUnitPricePence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantityInStock method, of class ASCStockItem.
     */
    @Test
    public void testGetQuantityInStock() {
        System.out.println("getQuantityInStock");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        int expResult = 10;
        int result = instance.getQuantityInStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuanity method, of class ASCStockItem.
     */
    @Test
    public void testSetQuanity() {
        System.out.println("setQuanity");
        int newQuantity = 0;
        ASCStockItem instance = new ASCStockItem();
        instance.setQuanity(newQuantity);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ASCStockItem.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        ASCStockItem instance = new ASCStockItem("RUN1234567", "RunEverywhere", "Great trainers for running cross country,8850,50", 10, 99, 10);
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of loadStock method, of class ASCStockItem.
     */
    @Ignore
    @Test
    public void testLoadStock() {
        System.out.println("loadStock");
        String stockType = "ASC_Stock";
        ASCStockItem instance = new ASCStockItem();
        List<ASCStockItem> expResult = null;
        List<ASCStockItem> result = instance.loadStock(stockType);

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStock method, of class ASCStockItem.
     */
    @Ignore
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        String stockType = "ASC_Stock";
        ArrayList stock = new ArrayList();
        ASCStockItem instance = new ASCStockItem();
        instance.updateStock(stockType, stock);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
