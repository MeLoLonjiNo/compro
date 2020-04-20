
public class Store implements CustomerService,AdminService{
    private String storeName;
    private Product[] store;
    private AdminAccount[] admin;
    private CustomerAccount[] customer;

    public Store(int maxCapacity) {
        this.store = new Product[maxCapacity];
        
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
    public void addToCart(String productCode) {
        for (int i = 0; i < store.length; i++) {
            if(productCode.equalsIgnoreCase(store[i].getProductCode())){
                Product pd = store[i];
                CustomerAccount.addToCart(pd);     
            }
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
        CustomerAccount.checkCart();
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
