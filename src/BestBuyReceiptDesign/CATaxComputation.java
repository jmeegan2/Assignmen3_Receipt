package BestBuyReceiptDesign;


public class CATaxComputation extends TaxComputation {
    @Override
    //No tax holiday, only returns the 7.25% of tax rate
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        return 0.0725;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        return false;
    }
}
