import java.util.*;

public class NewAccount {

    private static Random rand = new Random();
    public static Account createNewAccount(Scanner input) {
        double balance = 0;
        System.out.println("1. Personal");
        System.out.println("2. Business");
        System.out.print("Please Select the Account Type: ");
        int accountTypeChoice = input.nextInt();
        input.nextLine();

        String name = "", address, dob, phone, email, username, password;
        String accountType = (accountTypeChoice == 1) ? "personal" : "business";

        if (accountTypeChoice == 1) {
            System.out.println("Creating a Personal Account");
            System.out.print("First Name: ");
            String fname = input.nextLine();
            System.out.print("Last Name: ");
            String lname = input.nextLine();
            name = fname + " " + lname;
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            dob = input.nextLine();
        } else {
            System.out.println("Creating a Business Account");
            System.out.print("Business Name: ");
            name = input.nextLine();
            System.out.print("Owner's Name: ");
            String owner = input.nextLine();
            System.out.print("Date of Establishment (YYYY-MM-DD): ");
            dob = input.nextLine();
        }

        System.out.print("Address: ");
        address = input.nextLine();

        System.out.print("Phone Number: ");
        phone = input.nextLine();
        System.out.print("Email: ");
        email = input.nextLine();

        String suggestedUsername = email.split("@")[0];
        System.out.println("Suggested Username: " + suggestedUsername);
        System.out.print("Do you want to use this username? (Y/N): ");
        if (input.nextLine().equalsIgnoreCase("Y")) {
            username = suggestedUsername;
        } else {
            System.out.print("Enter your desired username: ");
            username = input.nextLine();
        }

        System.out.print("Enter your password: ");
        password = input.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = input.nextLine();

        while (!password.equals(confirmPassword)) {
            System.out.print("Passwords do not match! Try again: ");
            password = input.nextLine();
            System.out.print("Confirm password: ");
            confirmPassword = input.nextLine();
        }
        System.out.println("Would you like to make an deposit to your account? (Y/N)!");
        if (input.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Please enter the amount to deposit: ");
            double deposit = input.nextDouble();
            balance += deposit;
        }else{
            System.out.println("No deposit made!");
        }

        String accNum = generateAccountNumber(name);
        System.out.println("Account Created Successfully!");
        System.out.println("Account Number: " + accNum);
        return new Account (accNum, name, address, dob, phone, email, username, password, accountType, balance);
    }

    private static String generateAccountNumber(String name) {
        char first = Character.toUpperCase(name.charAt(0));
        char second = Character.toUpperCase(name.charAt(1));
        int random = rand.nextInt(100000000);
        String digits = String.format("%09d", random);
        return "" + first + second + digits;
    }
}
