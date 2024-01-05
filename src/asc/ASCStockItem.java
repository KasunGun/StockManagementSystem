/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asc;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class ASCStockItem implements StockItemInterface {

    final String fileName = "./src/csv/AshersSportsCollective.csv";

    private String code;
    private String productTitle;
    private String ProductDescription;
    private int unitPricePounds;
    private int unitPricePence;
    private int quantityInStock;

    public ASCStockItem(String code, String productTitle, String ProductDescription, int unitPricePounds, int unitPricePence, int quantityInStock) {

        this.code = code;
        this.productTitle = productTitle;
        this.ProductDescription = ProductDescription;
        this.unitPricePounds = unitPricePounds;
        this.unitPricePence = unitPricePence;
        this.quantityInStock = quantityInStock;
    }

    public ASCStockItem() {
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return productTitle;
    }

    public String getDescription() {
        return ProductDescription;
    }

    public int getUnitPricePounds() {
        return unitPricePounds;
    }

    public int getUnitPricePence() {
        return unitPricePence;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuanity(int newQuantity) {
        if (newQuantity >= 0) {
            quantityInStock = newQuantity;
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - UNIT PRICE: £%d.%d - QTY: %d",
                getCode(),
                getName(),
                getDescription(),
                //                getHumanFriendlyUnitPrice(),
                getUnitPricePounds(),
                getUnitPricePence(),
                getQuantityInStock());
    }

    @Override
    public List<ASCStockItem> loadStock(String stockType) {
        List<ASCStockItem> loadedStock = new ArrayList<>();

        if (stockType.equals("ASC_Stock")) {
            //load AshersSportsCollective.csv file data
            try {
                FileReader filereader = new FileReader(fileName);

                CSVReader csvReader = new CSVReader(filereader, ',', '\'');
                String[] nextRecord;

                // we are going to read data line by line
                while ((nextRecord = csvReader.readNext()) != null) {

                    ASCStockItem item = new ASCStockItem(
                            nextRecord[0].replaceFirst("﻿", ""),
                            nextRecord[1],
                            nextRecord[2],
                            Integer.parseInt(nextRecord[3]),
                            Integer.parseInt(nextRecord[4]),
                            Integer.parseInt(nextRecord[5])
                    );
                    loadedStock.add(item);

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if (stockType.equals("MSM_Stock")) {
            //use Addapter design pattern to conver same stock item format
            StockAdapter stockAdapter = new StockAdapter();
            loadedStock = stockAdapter.loadStock("MSM_Stock");
        }
        return loadedStock;
    }

    public void updateStock(String stockType, ArrayList<String[]> stock) {

        try {
            if (stockType.equals("ASC_Stock")) {
                //save data to AshersSportsCollective.csv file
                FileOutputStream fos = new FileOutputStream(fileName);

                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                CSVWriter writer = new CSVWriter(new FileWriter(fileName, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

                writer.writeAll(stock);
                writer.close();
            } else if (stockType.equals("MSM_Stock")) {
                //send MSM stock date to stock adaptor 
                new StockAdapter().updateStock("MSM_Stock", stock);

            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
