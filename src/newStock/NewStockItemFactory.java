/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newStock;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class NewStockItemFactory {

    //create and return appropriate new factory object 
    public NewStockItem getNewStockItem(String stockType, NewItem newItem) {
        if (stockType.equals("ASC_Stock")) {
            return new ASCNewStockItem(newItem);
        } else if (stockType.equals("MSM_Stock")) {
            return new MSMNewStockItem(newItem);
        }
        return null;
    }
}
