//044 นิพพิชฌ์ โชติโก
package Account;

import Person.Person;


public class AdminAccount extends Account{
    
    private Account account;
    
    public AdminAccount(Account account) {
        super(account);
    }
    
     public AdminAccount(String id , String password , Person person){
        super(id, password, person);
     }
     
    public Account getAccount() {
        return account;
    }
    
    @Override
    public String toString() {
        return "Admin Account ID : "+super.getUserID()+"\nAdmin Name : "+super.getUserName();
    }
    
}
