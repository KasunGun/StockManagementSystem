/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asc;

import com.opencsv.CSVWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mengda.AdvancedStockItemInterface;
import mengda.MSMStockItem;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class StockAdapter implements StockItemInterface {

    AdvancedStockItemInterface advancedStockItem;

//    public StockAdaper() {
////        advancedStockItem = new MSMStockItem();
//    }
    Map<String, String> productCodeMap = new HashMap<String, String>() {
        {
            put("1", "RUN");
            put("2", "SWM");
            put("3", "CYC");
        }
    };

    //conver MSM stock items to ASC stock item
    @Override
    public List<ASCStockItem> loadStock(String stockType) {
        final List<ASCStockItem> newStock = new ArrayList<>();

        try {
            List<MSMStockItem> loadedStock = MSMStockItem.loadStock();
            ASCStockItem aSCStockItem;

            for (MSMStockItem stockItem : loadedStock) {

                String productCode = productCodeMap.get(
                        stockItem.getDepartmentId() + ""
                ) + "-" + stockItem.getCode() + "-MSM";

                aSCStockItem = new ASCStockItem(
                        productCode,
                        stockItem.getName(),
                        stockItem.getDescription(),
                        stockItem.getUnitPrice() / 100,
                        stockItem.getUnitPrice() % 100,
                        stockItem.getQuantityInStock()
                );
                newStock.add(aSCStockItem);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return newStock;
    }

    //save MSM stock item in csv file
    @Override
    public void updateStock(String stockType, ArrayList<String[]> stock) {
        try {
            String fileName = "./src/csv/MengdasSportyMart.csv";
            FileOutputStream fos = new FileOutputStream(fileName);

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            CSVWriter writer = new CSVWriter(new FileWriter(fileName, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

            writer.writeAll(stock);
            writer.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
