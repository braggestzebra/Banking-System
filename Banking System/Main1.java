import java.util.Scanner;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int choice;


       System.out.println("!!Hello and welcome to Shrestha Banking System!!");
       System.out.println("1. New Account/ User");
       System.out.println("2. Existing Account/ User");
       System.out.println("3. Apply for loan");
       System.out.println("4. Exit");
        System.out.println("Please select the option from the above options: ");
       choice = input.nextInt();
       input.nextLine(); //will consume new line or leave a line

       switch (choice){
           case 1:
                System.out.println("1. Personal");
                System.out.println("2. Business");
                System.out.print("Please Select the Account Type: ");
                int accountType = input.nextInt();
                input.nextLine(); // will consume new line

                if (accountType == 1){
                    System.out.println("Creating a Personal Account ");
                    System.out.println("Please enter your first name: ");
                    String Fname = input.nextLine();
                    System.out.println("Please enter your last name: ");
                    String Lname = input.nextLine();
                    System.out.println("Please enter your Address: ");
                    String address = input.nextLine();
                    System.out.println("Please enter your Date of Birth: (YYYY-MM-DD) ");
                    String dateOfBirth = input.nextLine();
                    System.out.println("Please enter your Phone Number: ");
                    String phoneNumber = input.nextLine();
                    System.out.println("Please enter your Email: ");
                    String email = input.nextLine();
                    //suggest the username as per the email address and choice to choose their own
                    String SuggestedUserName = email.split("@")[0];
                    System.out.println("system suggested user name: " + SuggestedUserName);
                    System.out.println("Do you want to approve this username? (Y/N)");
                    String approved = input.nextLine();
                    String Username;

                    if (approved.equals("Y")){
                        Username = SuggestedUserName;
                    } else {
                        System.out.print("Please enter your desired Username: ");
                        Username = input.nextLine();
                    }
                    // lets generate the account number
                    char FInitial = Character.toUpperCase(Fname.charAt(0));
                    char LInitial = Character.toUpperCase(Lname.charAt(0));
                    int randomNum = rand.nextInt (100000000);
                    String digit = String.format("%09d", randomNum);
                    String AccountNo = "" +FInitial+LInitial+digit;

                    System.out.println("Please enter your Password: ");
                    String password = input.nextLine();
                    System.out.println("Please enter your Confirm Password: ");
                    String confirmPassword = input.nextLine();
                    if (!password.equals(confirmPassword)){
                        System.out.print(" !Invalid Password entered! please try again: ");
                    } else {
                        System.out.print(" Your Password has been stored successfully! ");
                        break;
                    }
                    System.out.print(" Your Account has been created successfully! ");
                    System.out.println("----Account information---- ");
                    System.out.println("Account Number: " + AccountNo);
                    System.out.println("Name        : " + Fname +Lname);
                    System.out.println("Email       : " + email);
                    System.out.println("Phone       : " + phoneNumber);
                    System.out.println("Username    : " + Username + " ");
                    System.out.println("Password    : " + "*".repeat(password.length())+ " ");
                }
                else if (choice==2){
                    System.out.println("Creating a Business Account ");
                    System.out.println("Please enter your Business Name: ");
                    String Bname = input.nextLine();
                    System.out.println("Please enter your Owners Name: ");
                    String OwnerName = input.nextLine();
                    System.out.println("Please enter your Business Address: ");
                    String address = input.nextLine();
                    System.out.println("Please enter your established date (YYYY-MM-DD) ");
                    String dateOfBirth = input.nextLine();
                    System.out.println("Please enter the Phone Number: ");
                    String phoneNumber = input.nextLine();
                    System.out.println("Please enter Email address for the Business Account: ");
                    String email = input.nextLine();
                    //suggest the username as per the email address and choice to choose their own
                    String SuggestedUserName = email.split("@")[0];
                    System.out.println("system suggested user name: " + SuggestedUserName);
                    System.out.println("Do you want to approve this username? (Y/N)");
                    String approved = input.nextLine();
                    String BUsername;

                    if (approved.equals("Y")){
                        BUsername = SuggestedUserName;
                    } else {
                        System.out.print("Please enter your desired Username: ");
                        BUsername = input.nextLine();
                    }
                    // lets generate the account number
                    char FInitial = Character.toUpperCase(Bname.charAt(0));
                    char SecIntial = Character.toUpperCase(OwnerName.charAt(2));
                    int randomNum = rand.nextInt (100000000);
                    String digit = String.format("%09d", randomNum);
                    String AccountNo = "" +FInitial+SecIntial+digit;

                    System.out.println("Please enter your Password: ");
                    String password = input.nextLine();
                    System.out.println("Please enter your Confirm Password: ");
                    String confirmPassword = input.nextLine();
                    if (!password.equals(confirmPassword)){
                        System.out.print(" !Invalid Password entered! please try again: ");
                    } else {
                        System.out.print(" Your Password has been stored successfully! ");
                        break;
                    }
                    System.out.print(" Your Account has been created successfully! ");
                    System.out.println("----Account information---- ");
                    System.out.println("Account Number: " + AccountNo);
                    System.out.println("Name        : " + Bname );
                    System.out.println("Owner's name       : " + OwnerName);
                    System.out.println("Email       : " + email);
                    System.out.println("Phone       : " + phoneNumber);
                    System.out.println("Username    : " + BUsername + " ");
                    System.out.println("Password    : " + "*".repeat(password.length())+ " ");
                }
            case 2:
             System.out.println("Please enter your username");
             String Username = input.nextLine();
        }

    }
}