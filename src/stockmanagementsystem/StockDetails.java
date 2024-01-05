/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockmanagementsystem;

import asc.ASCStockItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class StockDetails extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Code", "Title", "Description", "Unit Price (Pounds)","Unit Price (Pence)", "Quantity"};
    private static List<ASCStockItem> list;

    public StockDetails(List<ASCStockItem> stList) {
        list = stList;
    }
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getCode();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getDescription();
            case 3:
                return list.get(rowIndex).getUnitPricePounds();
            case 4:
                return list.get(rowIndex).getUnitPricePence();
            case 5:
                return list.get(rowIndex).getQuantityInStock();
            default:
                return "error";
        }
    }
}
