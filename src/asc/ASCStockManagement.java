/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import newStock.NewItem;
import newStock.NewStockItem;
import newStock.NewStockItemFactory;
import notification.NotificationObserver;
import org.apache.commons.collections.ListUtils;
import sales.Sale;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class ASCStockManagement {

    private static List<ASCStockItem> aSCStock = new ArrayList<ASCStockItem>();
    private static List<NotificationObserver> observers = new ArrayList<NotificationObserver>();
    private static String notificationMessage = "";
    private static List<Sale> sales = new ArrayList<Sale>();
    Map<String, String> productCodeMap = new HashMap<String, String>() {
        {
            put("RUN", "1");
            put("SWM", "2");
            put("CYC", "3");
        }
    };

    public ASCStockManagement() {
    }

    public List<ASCStockItem> getaSCStock() {
        return aSCStock;
    }

    //set stock items to list
    public void setaSCStock(List<ASCStockItem> aSCStock) {
        this.aSCStock = aSCStock;
        notifyAllObservers();
    }

    //use to set all observers to observers list
    public void attach(NotificationObserver observer) {
        observers.add(observer);
    }

    //use for notify all observer list
    public void notifyAllObservers() {
        for (NotificationObserver observer : observers) {
            observer.setNotification();
        }
    }

    public static void setNotificationMessage(String notificationMessage) {
        ASCStockManagement.notificationMessage = notificationMessage;
    }

    public static String getNotificationMessage() {
        return notificationMessage;
    }

    public static void setSales(List<Sale> sales) {
        ASCStockManagement.sales = sales;
    }

    //load ASC and MSM stock list separately and combin it to single list 
    public void loadStockData() {
        try {
            ASCStockItem stockItem = new ASCStockItem();
            List<ASCStockItem> stockList = stockItem.loadStock("ASC_Stock");
            List<ASCStockItem> stockList2 = stockItem.loadStock("MSM_Stock");

            setaSCStock(ListUtils.union(stockList, stockList2));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //use to buy existing products
    public Boolean purchaseStock(String productCode, int quantity) {
        Boolean updateState = false;
        try {
            for (ASCStockItem aSCStockItem : aSCStock) {
                if (aSCStockItem.getCode().equals(productCode)) {
                    aSCStockItem.setQuanity(aSCStockItem.getQuantityInStock() + quantity);
                    updateState = true;
                }
            }
            setaSCStock(aSCStock);
        } catch (Exception e) {
            System.out.println(e);
        }

        return updateState;
    }

    //use to sell existing products
    public String sellStock(String productCode, int quantity) {
        Boolean updateState = false;
        String error = "";
        try {
            for (ASCStockItem aSCStockItem : aSCStock) {
                if (aSCStockItem.getCode().equals(productCode)) {
                    if (aSCStockItem.getQuantityInStock() >= quantity) {
                        aSCStockItem.setQuanity(aSCStockItem.getQuantityInStock() - quantity);
                        sales.add(new Sale(
                                new Date(),
                                aSCStockItem.getCode(),
                                quantity,
                                aSCStockItem.getUnitPricePounds(),
                                aSCStockItem.getUnitPricePence()
                        ));
                        updateState = true;
                    } else {
                        error = "Not Enough Quantiyt";
                    }

                } else {
                    if (error.isEmpty()) {
                        error = "Can not find product !";
                    }

                }
            }
            setaSCStock(aSCStock);
        } catch (Exception e) {
            System.out.println(e);
            error = "Error";
        }
        if (updateState) {
            error = "";
        }
        return error;
    }

    //save stock in csv
    public void saveStocks() {
        try {
            ArrayList<String[]> aSMStockList = new ArrayList<String[]>(),
                    mSMStockList = new ArrayList<String[]>();

            for (ASCStockItem stockItem : aSCStock) {

                String[] code = stockItem.getCode().split("-");

                if (code.length == 3 && code[2].equals("MSM")) {
                    mSMStockList.add(new String[]{
                        productCodeMap.get(code[0]),
                        code[1],
                        String.format("%-60s", stockItem.getName())
                        + stockItem.getDescription(),
                        stockItem.getUnitPricePounds()
                        + stockItem.getUnitPricePence() + "",
                        stockItem.getQuantityInStock() + ""
                    });
                } else {
                    aSMStockList.add(new String[]{
                        stockItem.getCode(),
                        stockItem.getName(),
                        stockItem.getDescription(),
                        stockItem.getUnitPricePounds() + "",
                        stockItem.getUnitPricePence() + "",
                        stockItem.getQuantityInStock() + ""
                    });
                }

            }

            ASCStockItem stockItem = new ASCStockItem();
            stockItem.updateStock("ASC_Stock", aSMStockList);
            stockItem.updateStock("MSM_Stock", mSMStockList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveSalesData() {
        new Sale().updateSales(sales);
    }

    //use to add new stock item
    public void addStockItem(NewItem newItem) {
        NewStockItemFactory newStockItemFactory = new NewStockItemFactory();

        if (newItem.getStore().equals("ASC_Stock")) {
            //add ASC stock item using using stock item factory
            NewStockItem aSCNewStockItem = newStockItemFactory.getNewStockItem("ASC_Stock", newItem);
            aSCNewStockItem.addItem();
        } else if (newItem.getStore().equals("MSM_Stock")) {
            //add MSM stock item using using stock item factory
            NewStockItem mSMNewStockItem = newStockItemFactory.getNewStockItem("MSM_Stock", newItem);
            mSMNewStockItem.addItem();
        }
    }
}
