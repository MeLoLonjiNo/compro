package Account;
import Person.Person;
import Product.Product;

public class CustomerAccount extends Account{
    
    private Product[] productInCart;
    private int countCart;
    private Product[] storage;
    private int countStorage;
    private int money;
    //private History history[];
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    
    public CustomerAccount(Account account)  {
        super(account);
        productInCart = new Product[20];
        storage = new Product[20];
        money = 2000;
        countCart=0;
        countStorage=0;
    }

    public int getCountCart() {
        return countCart;
    }

    public int getCountStorage() {
        return countStorage;
    }
    
    public CustomerAccount(String id , String password , Person person){
        super(id, password, person);
        productInCart = new Product[20];
        storage = new Product[20];
        money = 2000;
        countCart=0;
        countStorage=0;
    }
    
    public CustomerAccount(String id , String password , Person person , int money,int countC,int countS){
        super(id, password, person);
        productInCart = new Product[20];
        storage = new Product[20];
        this.money = money;
        countCart=countC;
        countStorage=countS;
    }
    
    public void addCountCart(){
        this.countCart++;
    }
    
    public void deCountCart(){
        this.countCart--;
    }
    
    public void addCountStorage(){
        this.countStorage++;
    }
    
    public void deCountStorage(){
        this.countStorage--;
    }
    
    public boolean prePay(int productPrice){
        if(this.money>=productPrice){
            return true;
    }
        else{return false;}
    }
    
    public void pay(int productPrice){
        this.money = money-productPrice;
    }
    
    public void resize() {
        if(countCart==productInCart.length){
            Product cart[] = new Product[this.productInCart.length+20];
            System.arraycopy(productInCart, 0, cart, 0, countCart);
            productInCart = cart;
        }
        if(countStorage==storage.length){
            Product s[] = new Product[storage.length+20];
            System.arraycopy(storage, 0, s, 0, countStorage);
            storage = s;
        }
    }
    
    public boolean haveProductInCart(Product checkProduct){
            int i = getProductInCartIndex(checkProduct);
            if(i==-1){return false;}
            else{return true;} 
    }
    
    public boolean haveProductInStorage(Product checkProduct){
            int i = getProductInStorageIndex(checkProduct);
            if(i==-1){return false;}
            else{return true;} 
    }
    
    public void addProductToCart(Product addingProduct){
        if(haveProductInCart(addingProduct)){System.out.println(RED+"Sorry... "+addingProduct.getProductName()+" Has Been In Your Cart Yet."+BLACK);
        System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
            resize();
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]==null){
                productInCart[i] = addingProduct;
                break;
                }
            }
        }
    }
    
     public void deleteProductInCart(Product deletingProduct){
        int i = getProductInCartIndex(deletingProduct);
        if( i !=-1 ){
            if(productInCart[i].equals(deletingProduct)&&productInCart[i]!=null){
                productInCart[i] = null ;
                orderProductInCart();
            }
        }else{System.out.println(RED+"Not Have This Product In Your Cart."+BLACK);
        System.out.println("---------------------------------------------------------------------------------------------------");}
    }
     
     void orderProductInCart(){
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
     
     void orderProductInStorage(){
         for (int i = 0; i < storage.length; i++) {
             if(storage[i]==null&&storage[i+1]!=null){
                 storage[i]=storage[i+1];
                 storage[i+1]=null;
             }
             if(storage[i]==null&&storage[i+1]==null){
                     break;
                 }
         }
     }
    
    public int getProductInCartIndex(Product searchProductInCart){
        if(searchProductInCart != null){
        for (int i = 0; i < productInCart.length; i++) {
            if(productInCart[i]!=null && searchProductInCart.equals(productInCart[i]) ){
                return i;
                }
            }
        }
        return -1;
    }
    
    public int getProductInStorageIndex(Product searchProductInStorage){
        if(searchProductInStorage != null){
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null && searchProductInStorage.equals(storage[i]) ){
                return i;
                }
            }
        }
        return -1;
    }
    
    public void getProductInCart(){
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
       resize();
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]==null){
                storage[i] = addingProduct;
                break;
            }
        }
        return true;
    }
     
     public void getProductInStorage(){
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
        if(haveProductInStorage(buyingProduct)){System.out.println(RED+"Sorry... "+buyingProduct.getProductName()+" Has In Your Storage Yet."+BLACK);
        System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
        if(money<buyingProduct.getPrice()){
            System.out.println(RED+"Your Money Is Not Enough !"+BLACK);
        }else{
        addProductToStorage(buyingProduct);
        deleteProductInCart(buyingProduct);
        this.money=money-buyingProduct.getPrice();
        System.out.println("Buying "+buyingProduct.getProductName()+" Success. Pleace Check In Your Storage.");
            }
        }
    }
    
    public int getProductStoreIndex(Product productStore){
        if(productStore != null){
        for (int i = 0; i < productInCart.length; i++) {
            if( productInCart[i].equals(productStore)){
                return i;
                }
            }
        }
        return -1;
    }
    
    

    public int getMoney() {
        return money;
    }
    
    public void getStringMoney() {
        System.out.println("Meney : "+money);
    }
    
    public void setAccountStatus (AccountStatus status){
        super.setAccountStatus(status);
    }
    
    public void addMoney(int addingMoney){
        this.money=money+addingMoney;
    }
    
//    public  AccountStatus getAccuontStatus (){
//        return super.getAccountStatus();
//    }

    
    @Override
    public String toString() {
        return "Customer Account ID : "+super.getUserID()+"\nCustomer Name "+super.getUserName()+"\nCustomer Money : "+this.money+"\nCustomer Account Status : "+this.getAccountStatusToString();
    }
    
    public String toString2() {
        return "Customer Account ID : "+super.getUserID()+"\nCustomer Account Password : "+super.getPassword();
    }
}