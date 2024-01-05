/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newStock;

import asc.ASCStockItem;
import asc.ASCStockManagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author B1923274 - Kasun Gunathilake
 */
public class MSMNewStockItem implements NewStockItem {

    NewItem newItem;
    Map<String, String> productCodeMap = new HashMap<String, String>() {
        {
            put("running", "RUN");
            put("swimming", "SWM");
            put("cycling", "CYC");
        }
    };

    public MSMNewStockItem(NewItem newItem) {
        this.newItem = newItem;
    }

    //add new item to MSM stock item
    @Override
    public void addItem() {
        ASCStockManagement stockManagement = new ASCStockManagement();
        List<ASCStockItem> stocks = stockManagement.getaSCStock();

        List<Integer> idList = new ArrayList<Integer>();
        String departmentCode = productCodeMap.get(newItem.getDepartment());

        for (ASCStockItem aSCStockItem : stocks) {
            String[] code = aSCStockItem.getCode().split("-");

            if (code.length == 3 && code[2].equals("MSM")) {
                if (departmentCode.equals(code[0])) {
                    idList.add(Integer.parseInt(code[1]));
                }
            }
        }

        Collections.sort(idList);

        Collections.reverse(idList);

        ASCStockItem newStockItem = new ASCStockItem(
                departmentCode + "-" + (idList.get(0) + 1) + "-MSM",
                newItem.getTitle(),
                newItem.getDescription(),
                newItem.getUnitPricePound(),
                newItem.getUnitPricePence(),
                newItem.getQuantity()
        );

        stocks.add(newStockItem);

        stockManagement.setaSCStock(stocks);
    }

}
