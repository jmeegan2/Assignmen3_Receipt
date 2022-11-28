package BestBuyReceiptDesign;


public class DETaxComputation extends TaxComputation{
    @Override
    //No tax at all, returns 0.
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        return 0;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        return false;
    }
}
