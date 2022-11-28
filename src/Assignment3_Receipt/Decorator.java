package Assignment3_Receipt;
/////
public class Decorator implements Receipt {
    private Receipt trailer;

    public Decorator(Receipt r){
        trailer = r;
        }
    public void callTrailer(){
        trailer.prtReceipt();
    }

    public void prtReceipt(){
        callTrailer();
    }
}
