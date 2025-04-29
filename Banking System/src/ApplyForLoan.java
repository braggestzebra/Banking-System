import java.util.Scanner;

public class ApplyForLoan {
    public static void applyForLoan(Scanner input) {
        System.out.println("Loan Application");
        System.out.println("Enter the amount you want to borrow:");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter the purpose of the loan:");
        String purpose = input.nextLine();
        if (purpose.equals("Personal") || purpose.equals("personal")) {
            System.out.println("sorry, we do not process personal loan requests");
            return;

        }
        System.out.println("Enter the loan term in months:");
        int term = input.nextInt();
        System.out.println("Please Enter the your monthly Salary:");
        double salary = input.nextDouble();
        input.nextLine();
        if (amount <= term * salary) {
            System.out.println("Loan Amount: " + amount);
            System.out.println("Loan Purpose: " + purpose);
            System.out.println("Loan Application Successful! and please bring your 2 paycheck ");

        } else {
            System.out.println("Sorry! we cannot approve your loan request");
        }
    }

}
