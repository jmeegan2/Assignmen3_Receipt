package Assignment3_Receipt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
//////

public class ReceiptFactory{

    String header;
    String state_code;
    String phone;
    String store_addr;
    String store_num;



    private TaxComputation[] taxComputationsObjs;
    private ReceiptDate receiptDate;
    private AddOn[] addOns;


    public ReceiptFactory(){
        configFileGenerator();
        readConfigFile configFile = new readConfigFile();
        taxComputationsObjs = new TaxComputation[4];
        addOns = new AddOn[4];

        header = configFile.getProperty("header");
        state_code = configFile.getProperty("state_code");
        phone = configFile.getProperty("phone");
        store_addr = configFile.getProperty("store_addr");
        store_num = configFile.getProperty("store_num");

        taxComputationsObjs[0] = new MDTaxComputation();
        taxComputationsObjs[1] = new MATaxComputation();
        taxComputationsObjs[2] = new DETaxComputation();
        taxComputationsObjs[3] = new CATaxComputation();

        addOns[0] = new HolidayGreeting();
        addOns[1] = new GeneralGreeting();
        addOns[2] = new Rebate1406();
        addOns[3] = new Coupon100Get10Percent();


    }
    public ReceiptDate getDate(int month,int date,int year){
        receiptDate = new ReceiptDate(month,date,year);
        return receiptDate;
    }

    public Receipt getReceipt(PurchasedItems items) {

        BasicReceipt basicReceipt = new BasicReceipt(items);
        basicReceipt.setDate(receiptDate);

        switch (state_code) {
            case "MD":
                basicReceipt.setTaxComputation(new MDTaxComputation());
                basicReceipt.setStateCode(state_code);
                basicReceipt.setStoreHeader(header);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setAddress(store_addr);
                basicReceipt.setStoreNum(store_num);
                basicReceipt.setPhoneNum(phone);
                break;
            case "MA":
                basicReceipt.setTaxComputation(new MATaxComputation());
                basicReceipt.setStateCode(state_code);
                basicReceipt.setStoreHeader(header);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setAddress(store_addr);
                basicReceipt.setStoreNum(store_num);
                basicReceipt.setPhoneNum(phone);
                break;
            case "DE":
                basicReceipt.setTaxComputation(taxComputationsObjs[2]);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setStoreHeader(header);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setAddress(store_addr);
                basicReceipt.setStoreNum(store_num);
                basicReceipt.setPhoneNum(phone);
                break;
            case "CA":
                basicReceipt.setTaxComputation(taxComputationsObjs[3]);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setStoreHeader(header);
                basicReceipt.setStateCode(state_code);
                basicReceipt.setAddress(store_addr);
                basicReceipt.setStoreNum(store_num);
                basicReceipt.setPhoneNum(phone);
                break;
            default:
                System.out.println("Invalid state");
        }


        Decorator decorator = new Decorator(basicReceipt);

        for (int i = 0; i < addOns.length; i++) {
            if (addOns[i].applies(items)) {
                if (addOns[i] instanceof HolidayGreeting){
                    if(basicReceipt.getTaxComputation().taxHoliday(receiptDate)){
                        decorator = new PreDecorator(addOns[i],decorator);
                    }
                }
                else if(addOns[i] instanceof GeneralGreeting)
                    decorator = new PreDecorator(addOns[i],decorator);
                else if(addOns[i] instanceof Coupon || addOns[i] instanceof Rebate){
                    decorator = new PostDecorator(addOns[i],decorator);
                }
            }
        }
        return decorator;
    }

    public void configFileGenerator(){
        Properties prop = new Properties();
        try {
            //set the properties value
            prop.setProperty("header", "BestBuy");
            prop.setProperty("store_num", "143");
            prop.setProperty("store_addr", "602 Boulton St, Bel Air");
            prop.setProperty("phone","1-410-893-6101");
            //CHANGE OF STATE CODE WILL AFFECT TAX COMPUTATION (MD,CA,DE,MA)
            prop.setProperty("state_code","MD");


            //save properties to project root folder
            prop.store(new FileOutputStream("configuration.properties"), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

