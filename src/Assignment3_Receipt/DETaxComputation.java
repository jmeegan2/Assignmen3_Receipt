package Assignment3_Receipt;
////

public class DETaxComputation extends TaxComputation{
    @Override
    //No tax at all, returns 0.
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        return 0;
    }

    @Override
    //not needed since tax is always 0 percent
    protected boolean taxHoliday(ReceiptDate date) {
        return false;
    }
}
