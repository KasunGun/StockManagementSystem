/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package notification;

import asc.ASCStockManagement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class AScNotificationObserverTest {

    public AScNotificationObserverTest() {
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
     * Test of setNotification method, of class AScNotificationObserver.
     */
    @Test
    public void testSetNotification() {
        System.out.println("setNotification");
        ASCStockManagement stock = new ASCStockManagement();
        stock.loadStockData();
        AScNotificationObserver instance = new AScNotificationObserver(stock);
        instance.setNotification();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
