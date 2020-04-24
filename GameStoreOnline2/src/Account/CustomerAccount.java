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
        money = 2000;
    }
    
    public CustomerAccount(String id , String password , Person person){
        super(id, password, person);
        productInCart = new Product[100];
        storage = new Product[100];
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
    
     boolean deleteProductToChart(Product deletingProduct){
        if(deletingProduct==null){ return false; }
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i].equals(deletingProduct)){
                productInCart[i] = null ;
                break;
            }
        }
        return true;
    }
    
    int getProductInCartIndex(Product searchProductInCart){
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]!=null && searchProductInCart.equals(productInCart[i]) ){
                return i;
            }
        }
        return -1;
    }
    
    boolean addProductToStorage(Product addingProduct){
       if(addingProduct==null){ return false; }
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]==null){
                storage[i] = addingProduct;
                break;
            }
        }
        return true;
    }
    
     boolean deleteProductToStorage(Product deletingProduct){
        if(deletingProduct==null){ return false; }
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].equals(deletingProduct)){
                storage[i] = null ;
                break;
            }
        }
        return true;
    }
     
     int payment(Product payingProduct){
        if(payingProduct==null){return -1;}
        if(money-payingProduct.getPrice()<0){return -2;}
        else money = money-payingProduct.getPrice(); {return money;}
        
     }

    Product[] getProductInCart() {
        return productInCart;
    }

    int getMoney() {
        return money;
    }

    Product[] getStorage() {
        return storage;
    }
    
    void setAccountSatus (AccountStatus status){
        super.setAccountStatus(status);
    }
    
}
