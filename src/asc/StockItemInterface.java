/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public interface StockItemInterface {

    public List<ASCStockItem> loadStock(String stockType);

    public void updateStock(String stockType, ArrayList<String[]> stock);

}
