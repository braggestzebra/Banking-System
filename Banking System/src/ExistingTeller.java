import java.util.Map;
import java.util.Scanner;

public class ExistingTeller {
    public static void handleLogin(Map<String, Account> users, Map<String, NewTellerAcc> tellers, Scanner input) {
        tellers = FileHandler.loadTellerData();

        System.out.print("Enter your Teller username: ");
        String tname = input.nextLine();

        if (users.containsKey(tname)) {
            Account teller = users.get(tname);
            System.out.print("Please enter your password: ");
            String pass = input.nextLine();

            if (pass.equals(teller.password)) {
                System.out.println("Welcome, Teller " + teller.name + "!");

                while (true) {
                    System.out.print("\nEnter Customer Account Number to access (or type 'logout' to logout): ");
                    String accountNum = input.nextLine();

                    if (accountNum.equalsIgnoreCase("logout")) {
                        System.out.println("Logging out...");
                        break;
                    }

                    // Find the customer by account number
                    Account customer = null;
                    for (Account acc : users.values()) {
                        if (acc.accountNumber.equals(accountNum)) {
                            customer = acc;
                            break;
                        }
                    }

                    if (customer == null) {
                        System.out.println("Customer with Account Number " + accountNum + " not found.");
                        continue;
                    }

                    System.out.println("\nAccessing Customer: " + customer.name + " (" + customer.accountNumber + ")");

                    int option;
                    do {
                        System.out.println("\n--- Teller Operations ---");
                        System.out.println("1. Balance Inquiry");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        System.out.println("4. Transfer Money");
                        System.out.println("5. Apply for Debit Card");
                        System.out.println("6. Exit to Customer Selection");
                        System.out.print("Choose an option: ");
                        option = input.nextInt();
                        input.nextLine(); // consume leftover newline

                        switch (option) {
                            case 1:
                                System.out.println("Customer's current balance: $" + customer.balance);
                                break;
                            case 2:
                                System.out.print("Enter amount to deposit: $");
                                double deposit = input.nextDouble();
                                customer.balance += deposit;
                                System.out.println("Deposit successful! New balance: $" + customer.balance);
                                break;
                            case 3:
                                System.out.print("Enter amount to withdraw: $");
                                double withdraw = input.nextDouble();
                                if (customer.balance >= withdraw) {
                                    customer.balance -= withdraw;
                                    System.out.println("Withdrawal successful! New balance: $" + customer.balance);
                                } else {
                                    System.out.println("Insufficient funds!");
                                }
                                break;
                            case 4:
                                System.out.print("Enter amount to transfer: $");
                                double transfer = input.nextDouble();
                                if (customer.balance >= transfer) {
                                    customer.balance -= transfer;
                                    System.out.println("Transfer successful! New balance: $" + customer.balance);
                                } else {
                                    System.out.println("Insufficient funds!");
                                }
                                break;
                            case 5:
                                ApplyForDebitCard.applyfordebitcard(input);
                                break;
                            case 6:
                                System.out.println("Exiting back to customer selection...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    } while (option != 6);
                }

            } else {
                System.out.println("Wrong password!");
            }

        } else {
            System.out.println("Teller user not found.");
        }
    }
}
