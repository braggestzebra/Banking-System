import java.util.Map;
import java.util.Scanner;

public class ManagerAccess {
    public static void managerAccess(Scanner input, Map<String, NewTellerAcc> tellers) {
        System.out.println("Welcome to the manager's dashboard");
        System.out.println("1. Add new teller");
        System.out.println("2. Access existing teller");
        System.out.println("3. take a look at loan application");
        System.out.println ("4. Access a credit card application");
        System.out.println("5. look at the Customer's account");
        System.out.println("6. look at the whole employee list");
        System.out.println("7. logout");
        System.out.print("Please select an option: ");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                NewTellerAcc teller = NewTeller.createNewTellerAccount(input); // Correct method name
                tellers.put(teller.tellerusername, teller); // Correct teller object
                FileHandler.saveTellerData(tellers);
                break;
            case 2:
                System.out.println("Loading......");
                break;
            case 3:
                System.out.println("Loading......");
                break;
            case 4:
                System.out.println("Loading......");
                break;
            case 5:
                System.out.println("Loading......");
                break;
            case 6:
                viewEmployeeList(tellers);
                break;
            case 7:
                System.out.println("logging out....");
                return;
            default:
                System.out.println("Invalid option. Try again.");
                break;


        }
    }
    private static void viewEmployeeList(Map<String, NewTellerAcc> tellers) {
        System.out.println("\n--- Employee (Teller) List ---");

        if (tellers.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (NewTellerAcc teller : tellers.values()) {
            System.out.println("Teller Number: " + teller.tellerNumber);
            System.out.println("Teller Name  : " + teller.tname);
            System.out.println("Username     : " + teller.tellerusername);
            System.out.println("Phone Number : " + teller.tphone);
            System.out.println("Email        : " + teller.temail);
            System.out.println("Balance      : $" + teller.balance);
            System.out.println("-----------------------------");
        }
    }
}

