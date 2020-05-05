package Service;

import Account.AccountStatus;
import Store.Store;
import Account.AdminAccount;
import Account.CustomerAccount;
import ModelDatabase.AdminAccountDB;
import ModelDatabase.CustomerAccountDB;
import ModelDatabase.GeneralList;
import ModelDatabase.PersonDB;
import ModelDatabase.ProductDB;
import ModelDatabase.ProductInCartDB;
import ModelDatabase.StorageDB;
import ModelDatabase.StoreDB;
import ModelInterface.AdminInterface;
import ModelInterface.CustomerInterface;
import ModelInterface.PersonInterface;
import ModelInterface.ProductInCartInterface;
import ModelInterface.ProductInterface;
import ModelInterface.StorageInterface;
import ModelInterface.StoreInterface;
import Person.Person;
import Product.Product;
import Product.ProductStatus;
import java.time.LocalDate;
import java.util.Scanner;

public class StoreServiceDB {
    private static AdminAccount nowAdminAccount;
    private static CustomerAccount nowCustomerAccount;
    private static Store gameStore;
    private static ProductInterface pdb = new ProductDB();
    private static ProductInCartInterface picd = new ProductInCartDB();
    private static StorageInterface pisd = new StorageDB();
    private static StoreInterface sd =new StoreDB();
    private static AdminInterface ad = new AdminAccountDB();
    private static PersonInterface pd = new PersonDB();
    static CustomerInterface cad = new CustomerAccountDB();
    private static final Scanner sc = new Scanner(System.in);
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    

    public static void main(String[] args) {
        //System.out.println(ad.findById("a1").getPassword());
        setUpStore();
        firstMenu();
    }
    
    public static void setUpStore(){
        nowAdminAccount = ad.findById("a1");
        gameStore = sd.findByName("PokeShop");
    }
    
