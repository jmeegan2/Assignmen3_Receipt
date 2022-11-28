package Assignment3_Receipt;


public class MDTaxComputation extends TaxComputation{
    @Override
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        double tax;

        if((taxHoliday(date))&&(items.containsItem("1406"))){
            tax = 0;
        }
        else
            tax = 0.06;
        return tax;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        if(
//
//        From 12:01 a.m. on the second Sunday in August through midnight on the following Saturday,
//        qualifying clothing and footwear priced $100 or less will be exempt from Maryland’s six percent
//        sales tax. The first $40 of back/bookbag sales also qualify
                //08/13/2023 - 08/19/2023

                date.getMonth() == 8 && date.getDate() == 13||
                        date.getDate() == 14||date.getDate() == 15||
                date.getDate()==16||date.getDate() ==17||
                        date.getDate() == 18 || date.getDate()==19
        )
        {
            return true;
        }
        else
            return false;
    }

}
