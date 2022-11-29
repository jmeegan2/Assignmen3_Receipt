package Assignment3_Receipt;

import java.text.DecimalFormat;
////////
public class BasicReceipt implements Receipt {
    private String storeHeader; // store name
    private String stateCode; // MD, DE, CA,MA
    private String phoneNum; // store phone
    private String address; // store address
    private String storeNum; // store number



    private PurchasedItems items;
    private ReceiptDate date;
    private TaxComputation taxComputation;
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00#");


    //Alternate Constructor
    public BasicReceipt(PurchasedItems items){
        this.items = items;
    }

    //Set tax to specific state
    public void setTaxComputation(TaxComputation taxComputation){
        this.taxComputation = taxComputation;
    }
    //returns tax value
    public TaxComputation getTaxComputation(){
        return taxComputation;
    }
    //sets the current date
    public void setDate(ReceiptDate date){
        this.date = date;
    }
    //return subtotal cost of items
    public double subTotalCost(){
        return items.getTotalCost();
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setStoreHeader(String storeInfo) {
        this.storeHeader = storeInfo;
    }

    public double setTax() {
        return subTotalCost()*taxComputation.computeTax(items,date);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    @Override
    public void prtReceipt() {

        System.out.println(storeHeader + " (Store #" + storeNum +")" + "\n" + "Address: " + address + " " + stateCode +
                "\n" +"Phone Number: " + phoneNum);
        System.out.println("Item purchased on: " + date );
        items.printItems(); //items will be display when method called
        System.out.println("Subtotal Cost: $" + decimalFormat.format(subTotalCost()));
        System.out.println("Tax: $" + decimalFormat.format(setTax()));
        System.out.println("Total Cost: $"+ decimalFormat.format(subTotalCost()+setTax()) + "\n");

    }
}
