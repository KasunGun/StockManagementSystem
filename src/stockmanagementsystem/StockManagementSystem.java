/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stockmanagementsystem;

import asc.ASCStockManagement;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import notification.AScNotificationObserver;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class StockManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ASCStockManagement aSCStockManagement = new ASCStockManagement();
            new AScNotificationObserver(aSCStockManagement);
            aSCStockManagement.loadStockData();
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
            mf.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    aSCStockManagement.saveStocks();
                    aSCStockManagement.saveSalesData();
                }

                @Override
                public void windowClosed(WindowEvent e) {
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                }

                @Override
                public void windowActivated(WindowEvent e) {
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
