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
    private AdminAccount[] admin;
    private CustomerAccount[] customer;
    private int countCustomer;
    private int countProduct;

    public Store(int maxCapacity) {
        this.store = new Product[maxCapacity];
    }
    
    public int getCustomerIndex(CustomerAccount customer) {
        for (int i = 0; i < countCustomer; i++) {
            if (this.customer[i].equals(customer)) {
                return i;
            }
        }
        return -1;
    }
    
    public int getProductIndex(Product productStore){
        for (int i = 0; i < countProduct; i++) {
            if(store[i].equals(productStore)){
                return i;
            }
        }
        return -1;
    }
    
    public Product codeToObject(String pdc){
        if(pdc == null) {return null;}
        for (int i = 0; i < store.length; i++) {
            if (pdc.equals(store[i].getProductCode())){
                return store[i];
            }break;
        }
        return null;
    }
    
    public void addToCart(CustomerAccount customer,Product addingProduct) { 
       // int customerIndex = getCustomerIndex(customer);
        //int productIndex = getProductIndex(codeToObject(pdc));
        customer.addProductToCart(addingProduct);
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    
    @Override
    public void viewShop() {
        System.out.println("***** Welcome to ReZoNance Game Store Shop *****");
        for (int i = 0; i < store.length ; i++) {
            if(store[i]!=null){
            System.out.println(store[i]);
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    @Override
    public void addToCart(CustomerAccount customer,String pdc) { 
        //int customerIndex = getCustomerIndex(customer);
        //int productIndex = getProductIndex(codeToObject(pdc));
        customer.addProductToCart(codeToObject(pdc));
    }

    @Override
    public void removeFromCart(CustomerAccount customer,String pdc) {
        customer.deleteProductInCart(codeToObject(pdc));
    }

    @Override
    public void buy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkCart() {
        
    }

    @Override
    public boolean register() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    
    @Override
    public void addProduct(Product pd) {
        int count = 0;
        for (int i = 0; i<store.length; i++) {
            if(store[i]==null){
                count = i;
                break;
            }
        }
        this.store[count]=pd;
//        for (int i = 0; i < store.length; i++) {
//            if(store[i]!=null){ this.store[i]=pd; }
//        }
    }

    @Override
    public void removeProduct(Product pd){
        int count = 0;
        for (int i = 0; i<store.length; i++) {
            if(store[i]==pd){
                count = i;
                break;
            }
        }
        this.store[count]=null;
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
    public String addMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return "Store{" + "store=" + store + '}';
    }
    
}
