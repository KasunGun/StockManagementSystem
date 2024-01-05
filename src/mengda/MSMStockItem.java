/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mengda;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class MSMStockItem implements AdvancedStockItemInterface {

    private final int departmentId;
    private final String code;
    private final String nameAndDescription;
    private final int unitPrice;
    private int quantityInStock;

    public MSMStockItem(int departmentId, String code, String titleAndDescription, int unitPrice, int quantityInStock) {
        this.departmentId = departmentId;
        this.code = code;
        this.nameAndDescription = titleAndDescription;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return nameAndDescription.substring(0, 59).replaceAll("\u00a0", "").stripTrailing();
    }

    public String getDescription() {
        return nameAndDescription.substring(60, nameAndDescription.length());
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public String getHumanFriendlyUnitPrice() {

        final int pounds = getUnitPrice() / 100;
        final int pence = getUnitPrice() % 100;
        return String.format("%d.%02d", pounds, pence);
    }

    public void setQuanity(int newQuantity) {
        if (newQuantity >= 0) {
            quantityInStock = newQuantity;
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%s - %s - %s - UNIT PRICE: £%s - QTY: %d",
                getDepartmentId(),
                getCode(),
                getName(),
                getDescription(),
                getHumanFriendlyUnitPrice(),
                getQuantityInStock());
    }

    /**
     * Load a collection of MSMStockItems into a list
     *
     * @return a list of the Mengda's Sportymart stock items.
     * @since 1.0
     */
    public static List<MSMStockItem> loadStock() {
        final List<MSMStockItem> loadedStock = new ArrayList<>();

        //------------------------------------------------------------------
        String fileName = "./src/csv/MengdasSportyMart.csv";
        try {
            FileReader filereader = new FileReader(fileName, StandardCharsets.UTF_8);

            CSVReader csvReader = new CSVReader(filereader, ',', '\'');
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {

                MSMStockItem item = new MSMStockItem(
                        Integer.parseInt(nextRecord[0].replaceFirst("﻿", "")),
                        nextRecord[1],
                        nextRecord[2],
                        Integer.parseInt(nextRecord[3]),
                        Integer.parseInt(nextRecord[4])
                );
                loadedStock.add(item);

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        //------------------------------------------------------------------

        return loadedStock;
    }
}