    public static void firstMenu(){
        try{
        int menuId;
        do {
            System.out.println("<<Welcome To "+gameStore.getStoreName()+ " >>");
            System.out.println("1. Log-In Customer ");
            System.out.println("2. Log-In Admin ");
            System.out.println("3. Register ");
            System.out.println("0. Exit ");
            System.out.print("Enter your menu : ");
            menuId = sc.nextInt();
            System.out.println("---------------------------------------------------------------------------------------------------");
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    logInCustomer();
                    break;
                case 2:
                    logInAdmin();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    viewCustomer();
                    break;
            }
        } while (menuId != 0);
        System.out.println("Thank You !");
        }catch (Exception e){
            System.out.println("\nPlease Enter Only 0-2");
        }
    }
    
    public static void  logInCustomer(){
        try{
        String menuLogInID;
        String menuLogInPassword;
        System.out.println("***** Log-In Menu *****");
        System.out.print("Please Enter Your UserID : ");
        menuLogInID = sc.next();
        System.out.print("Please Enter Your Password : ");
        menuLogInPassword=sc.next();
        if((menuLogInID == null ? cad.findById(menuLogInID).getUserID() == null : menuLogInID.equals(cad.findById(menuLogInID).getUserID()))&&(menuLogInPassword == null ? cad.findById(menuLogInID).getPassword() == null : menuLogInPassword.equals(cad.findById(menuLogInID).getPassword()))){
            if(null!=cad.findById(menuLogInID).getAccountStatus())switch (cad.findById(menuLogInID).getAccountStatus()) {
                case active:
                    nowCustomerAccount = cad.findById(menuLogInID);
                    customerMenu();
                    break;
                case closed:
                    System.out.println("This Account Has Been Closed.");
                    break;
                case ban:
                    System.out.println("This Account Has Been Ban.");
                    break;
                default:
                    break;
            }
        }
        else {System.out.println("Log-In Fail. Please Try Again.");}
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void  logInAdmin(){
        try{
        String menuLogInID;
        String menuLogInPassword;
        System.out.println("***** Log-In Menu *****");
        System.out.print("Please Enter Your UserID : ");
        menuLogInID = sc.next();
        System.out.print("Please Enter Your Password : ");
        menuLogInPassword=sc.next();
        if((menuLogInID == null ? ad.findById(menuLogInID).getUserID() == null : menuLogInID.equals(ad.findById(menuLogInID).getUserID()))&&(menuLogInPassword == null ? ad.findById(menuLogInID).getPassword() == null : menuLogInPassword.equals(ad.findById(menuLogInID).getPassword()))){
                    adminMenu();
        }else {System.out.println("Log-In Fail. Please Try Again.");}
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void register(){
        try{
        String registerID;
        String registerPassword;
        String name; 
        String address; 
        int dateOfBirth; 
        int monthOfBirth; 
        int yearOfBirth; 
        String email; 
        String phone;
        System.out.println("***** Register Menu *****");
        System.out.print("Please Enter Your Name : ");
        name = sc.next();
        System.out.print("Please Enter Your Address : ");
        address=sc.next();
        System.out.print("Please Enter Your Birth Date (1-31) : ");
        dateOfBirth = sc.nextInt();
        System.out.print("Please Enter Your Birth Month (1-12) : ");
        monthOfBirth = sc.nextInt();
        System.out.print("Please Enter Your Birth Year : ");
        yearOfBirth = sc.nextInt();
        System.out.print("Please Enter Your Email : ");
        email=sc.next();
        System.out.print("Please Enter Your Phone Number : ");
        phone=sc.next();
        System.out.print("Please Enter Your UserID : ");
        registerID = sc.next();
        System.out.print("Please Enter Your Password : ");
        registerPassword=sc.next();
        Person p = new Person(name, address, LocalDate.of(yearOfBirth, monthOfBirth, dateOfBirth), email, phone);
        CustomerAccount c = new CustomerAccount(registerID, registerPassword, p);
        pd.insert(p);
        cad.insert(gameStore, c);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println("\nSorry Some Thing Wrong.");}
    }
    
    public static void adminMenu() {
        try{
        int adminmenu;
        do {
            System.out.println("***** Admin Menu *****");
            System.out.println("1. View Shop");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. List Customers");
            System.out.println("5. Ban Customer");
            System.out.println("6. Unban Customer");
            System.out.println("7. Add Money");
            System.out.println("0. Back");
            System.out.print("Enter your menu : ");
            adminmenu = sc.nextInt();
           
            System.out.println("---------------------------------------------------------------------------------------------------");
            switch (adminmenu) {
                case 0:
                    System.out.println("Log Out Success.");
                    break;
                case 1:
                    viewShop();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    viewCustomer();
                    break;
                case 5:
                    banCustomer();
                    break;
                case 6:
                    unBanCustomer();
                    break;
                case 7:
                    addMoney();
                    break;
            }
        } while (adminmenu != 0);
        }catch (Exception e){
            System.out.println("Please Enter Only 0-7");
        }
    }
    public static void viewCustomer(){
        System.out.println("\nList all Customer");
                    GeneralList<CustomerAccount> perd = cad.getAll();
                    int i = 1;
                    for (CustomerAccount temp : perd) {
                    System.out.println(i++ + ". " + temp);
                    }
    }
    
    public static void addProduct() {
        try{
        int price;
         System.out.println("----- Add Product -----");
         System.out.print("Add Product ID : ");
         String productCode = sc.next();
         System.out.print("Add Product Name : ");
         String productName = sc.next();
         System.out.print("Add Description : ");
         String description = sc.next();
         System.out.print("Add Price : ");
         price = sc.nextInt();
         Product np = new Product(productCode, productName, description, price);
         np.setProductStatus(ProductStatus.onSale);
         pdb.insert(gameStore, np);
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void removeProduct() {
        try{
        String productCode;
        System.out.println("----- Remove Product -----");
        System.out.print("Please Enter Removing Product ID : ");
        productCode = sc.next();
        pdb.delete(pdb.findById(productCode));
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void banCustomer() {
        try{
        String cusId;
        System.out.println("----- Ban Customer -----");
        System.out.print("Please Enter Customer ID : ");
        cusId = sc.next();
        CustomerAccount c1 = cad.findById(cusId);
        c1.setAccountStatus(AccountStatus.ban);
        cad.update(gameStore, c1);
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void unBanCustomer() {
        try{
        String cusId;
        System.out.println("----- Unban Customer -----");
        System.out.print("Please Enter Customer ID : ");
        cusId = sc.next();
        CustomerAccount c1 = cad.findById(cusId);
        c1.setAccountStatus(AccountStatus.active);
        cad.update(gameStore, c1);
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void addMoney() {
        try{
        int money;
        String cusId;
        System.out.println("----- Add Money -----");
        System.out.print("Please Enter Customer ID : ");
        cusId = sc.next();
        System.out.print("Please Enter the money : ");
        money = sc.nextInt();
        CustomerAccount c1 = cad.findById(cusId);
        gameStore.addMoney(c1, money);
        cad.update(gameStore, c1);
        System.out.println("Add "+ money + " Wallet to " + cusId +" Complete" );
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void customerMenu(){
        try{
        int menuId;
        do {
            System.out.println("***** Customer Menu *****");
            System.out.println("1. View Shop");
            System.out.println("2. Add Product To Cart");
            System.out.println("3. Remove Product From Cart");
            System.out.println("4. Check Product Cart");
            System.out.println("5. Buy Product");
            System.out.println("6. Check Product In Storage");
            System.out.println("7. Check Money");
            System.out.println("0. Back ");
            System.out.print("Enter your menu : ");
            menuId = sc.nextInt();
            
            System.out.println("---------------------------------------------------------------------------------------------------");
            switch (menuId) {
                case 0:
                    nowCustomerAccount = null;
                    System.out.println("Log Out Success.");
                    break;
                case 1:
                    viewShop();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    removeProductFromCart();
                    break;
                case 4:
                    checkCart();
                    break;
                case 5:
                    buyProduct();
                    break;
                case 6:
                    checkStorage();
                    break;
                case 7:
                    System.out.println("Your Money : "+cad.findById(nowCustomerAccount.getUserID()).getMoney());
                    break;
            }
        } while (menuId != 0);
        }catch (Exception e){
            System.out.println("Please Enter Only 0-7");
        }
    }
    
    public static void checkCart(){
        System.out.println("\nList all product");
        GeneralList<Product> prods = picd.getAll(nowCustomerAccount);
        int i = 1;
        for (Product temp : prods) {
            System.out.println(i++ + ". " + temp);
        }
    }
    
    public static void checkStorage(){
        System.out.println("\nList all product");
        GeneralList<Product> prods = pisd.getAll(nowCustomerAccount);
        int i = 1;
        for (Product temp : prods) {
            System.out.println(i++ + ". " + temp);
        }
    }
    
    public static void viewShop(){
        System.out.println("\nList all product");
        GeneralList<Product> prods = pdb.getAll();
        int i = 1;
        for (Product temp : prods) {
            System.out.println(i++ + ". " + temp);
        }
    }
    
    public static void addProductToCart(){
        try{
        String productCode;
        System.out.println("----- Add Product To Cart -----");
        System.out.print("Please Enter Product ID : ");
        productCode = sc.next();
        Product ap = pdb.findById(productCode);
        picd.insert(nowCustomerAccount, ap);
        nowCustomerAccount.addCountCart();
        cad.update(gameStore, nowCustomerAccount);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void removeProductFromCart(){
        try{
        String productCode;
        System.out.println("----- Remove Product From Cart -----");
        System.out.print("Please Enter Product ID : ");
        productCode = sc.next();
        Product ap = pdb.findById(productCode);
        picd.delete(nowCustomerAccount, ap);
        CustomerAccount nc = cad.findById(nowCustomerAccount.getUserID());
        nc.deCountCart();
        cad.update(gameStore, nc);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public static void buyProduct(){
        try{
        String productCode;
        System.out.println("----- Buy Product  -----");
        System.out.print("Please Enter Product ID : ");
        productCode = sc.next();
        Product ap = picd.findById(nowCustomerAccount,productCode);
        CustomerAccount nc = cad.findById(nowCustomerAccount.getUserID());
        picd.delete(nc, ap);
        nc.deCountCart();
        if(nc.prePay(ap.getPrice())){
        nc.pay(ap.getPrice());
        pisd.insert(nc, ap);
        nc.addCountStorage();
        cad.update(gameStore, nc);
        }else{System.out.println("Your Money Is Not Enough.");}
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
}
