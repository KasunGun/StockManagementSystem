/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mengda;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public interface AdvancedStockItemInterface {

    public int getDepartmentId();

    public String getCode();

    public String getName();

    public String getDescription();

    public int getUnitPrice();

    public int getQuantityInStock();

    public String getHumanFriendlyUnitPrice();

    public void setQuanity(int newQuantity);

}
