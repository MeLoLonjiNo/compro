package Service;


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
    
    
    
    
    
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    
    @Override
    public void viewShop() {
        //Array.short(store,new Sortbyroll());
        for (int i = 0; i < store.length ; i++) {
            if(store[i]!=null){
            System.out.println(store[i]);
            //System.out.println("No."+(i+1)+" "+store[i]);
            }
        }
    }

    @Override
    public void addToCart(String pdc) { 
        for (int i = 0; i < store.length; i++) {
            if(pdc.equals(store[i].getProductCode())){
                Product pd = store[i];
                
            }break;
        }
    }

    @Override
    public void removeFromCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String banCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String unBanCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
