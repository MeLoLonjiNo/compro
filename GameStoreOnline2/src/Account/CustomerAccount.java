package Account;

import Person.Person;
import Product.Product;


public class CustomerAccount extends  Account{
    
    private Product[] productInCart;
    private int money;
    //private History history[];
    private Product storage[];
    
    public CustomerAccount(Account account) {
        super(account);
        productInCart = new Product[100];
        storage = new Product[100];
    }
    
    public CustomerAccount(String id , String password , Person person){
        super(id, password, person);
        productInCart = new Product[20];
        storage = new Product[20];
    }
    
    boolean addProductToChart(Product addingProduct){
        if(addingProduct==null){ return false; }
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]==null){
                productInCart[i] = addingProduct;
                break;
            }
        }
        return true;
    }
    
    int getProductInCartIndex(){
        
    }
    
}
