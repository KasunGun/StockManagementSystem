/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newStock;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class NewItem {

    private String store;
    private String department;
    private String title;
    private String description;
    private int unitPricePound;
    private int unitPricePence;
    private int quantity;

    public NewItem(String store, String department, String title, String description, int unitPricePound, int unitPricePence, int quantity) {
        this.store = store;
        this.department = department;
        this.title = title;
        this.description = description;
        this.unitPricePound = unitPricePound;
        this.unitPricePence = unitPricePence;
        this.quantity = quantity;
    }

    public String getStore() {
        return store;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitPricePound() {
        return unitPricePound;
    }

    public int getUnitPricePence() {
        return unitPricePence;
    }

    public int getQuantity() {
        return quantity;
    }

}
