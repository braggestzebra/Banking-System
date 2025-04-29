public class NewTellerAcc {
        public String tellerNumber;
        public String tname;
        public String taddress;
        public String tdob;
        public String tphone;
        public String temail;
        public String tellerusername;
        public String password;
        public Double balance;

        public NewTellerAcc(String tellerNumber, String tname, String taddress, String tdob, String phone,
                       String email, String tellerusername, String password, Double balance) {
            this.tellerNumber = tellerNumber;
            this.tname = tname;
            this.taddress = taddress;
            this.tdob = tdob;
            this.tphone = phone;
            this.temail = temail;
            this.tellerusername = tellerusername;
            this.password = password;
            this.balance = balance;
        }
}



