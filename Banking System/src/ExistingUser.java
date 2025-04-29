import java.util.Map;
import java.util.Scanner;

public class ExistingUser {
    public static void handleLogin(Map<String, Account> users, Scanner input) {
        users = FileHandler.loadCustomerData();

        System.out.print("Enter your username: ");
        String uname = input.nextLine();

        if (users.containsKey(uname)) {
            Account acc = users.get(uname);
            System.out.println("Please enter your password: ");
            String pass = input.nextLine();
            if (pass.equals(acc.password)) {

                System.out.println("Welcome, " + acc.name + "!");
                System.out.println("Account Type: " + acc.accountType);
                System.out.println("1. Balance inquiry");
                System.out.println("2. Withdrawal");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5.Apply for Debit Card");
                System.out.println("6. logout");
                System.out.println("Please select an option: ");
                int option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("your current balance is $" + acc.balance);
                        break;
                    case 2:
                        System.out.println("Please enter the amount you will to deposit: $");
                        double deposit = input.nextDouble();
                        acc.balance += deposit;
                        System.out.println("Deposit Successful! Your new balance is $ " + acc.balance);
                        break;
                    case 3:
                        System.out.println("Please enter the amount you will to withdraw: $");
                        double withdraw = input.nextDouble();
                        if (acc.balance >= withdraw) {
                            System.out.println("Please collect your money!");
                            acc.balance -= withdraw;
                            System.out.println("Your new balance is $" + (acc.balance));
                            }
                        else {
                            System.out.println("Insufficient Funds!");
                        }
                        break;
                        case 4:
                            System.out.println("Please enter the amount you will to transfer: $");
                            double transfer = input.nextDouble();
                            if (acc.balance >= transfer) {
                                System.out.println("Please collect your money!");
                                acc.balance -= transfer;
                                System.out.println("Your new balance is $" + (acc.balance));
                            }
                            else {
                                System.out.println("Insufficient Funds!");
                            }
                            break;
                            case 5:
                                ApplyForDebitCard.applyfordebitcard(input);
                                break;
                    case 6:
                        System.out.println("logging out....... !");
                        return;
                }
            }else {
                System.out.println("Wrong password!");
            }

            // You can add password verification or transaction options here
        } else {
            System.out.println("User not found.");
        }
    }
}
