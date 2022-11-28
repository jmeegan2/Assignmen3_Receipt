package Assignment3_Receipt;
/////

public abstract class TaxComputation{
    public abstract double computeTax(PurchasedItems items, ReceiptDate date);
    //give taxHoliday the receipt date to check for eligibility
    protected abstract  boolean taxHoliday(ReceiptDate date);
}
