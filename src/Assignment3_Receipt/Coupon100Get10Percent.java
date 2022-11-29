package Assignment3_Receipt;

//
public class Coupon100Get10Percent implements AddOn,Coupon{

    //If getTotalCost is more than 100 then the applies function below will be true
    public boolean applies(PurchasedItems items){
        if(items.getTotalCost() >= 100){return true;}
        return false;
    }
    public String getLines(){
        return "Coupon with 10% of next purchase";
    }
}
