import java.util.*;

public class NewTeller {

    private static Random rand = new Random();

    public static NewTellerAcc createNewTellerAccount(Scanner input) { // ✅ Correct type here

        System.out.println("Creating an Employee Account");

        System.out.print("First Name: ");
        String fname = input.nextLine();

        System.out.print("Last Name: ");
        String lname = input.nextLine();
        String tname = fname + " " + lname;

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String tdob = input.nextLine();

        System.out.print("Address: ");
        String taddress = input.nextLine();

        System.out.print("Phone Number: ");
        String tphone = input.nextLine();

        System.out.print("Email: ");
        String temail = input.nextLine();

        String tellerUserName = generateTellerUsername(tname);
        String tellerNumber = generateTellerNumber(tname);
        System.out.println(" Account Created Successfully!");
        System.out.println("Teller Number (Username): " + tellerUserName);

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = input.nextLine();

        while (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match! Try again.");
            System.out.print("Enter your password: ");
            password = input.nextLine();
            System.out.print("Confirm password: ");
            confirmPassword = input.nextLine();
        }

        double balance = 0.0;

        return new NewTellerAcc(
                tellerNumber, tname, taddress, tdob, tphone, temail, tellerUserName,
                password, balance
        ); //  Now properly returning NewTellerAcc object
    }
    private static String generateTellerNumber(String name) {
        // Example: TN (Teller Number) + 9 random digits
        String prefix = "TN";
        int random = rand.nextInt(1000); // 9 digits
        String digits = String.format("%09d", random);
        return prefix + digits;
    }

    private static String generateTellerUsername(String name) {
        char first = Character.toUpperCase(name.charAt(0));
        char second = Character.toUpperCase(name.charAt(1));
        int random = rand.nextInt(100000000);
        String digits = String.format("%09d", random);
        return "" + first + second + digits;
    }
}
