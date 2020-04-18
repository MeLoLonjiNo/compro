
public class Store implements CustomerService{
    private String storeName;
    private Product store[];
    private AdminAccount admin[];
    private CustomerAccount customer[];
    private int count;

    public void addProduct(Product pd){
        for (int i = 0; i < store.length; i++) {
            if(store[i]!=null){ this.store[i]=pd; }
        }
        
    }
    
    @Override
    public String viewShop() {
        for (int i = 0; i < store.length ; i++) {
            System.out.println("No."+(i+1 )+store[i].toString());
        }return "_______________________________________";
    }

    @Override
    public String addToCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeFromCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String buy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String checkCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean register() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
