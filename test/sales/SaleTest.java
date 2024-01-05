/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class SaleTest {

    public SaleTest() {
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
     * Test of getUnitPricePounds method, of class Sale.
     */
    @Test
    public void testGetUnitPricePounds() {
        System.out.println("getUnitPricePounds");
        Sale instance = new Sale(new Date(), "CYC1111111", 2, 42, 13);
        int expResult = 42;
        int result = instance.getUnitPricePounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPricePence method, of class Sale.
     */
    @Test
    public void testGetUnitPricePence() {
        System.out.println("getUnitPricePence");
        Sale instance = new Sale(new Date(), "CYC1111111", 2, 42, 13);
        int expResult = 13;
        int result = instance.getUnitPricePence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantitySold method, of class Sale.
     */
    @Test
    public void testGetQuantitySold() {
        System.out.println("getQuantitySold");
        Sale instance = new Sale(new Date(), "CYC1111111", 2, 42, 13);
        int expResult = 2;
        int result = instance.getQuantitySold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductCode method, of class Sale.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        Sale instance = new Sale(new Date(), "CYC1111111", 2, 42, 13);
        String expResult = "CYC1111111";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateAndTime method, of class Sale.
     */
    @Test
    public void testGetDateAndTime() {
        System.out.println("getDateAndTime");
        Sale instance = new Sale(new Date(), "CYC1111111", 2, 42, 13);
        Date expResult = new Date();
        Date result = instance.getDateAndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSales method, of class Sale.
     */
    @Test
    public void testUpdateSales() {
        System.out.println("updateSales");
        List<Sale> sales = new ArrayList<Sale>();
        sales.add(new Sale(new Date(), "CYC1111111", 2, 42, 13));
        Sale instance = new Sale();
        instance.updateSales(sales);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
