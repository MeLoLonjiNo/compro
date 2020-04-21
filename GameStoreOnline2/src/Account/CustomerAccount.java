package Account;

import Product.Product;


public class CustomerAccount{
    
    private Account account;
    static private Product[] productInCart;
    private int money;
    //private History history[];
    private Product storage[];
    
    public CustomerAccount() {
        this.productInCart = new Product[20];
        
    }
    
    
    
    static void eX(int i){
        CustomerAccount.productInCart = new Product[20];
    }
//    void viewShop(){
//        
//    }
//    
    static void addToCart(Product pd) {
        for (int j = 0; j < productInCart.length ; j++) {
            if(productInCart[j]==null){
                productInCart[j]=pd;
                break;
            }
        }
    }
//    
//    void removeFromCart(){
//    
//    }
//    
//    void buy(){
//    
//    }
//    
//    int checkMoney(){
//    
//    }
//    
    static void checkCart(){
        System.out.println("--- Your Product In Cart ---");
        for (int i = 0; i < productInCart.length ; i++) {
            if(productInCart[i]!=null){
                System.out.println("No."+(i+1)+" "+productInCart[i]);
            }
        }
    }
//    
//    boolean register(){
//    
//    }
//    
}
