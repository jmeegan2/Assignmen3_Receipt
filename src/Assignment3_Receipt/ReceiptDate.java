package Assignment3_Receipt;

public class ReceiptDate {
    private int month;
    private int day;
    private int year;

    public ReceiptDate(){
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    public ReceiptDate(int month, int date, int year) {
        this.month = month;
        this.day = date;
        this.year = year;
    }

    public void setDate(int date) {

        this.day = date;
    }

    public void setMonth(int month) {

        this.month = month;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public int getDate() {

        return day;
    }

    public int getMonth() {

        return month;
    }

    public int getYear() {

        return year;
    }
    @Override
    public String toString(){

        return getMonth() + "/" + getDate() + "/" + getYear();
    }
}

