package Service;


import Account.AccountStatus;
import Service.AdminService;
import Service.CustomerService;
import Product.Product;
import Account.CustomerAccount;
import Account.AdminAccount;

public class Store implements CustomerService,AdminService{
    private String storeName;
    private Product[] store;
    private AdminAccount admin;
    private CustomerAccount[] customer;
    private int countCustomer;
    private int countProduct;
    
    public Store(String storeName, AdminAccount admin) {
        this.storeName = storeName;
        this.store=new Product[10];
        this.admin = admin;
        this.customer = new CustomerAccount[10];
        this.countProduct=0;
    }

    public int getCustomerIndex(CustomerAccount customer) {
        for (int i = 0; i < countCustomer; i++) {
            if (this.customer[i].equals(customer)) {
                return i;
            }
        }
        return -1;
    }
    
    public int getProductStoreIndex(Product productStore){
        if(productStore != null){
        for (int i = 0; i < countProduct; i++) {
            if( store[i].equals(productStore)){
                return i;
                }
            }
        }
        return -1;
    }
    
    public boolean haveProductInStore(Product checkProduct){
            int i = getProductStoreIndex(checkProduct);
            if(i==-1){return false;}
            else{return true;} 
    }
    
    public boolean haveProductInCart(CustomerAccount customer,Product checkProduct){
            int i = customer.getProductInCartIndex(checkProduct);
            if(i==-1){return false;}
            else{return true;} 
    }
    
    public Product codeToObject(String pdc){
        if(pdc == null) {return null;}
        for (int i = 0; i < store.length; i++) {
            if (pdc.equalsIgnoreCase(store[i].getProductCode())){
                return store[i];
            }break;
        }
        return null;
    }
 
    public void addToCart(CustomerAccount customer,Product addingProduct) { 
        if(haveProductInStore(addingProduct)){
            customer.addProductToCart(addingProduct);
        }else {System.out.println("Sorry... Not Have "+addingProduct.getProductName()+" Product In Store.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
    }
   
    void orderProductInStroe(){
         for (int i = 0; i < store.length; i++) {
             if(store[i]==null&&store[i+1]!=null){
                 store[i]=store[i+1];
                 store[i+1]=null;
                 
             }
             if(store[i]==null&&store[i+1]==null){
                     break;
                 }
         }
     }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    
    @Override
    public void viewShop() {
        System.out.println("***** Welcome to "+this.storeName.toString()+" Game Store Shop *****");
        for (int i = 0; i < store.length ; i++) {
            if(store[i]!=null){
            System.out.println(store[i]);
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    @Override
    public void addToCart(CustomerAccount customer,String pdc) { 
        Product addingpdc = codeToObject(pdc);
        if(haveProductInStore(addingpdc)){
            customer.addProductToCart(addingpdc);
        }else {System.out.println("Sorry... Not Have "+pdc+" Product In Store.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
    }

    @Override
    public void removeFromCart(CustomerAccount customer,String pdc) {
        customer.deleteProductInCart(codeToObject(pdc));
    }

    @Override
    public void buy(CustomerAccount customer,Product buyingProduct) {
        if(haveProductInCart(customer,buyingProduct)){
            customer.buy(buyingProduct);
            checkMoney(customer);
        }else {System.out.println("Sorry...Please Add "+buyingProduct.getProductName()+" To Your Cart First.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
    }

    @Override
    public void checkMoney(CustomerAccount customer) {
        System.out.println("***** Your Maintaining Money *****");
        System.out.println("Money : " + customer.getMoney());
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    @Override
    public void checkCart(CustomerAccount customer) {
        customer.checkProductInCart();
    }

    @Override
    public void checkStorage(CustomerAccount customer) {
        customer.checkProductInStorage();
    }
    
//    @Override
//    public boolean register() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    
    @Override
    public void addProduct(Product pd) {
        for (int i = 0; i<store.length; i++) {
            if(store[i]==null){
                store[i]=pd;
                break;
            }
        }
        this.countProduct++;
    }

    @Override
    public void removeProduct(Product pd){
        int i = getProductStoreIndex(pd);
            if(store[i]==pd){
                store[i]=null;
                orderProductInStroe();
            }
            this.countProduct--;
        }

    @Override
    public void banCustomer(CustomerAccount customerAccount) {
        customerAccount.setAccountStatus(AccountStatus.ban);
    }

    @Override
    public void unBanCustomer(CustomerAccount customerAccount) {
        customerAccount.setAccountStatus(AccountStatus.active);
    }

    @Override
    public void addMoney(CustomerAccount customerAccount,int money) {
        customerAccount.addMoney(money);
    }
//    
    @Override
    public void listCustomer(){
        System.out.println("***** List of Customer *****");
        for (int i = 0;i < customer.length ; i++ )
            if(customer[i] != null){
                System.out.println(customer[i].toString());
            }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return "Store{" + "store=" + store + '}';
    }
    
}
