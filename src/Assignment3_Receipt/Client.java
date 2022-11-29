package Assignment3_Receipt;
///
import java.util.*;
public class Client {

    public static final int min = 0;
    public static final int max = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PurchasedItems items = new PurchasedItems();
        ReceiptFactory receiptFactory = new ReceiptFactory();

        // Unix epoch date, will be overwritten if the user presses 1
        // This is here so there is always a date for the receipt and no error will be thrown
        int currentDate = 1;
        int currentMonth = 1;
        int currentYear = 1970;
        receiptFactory.getDate(currentMonth,currentDate,currentYear);

        int choice;
        choice = menu(input, min, max);
        while (choice != 0) {
            ReceiptDate date;
            switch (choice) {
                // get receipt date
                case 1:
                    items.clearReceipt();

                    System.out.print("Enter the month (enter value  1-12): ");
                    currentMonth = getInt(input,1,12);
                    System.out.print("Enter the date (enter value  1-31): ");
                    currentDate = getInt(input,1,31);
                    System.out.print("Enter the year: ");
                    currentYear = getInt(input,1,3000);

                    //Set the current date in ReceiptFacotry Object if user choice case 1
                    receiptFactory.getDate(currentMonth,currentDate,currentYear);

                    break;
                // display all available products to user.
                case 2:
                    generateMenuItem(items,input);
                    break;
                //Case 3 Prints out receipt.
                case 3:
                    Receipt receipt = receiptFactory.getReceipt(items);
                    receipt.prtReceipt();
                    break;
            }
            choice = menu(input, min, max);
        }
        System.out.println("Exited from Menu");


    }

    //Menu that displays the options.
    public static int menu(Scanner input, int min, int max) {
        int ans;
        System.out.println(
                "\t--------------------------------------------------------\n" +

                "\t1 – New Receipt\n" +
                "\t2 – Add items to shopping cart\n" +
                "\t3 – Display Receipt\n" +
                "\t0 - Exit Menu\n" +

                "\t--------------------------------------------------------\n");
        System.out.print("    Enter your choice: ");
        ;
        ans = getInt(input, min, max);
        return ans;
    }

    //Input validation for interger choices.
    public static int getInt(Scanner input, int min, int max) {
        while (!input.hasNextInt()) {
            System.out.print("Invalid, Please re-enter: ");
            input.next();
        }
        int choice = input.nextInt();
        if (choice < min || choice > max) {
            System.out.print("Invalid range.Please re-enter: ");
            choice = getInt(input, min, max);
        }
        return choice;
    }

    //method that generates hardcoded menu items.
    public static void generateMenuItem(PurchasedItems items,Scanner input) {
        int userInput;
        System.out.println("    Add items below to your cart.");
        System.out.println
                ("\t--------------------------------------------------------\n" +
                "\t1 – Television $450 \n" +
                "\t2 – M1 Macbook Air $1150\n" +
                "\t3 – Levi Jeans $35 #1406 item\n" +
                "\t0 - Go to Checkout\n" +
                "\t--------------------------------------------------------\n");

        System.out.print("    Enter your choice: ");
        userInput = getInt(input, min, max);

        if(userInput == 1)
            items.addItem(new StoreItem("1001","Television",450));

        else if(userInput == 2)
            items.addItem(new StoreItem("1000","M1 Macbook Air",1150));

        else
            //Only item eligible for maryland tax holiday, has to be clothing or footwear less than 100 dollars
            items.addItem(new StoreItem("1406","Levi Jeans",35));

    }
}
