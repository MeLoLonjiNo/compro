
public class CustomerAccount {

    
    private Account account;
    static private Product[] productInCart;
    private int money;
    //private History history[];
    private Product storage[];
    
    public CustomerAccount() {
        this.productInCart = new Product[20];
        
    }
//    void viewShop(){
//        
//    }
//    
    static void addToCart(Product product) {
        for (int i = 0; i < productInCart.length ; i++) {
            if(productInCart[i]!=null){
                productInCart[i]=product;
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
//    String checkCart(){
//    
//    }
//    
//    boolean register(){
//    
//    }
//    
}
