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
        money = 2000;
    }
    
    
    public void addProductToCart(Product addingProduct){
        
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]==null){
                productInCart[i] = addingProduct;
                break;
            }
        }
    }
    
     public boolean deleteProductInCart(Product deletingProduct){
        if(deletingProduct==null){ return false; }
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i].equals(deletingProduct)&&productInCart[i]!=null){
                productInCart[i] = null ;
                orderListPDC();
                break;
            }
        }
        return true;
    }
     
     void orderListPDC(){
         for (int i = 0; i < productInCart.length; i++) {
             if(productInCart[i]==null&&productInCart[i+1]!=null){
                 productInCart[i]=productInCart[i+1];
                 productInCart[i+1]=null;
                 
             }
             if(productInCart[i]==null&&productInCart[i+1]==null){
                     break;
                 }
         }
     }
    
    public int getProductInCartIndex(Product searchProductInCart){
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]!=null && searchProductInCart.equals(productInCart[i]) ){
                return i;
            }
        }
        return -1;
    }
    
    public int getProductInStorageIndex(Product searchProductInStorage){
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null && searchProductInStorage.equals(storage[i]) ){
                return i;
            }
        }
        return -1;
    }
    
    public void checkProductInCart(){
        System.out.println("***** Your Product In Cart *****");
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]!=null){
                System.out.println("No."+(i+1)+" "+productInCart[i].toString());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public boolean addProductToStorage(Product addingProduct){
       if(addingProduct==null){ return false; }
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]==null){
                storage[i] = addingProduct;
                break;
            }
        }
        return true;
    }
    
     public boolean deleteProductInStorage(Product deletingProduct){
        if(deletingProduct==null){ return false; }
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].equals(deletingProduct)){
                storage[i] = null ;
                break;
            }
        }
        return true;
    }
     
     public void checkProductInStorage(){
        System.out.println("***** Your Product In Storage *****");
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null){
                System.out.println("No."+(i+1)+" "+storage[i].toString());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
     
    public  int payment(Product payingProduct){
        if(payingProduct==null){return -1;}
        if(money-payingProduct.getPrice()<0){return -2;}
        else money = money-payingProduct.getPrice(); {return money;}
        
     }

    public void buy(Product buyingProduct){
        if(money<buyingProduct.getPrice()){
            System.out.println("Your Money Is Not Enough !");
            //System.out.println("---------------------------------------------------------------------------------------------------");
        }else{
        addProductToStorage(buyingProduct);
        deleteProductInCart(buyingProduct);
        this.money=money-buyingProduct.getPrice();
        System.out.println("Buying "+buyingProduct.getProductName()+" Success. Pleace Check In Your Storage.");
        //System.out.println("---------------------------------------------------------------------------------------------------");
        }
    }
    
    public Product[] getProductInCart() {
        return productInCart;
    }

    public int getMoney() {
        return money;
    }
    
    public void getStringMoney() {
        System.out.println("Meney : "+money);
        
    }

    public Product[] getStorage() {
        return storage;
    }
    
    void setAccountSatus (AccountStatus status){
        super.setAccountStatus(status);
    }
    
    public void addMoney(int addingMoney){
        this.money=money+addingMoney;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "productInCart=" + productInCart + ", money=" + money + ", storage=" + storage + '}';
    }
}