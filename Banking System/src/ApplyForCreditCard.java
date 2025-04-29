import java.util.Scanner;

public class ApplyForCreditCard {
    public static void applyForCreditCard(Scanner input) {
        System.out.println("Credit Card Application");
        System.out.println("Please enter your annual income:");
        double income = input.nextDouble();
        input.nextLine();

        System.out.println("Please enter your SSN:");
        double score = input.nextDouble();
        input.nextLine();

        System.out.println("Please enter your credit score:");
        double creditScore = input.nextDouble();
        input.nextLine();
        if (creditScore <= 579) {
            System.out.println("Sorry you didn't get approved for a credit card! ");
            System.out.println("Poor credit score, please apply again with a higher credit score");
        } else if (creditScore >= 580 && creditScore <= 669) {
            System.out.println("Congratulations! you were approved for a credit card! ");
            System.out.println("Your credit limit is $ 500");
        } else if (creditScore >= 670 && creditScore <= 739) {
            System.out.println("Congratulations! you were approved for a credit card! ");
            System.out.println("Your credit limit is $ 1500");
        } else if (creditScore >= 740 && creditScore <= 799) {
            System.out.println("Congratulations! you were approved for a credit card! ");
            System.out.println("Your credit limit is $ 5000");
        } else if (creditScore >= 800) {
            System.out.println("Congratulations! you were approved for a Premium Chartered Amex credit card! ");
            System.out.println("Your credit limit is $ 15000");
        }
        System.out.println("Thank you for applying for a Premium Chartered bank credit card! ");

    }
}
