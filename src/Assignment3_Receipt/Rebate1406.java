package Assignment3_Receipt;

////
public class Rebate1406 implements AddOn,Rebate {

    public boolean applies(PurchasedItems items){
        return items.containsItem("1406");
    }

    public String getLines(){
        return "Mail-in Rebate for item #1406\n"+ "Mail to: BestBuy Rebates, P.O Box 1400, Orlando, FL";
    }
}
