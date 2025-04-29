import java.io.*;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class FileHandler {

    // Save Customer Information to CustomerData.csv
    public static void saveCustomerData(Map<String, Account> users) {
        try (FileWriter writer = new FileWriter("CustomerData.csv")) {
            writer.append("Account Number,Name,Address,DOB,Phone,Email,Username,Password,Account Type,Balance\n");

            for (Account acc : users.values()) {
                writer.append(acc.accountNumber).append(",");
                writer.append(acc.name).append(",");
                writer.append(acc.address).append(",");
                writer.append(acc.dob).append(",");
                writer.append(acc.phone).append(",");
                writer.append(acc.email).append(",");
                writer.append(acc.username).append(",");
                writer.append(acc.password).append(",");
                writer.append(acc.accountType).append(",");
                writer.append(String.valueOf(acc.balance)).append("\n");
            }
            System.out.println(" Customer data saved to CustomerData.csv successfully!");
        } catch (IOException e) {
            System.out.println(" Error saving customer data: " + e.getMessage());
        }
    }

    // Save Teller Information to TellerData.csv
    public static void saveTellerData(Map<String, NewTellerAcc> tellers) {
        try (FileWriter writer = new FileWriter("TellerData.csv")) {
            writer.append("Teller Number,tName,tAddress,tDOB,tPhone,tEmail,tellerUsername,tPassword,Balance\n");

            for (NewTellerAcc teller : tellers.values()) {
                writer.append(teller.tellerNumber).append(",");
                writer.append(teller.tname).append(",");
                writer.append(teller.taddress).append(",");
                writer.append(teller.tdob).append(",");
                writer.append(teller.tphone).append(",");
                writer.append(teller.temail).append(",");
                writer.append(teller.tellerusername).append(",");
                writer.append(teller.password).append(",");
                writer.append(String.valueOf(teller.balance)).append("\n");
            }
            System.out.println(" Teller data saved to TellerData.csv successfully!");
        } catch (IOException e) {
            System.out.println(" Error saving teller data: " + e.getMessage());
        }
    }

    // Load Customer Information
    public static Map<String, Account> loadCustomerData() {
        Map<String, Account> users = new HashMap<>();
        File file = new File("CustomerData.csv");

        if (!file.exists()) {
            try {
                file.createNewFile();
                return users;
            } catch (IOException e) {
                System.out.println(" Failed to create CustomerData.csv: " + e.getMessage());
                return users;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    Account acc = new Account(
                            parts[0], parts[1], parts[2], parts[3], parts[4],
                            parts[5], parts[6], parts[7], parts[8], Double.parseDouble(parts[9])
                    );
                    users.put(acc.username, acc);
                }
            }
        } catch (IOException e) {
            System.out.println(" Error loading customer data: " + e.getMessage());
        }
        return users;
    }

    // Load Teller Information
    public static Map<String, NewTellerAcc> loadTellerData() {
        Map<String, NewTellerAcc> tellers = new HashMap<>();
        File file = new File("TellerData.csv");

        if (!file.exists()) {
            try {
                file.createNewFile();
                return tellers;
            } catch (IOException e) {
                System.out.println(" Failed to create TellerData.csv: " + e.getMessage());
                return tellers;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    NewTellerAcc teller = new NewTellerAcc(
                            parts[0], parts[1], parts[2], parts[3], parts[4],
                            parts[5], parts[6], parts[7], Double.parseDouble(parts[8])
                    );
                    tellers.put(teller.tellerusername, teller);
                }
            }
        } catch (IOException e) {
            System.out.println(" Error loading teller data: " + e.getMessage());
        }
        return tellers;
    }
}