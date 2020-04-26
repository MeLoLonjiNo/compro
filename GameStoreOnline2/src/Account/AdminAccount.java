package Account;

import Person.Person;
import Product.Product;


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
        return "AdminAccount{" + "account=" + account + '}';
    }
    
}
