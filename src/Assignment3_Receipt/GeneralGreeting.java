package Assignment3_Receipt;

////
public class GeneralGreeting implements AddOn,SecondaryHeading{

    //When the date is one of the Tax holidays, return true
    public boolean applies(PurchasedItems items){
        return true;
    }
    public String getLines(){
        return "\n* Thanks for shopping with BestBuy *";
    }

}
