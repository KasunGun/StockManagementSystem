/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class Sale {

    private Date dateAndTime;
    private String productCode;
    private int quantitySold;
    private int unitPricePounds;
    private int unitPricePence;

    public Sale(Date dateAndTime, String productCode, int quantitySold, int unitPricePounds, int unitPricePence) {
        this.dateAndTime = dateAndTime;
        this.productCode = productCode;
        this.quantitySold = quantitySold;
        this.unitPricePounds = unitPricePounds;
        this.unitPricePence = unitPricePence;
    }

    public Sale() {
    }

    public int getUnitPricePounds() {
        return unitPricePounds;
    }

    public int getUnitPricePence() {
        return unitPricePence;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public String getProductCode() {
        return productCode;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void updateSales(List<Sale> sales) {
        ArrayList<String[]> salesList = new ArrayList<>();
        for (Sale sale : sales) {
            salesList.add(new String[]{
                sale.getDateAndTime() + "",
                sale.getProductCode(),
                sale.getQuantitySold() + "",
                sale.getUnitPricePounds() + "",
                sale.getUnitPricePence() + ""
            });
        }
        try {
            String fileName = "./src/csv/sales.csv";
//            FileOutputStream fos = new FileOutputStream(fileName);
//
//            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            CSVWriter writer = new CSVWriter(new FileWriter(fileName, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

            writer.writeAll(salesList);
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
