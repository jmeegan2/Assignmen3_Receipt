package Assignment3_Receipt;

import java.util.ArrayList;
//////

public class PurchasedItems {
    private ArrayList<StoreItem> items;

    public PurchasedItems(){
        items = new ArrayList();
    }
    public void addItem(StoreItem item){
        items.add(item);
    }
    public double getTotalCost(){
        double totalCost = 0;
        for(StoreItem items:items){
            totalCost += items.getItemPrice();
        }
        return totalCost;
    }
    public boolean containsItem(String itemCode){
        for(StoreItem storeItem: items){
            if(storeItem.getItemCode().equals(itemCode))
                return true;
            else
                return false;
        }
        return false;
    }
    public void printItems(){
        for(StoreItem item: items){
            item.printItem();
        }
    }
    public void clearReceipt(){
        items = new ArrayList<StoreItem>();
    }
}
