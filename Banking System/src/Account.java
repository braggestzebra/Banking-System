
    public class Account {
        public String accountNumber;
        public String name;
        public String address;
        public String dob;
        public String phone;
        public String email;
        public String username;
        public String password;
        public String accountType; // "personal" or "business"
        public Double balance;

        public Account(String accountNumber, String name, String address, String dob, String phone,
                       String email, String username, String password, String accountType, Double balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.address = address;
            this.dob = dob;
            this.phone = phone;
            this.email = email;
            this.username = username;
            this.password = password;
            this.accountType = accountType;
            this.balance = balance;
        }
    }

