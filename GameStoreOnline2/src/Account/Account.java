package Account;


import Person.Person;
import java.util.Date;
import java.util.Objects;

public class Account {
    private String userID;
    private String password;
    private AccountStatus accountStatus;
    private Person person;

    public Account(Account account){
        this.userID = account.userID;
        this.password = account.password;
        this.person = account.person;
    }
    
    public  Account(String id , String password , Person person){
        this.userID = id;
        this.password = password;
        this.person = person;
        this.accountStatus = AccountStatus.active;
    }
    
    public String getUserID() {
        return userID;
    }

    public boolean resetPassword(){
        this.password = null;
        return true;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }


    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Your Account" + "userID : " + userID + "\n User : " + person + '}';
    }

}
