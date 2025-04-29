import java.util.*;
public class ApplyForDebitCard {
    public static void applyfordebitcard (Scanner input){
        System.out.println("\n--- Apply for Debit Card ---");
        System.out.print("Enter your account number: ");
        String accNum = input.nextLine();

        System.out.println("Thank you! Your Debit Card application linked to Account " + accNum + " is under process.");
        System.out.println("you should be receiving it via mail in 14 business days");
    }
}