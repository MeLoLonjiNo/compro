package Account;


import Person.Person;
import java.util.Date;

public class Account extends Person{
    private String userID;
    private String password;
    private AccountStatus accountStatus;
    private Person person;

    public Account(String userID, String password, String name, String address, Date dateOfBirth, String email, String phone) {
        super(name, address, dateOfBirth, email, phone);
        this.userID = userID;
        this.password = password;
        this.accountStatus = AccountStatus.cm;
    }

    public Account(Person person, String name, String address, Date dateOfBirth, String email, String phone) {
        super(name, address, dateOfBirth, email, phone);
        this.person = person;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", accountStatus=" + accountStatus + '}';
    }

}
