//008 กฤษณพนธ์ รักเกียรติงาม
package Store;

import Account.AdminAccount;
import Account.CustomerAccount;


public class Store{
    private String storeName;
    private AdminAccount admin;;
    private int countCustomer;
    private int countProduct;
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    
    public Store(String storeName, AdminAccount admin) {
        this.storeName = storeName;
        this.admin = admin;
        this.countProduct=0;
        this.countCustomer=0;
    }

    public Store(String storeName, AdminAccount admin, int countCustomer, int countProduct) {
        this.storeName = storeName;
        this.admin = admin;
        this.countCustomer = countCustomer;
        this.countProduct = countProduct;
    }
 
    public int getCountCustomer() {
        return countCustomer;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public String getStoreName() {
        return storeName;
    }
    
    
    public void addMoney(CustomerAccount customerAccount,int money) {
        customerAccount.addMoney(money);
    }

    @Override
    public String toString() {
        return "Store Name : " + storeName + "\nAdmin : " + admin.getUserName() + "\nCount Customer : " + countCustomer + "\nCount Product : " + countProduct ;
    }
}
