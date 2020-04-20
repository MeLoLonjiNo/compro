
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
    static void checkCart(){
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
