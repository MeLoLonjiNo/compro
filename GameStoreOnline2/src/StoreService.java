
import Account.AdminAccount;
import Account.CustomerAccount;
import Product.Product;
import Service.Store;
import java.util.Scanner;


public class StoreService {
    private AdminAccount testAdminAccount;
    private CustomerAccount[] testCustomerAccount;
    private Product[] testStore;
    private Store gameStore;
    private static final Scanner sc = new Scanner(System.in);
    
    public StoreService(String storeName, AdminAccount admin){
        this.gameStore = new Store("PokeShop", admin);
        this.testAdminAccount = admin;
    }
    
    
    
}
