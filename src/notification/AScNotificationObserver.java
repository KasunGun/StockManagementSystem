/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notification;

import asc.ASCStockItem;
import asc.ASCStockManagement;
import java.util.List;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class AScNotificationObserver extends NotificationObserver {

    public AScNotificationObserver(ASCStockManagement aSCStockManagement) {
        this.aSCStockManagement = aSCStockManagement;
        this.aSCStockManagement.attach(this);
    }

    @Override
    public void setNotification() {
        String message = "";
        ASCStockManagement stock = new ASCStockManagement();
        try {
            List<ASCStockItem> aSCStock = stock.getaSCStock();

            for (ASCStockItem aSCStockItem : aSCStock) {
                if (aSCStockItem.getQuantityInStock() < 5) {
                    message = message + aSCStockItem.getCode() + " Qantity Left : " + aSCStockItem.getQuantityInStock() + "\n";
                    System.out.println(message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        stock.setNotificationMessage(message);

    }

}
