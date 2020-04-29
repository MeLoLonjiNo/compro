package Service;


import Account.AccountPriority;
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

    public String getStoreName() {
        return storeName;
    }
    
//    public CustomerAccount getCustomerAccountByID(String customerID){
//        if(customerID!=null&&customerID!=""){
//            
//        }
//        return null;
//    }

    public int getCustomerIndex(CustomerAccount customer) {
        if(customer != null){
        for (int i = 0; i < countCustomer; i++) {
            if (this.customer[i].equals(customer)) {
                return i;
             }
            }
        }
        return -1;
    }
    
    public boolean haveCustomer(CustomerAccount cus){
            int i = getCustomerIndex(cus);
            if(i==-1){return false;}
            else{return true;} 
    }
    
    public void addCustomerAccuont(CustomerAccount customer){
        if(haveCustomer(customer)){System.out.println("Sorry... Now Have This Account Already");
         System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
        for (int i = 0; i<this.customer.length; i++) {
            if(this.customer[i]==null){
                this.customer[i]=customer;
                break;
            }
        }
        this.countCustomer++;}
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
    
    public CustomerAccount codeToAccount(String cusID){
        if(cusID == null||cusID=="") {return null;}
        else{
        for (int i = 0; i < customer.length; i++) {
            if (cusID.equals(customer[i].getUserID())){
                return customer[i];
            }
        }
        return null;
        }
    }
    
    public Product codeToObject(String pdc){
        if(pdc == null) {return null;}
        else{
        for (int i = 0; i < store.length; i++) {
            if (pdc.equalsIgnoreCase(store[i].getProductCode())){
                return store[i];
            }
        }
        return null;
        }
    }
 
    @Override
    public void addToCart(CustomerAccount customer,Product addingProduct) { 
        if(haveProductInStore(addingProduct)){
            customer.addProductToCart(addingProduct);
        }else {System.out.println("Sorry... Not Have "+addingProduct.getProductName()+" Product In Store.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
    }
    
    @Override
    public void removeFromCart(CustomerAccount customer,Product deletingProduct) {
        customer.deleteProductInCart(deletingProduct);
    }
   
    public void orderProductInStroe(){
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
    
    public int logIn(String id,String password){
        if(id!=null && password!=null && id!="" && password!=""){
            for (int i = 0; i < countCustomer; i++) {
                if(id.equals(admin.getUserID())&&password.equals(admin.getPassword()))
                    {return 2;}
                else if(id.equals(customer[i].getUserID()) && password.equals(customer[i].getPassword()))
                    {return 1;}
                else{return -1;}
                }   
        }
            return -1;
    }
    
    public AccountPriority logInVer2 (String id,String password){
        if(id!=null && password!=null && id!="" && password!=""){
            for (int i = 0; i < 100; i++) {
                if(id.equals(admin.getUserID())&&password.equals(admin.getPassword()))
                    {return AccountPriority.Admin;}
                else if(id.equals(customer[i].getUserID()) && password.equals(customer[i].getPassword()))
                    {return AccountPriority.Customer;}
                else{return AccountPriority.Fail;}
                }   
        }return AccountPriority.Fail;
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
        try{
        Product addingpdc = codeToObject(pdc);
        if (addingpdc!=null){
            if(haveProductInStore(addingpdc)){
                customer.addProductToCart(addingpdc);
            }else {System.out.println("Sorry... Not Have "+pdc+" Product In Store.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
        }
        else {System.out.println("Sorry... Not Have "+pdc+" Product In Store.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
        }catch(NullPointerException n){
            System.out.println("Sorry... Not Have "+pdc+" Product In Store.");
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void removeFromCart(CustomerAccount customer,String pdc) {
        try{
            customer.deleteProductInCart(codeToObject(pdc));
        }catch(NullPointerException n){
            System.out.println("Not Have This Product In Your Cart.");
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void buy(CustomerAccount customer,Product buyingProduct) {
        if(buyingProduct==null){System.out.println("Buying Product Must Be Not Null.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
        if(haveProductInCart(customer,buyingProduct)){
            customer.buy(buyingProduct);
            checkMoney(customer);
        }else {System.out.println("Sorry...Please Add "+buyingProduct.getProductName()+" To Your Cart First.");
        System.out.println("---------------------------------------------------------------------------------------------------");}
        }
    }

    @Override
    public void checkMoney(CustomerAccount customer) {
        System.out.println("***** Your Maintaining Money *****");
        System.out.println("Money : " + customer.getMoney());
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    @Override
    public void checkCart(CustomerAccount customer) {
        customer.getProductInCart();
    }

    @Override
    public void checkStorage(CustomerAccount customer) {
        customer.getProductInStorage();
    }
     
    //---------------------------------------------------------------------------------------------------------------------------------------------// 
    
    @Override
     public void addProduct(String productCode , String productName , String description , int price) {
        Product pd = new Product(productCode, productName, description, price);
        if(haveProductInStore(pd)){System.out.println("Sorry... Now Have This Product Already");
         System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
        for (int i = 0; i<store.length; i++) {
            if(store[i]==null){
                store[i]=pd;
                break;
            }
        }
        this.countProduct++;}
    }
    
    @Override
    public void addProduct(Product pd) {
        if(haveProductInStore(pd)){System.out.println("Sorry... Now Have This Product Already");
         System.out.println("---------------------------------------------------------------------------------------------------");}
        else{
        for (int i = 0; i<store.length; i++) {
            if(store[i]==null){
                store[i]=pd;
                break;
            }
        }
        this.countProduct++;}
    }

    @Override
    public void removeProduct(Product pd){
        if(haveProductInStore(pd)){
        int i = getProductStoreIndex(pd);
            if(store[i]==pd){
                store[i]=null;
                orderProductInStroe();
            }
            this.countProduct--;}else{
            {System.out.println("Sorry... Not Have This Product In Store Yet.");
         System.out.println("---------------------------------------------------------------------------------------------------");}
            }
        }
    
    public void removeProduct(String productCode){
        Product pd = codeToObject(productCode);
        if(haveProductInStore(pd)){
        int i = getProductStoreIndex(pd);
            if(store[i]==pd){
                store[i]=null;
                orderProductInStroe();
            }
            this.countProduct--;}else{
            {System.out.println("Sorry... Not Have This Product In Store Yet.");
         System.out.println("---------------------------------------------------------------------------------------------------");}
            }
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
                System.out.println("No."+(i+1)+" "+customer[i].toString());
            }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return "Store{" + "store=" + store + '}';
    }
    
}
