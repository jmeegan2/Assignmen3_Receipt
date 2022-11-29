package Assignment3_Receipt;
////
public class StoreItem {
    private String itemCode;
    private String itemDescription;
    private double itemPrice;

    public StoreItem(String code, String description, double price){
        this.itemCode = code;
        this.itemDescription  = description;
        this.itemPrice = price;
    }

    public String getItemCode() {

        return itemCode;
    }

    public double getItemPrice() {

        return itemPrice;
    }


    public void printItem(){

        System.out.println(itemDescription + ": " + itemCode + " $" + itemPrice);
    }
}
