import java.util.Scanner;
import java.util.Map;

public class StaffLogin {
    public static void staffLogin(Scanner input, Map<String, NewTellerAcc> tellers) {
        System.out.println("Welcome back to the system ");
        System.out.println("Accessing the employee's information ");
        System.out.println("Please enter your username: ");
        String staffUserName = input.nextLine();
        System.out.println("Please enter your password: ");
        String staffPassword = input.nextLine();
        // Hardcoded Manager Login (for now)
        if (staffUserName.equals("manager1") && staffPassword.equals("managerpass")) {
            ManagerAccess.managerAccess(input, tellers); // Pass tellers map
            return;
        }

        // Teller Login (dynamic from file)
        tellers = FileHandler.loadTellerData(); // Always load latest tellers

        if (tellers.containsKey(staffUserName)) {
            NewTellerAcc teller = tellers.get(staffUserName);
            if (teller.password.equals(staffPassword)) {
                System.out.println(" Welcome Teller " + teller.tname + "!");
                // You can add teller dashboard options here later if you want
            } else {
                System.out.println(" Wrong password!");
            }
        } else {
            System.out.println(" Invalid Staff Credentials. Returning to Main Menu...");
        }
    }
}
