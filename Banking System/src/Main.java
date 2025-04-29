    import java.io.File;
    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Map<String, Account> users = FileHandler.loadCustomerData();
            Map<String, NewTellerAcc> tellers = FileHandler.loadTellerData();


            int choice;

            while (true) {
                System.out.println("!! Welcome to Premium Chartered Bank!!");
                System.out.println("1. New Account/User");
                System.out.println("2. User login");
                System.out.println("3. Apply for loan");
                System.out.println("4. Apply for Credit card");
                System.out.println("5. Exit");
                System.out.print("Please select an option: ");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        Account newUser = NewAccount.createNewAccount(input);
                        users.put(newUser.username, newUser);
                        FileHandler.saveCustomerData(users);
                        break;
                    case 2:
                        ExistingUser.handleLogin(users, input);
                        break;
                    case 3:
                        System.out.println("loading please wait....");
                        ApplyForLoan.applyForLoan(input);
                        return;
                    case 4:
                        System.out.println("loading please wait....");
                        ApplyForCreditCard.applyForCreditCard(input);
                        return;
                    case 5:
                        return;
                    case 6:
                        System.out.println("loading please wait....");
                        System.out.println("Providing Access to the Employee System");
                        StaffLogin.staffLogin(input,tellers);
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
                System.out.println("\n--------------------------\n");
            }
        }
    }

