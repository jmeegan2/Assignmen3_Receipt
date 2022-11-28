package Assignment3_Receipt;


public class MATaxComputation extends TaxComputation {
    @Override
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        double tax;
        //if items contain item code with 1406 and it is in tax holiday, return 0.
        if((taxHoliday(date))&&(items.containsItem("1406"))){
            tax = 0;
        }
        else
            tax = 0.0625;
        return tax;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        if(date.getMonth() == 8 && date.getDate() == 13 || date.getDate() == 14){
            return true;
        }
        else
            return false;
    }
}
