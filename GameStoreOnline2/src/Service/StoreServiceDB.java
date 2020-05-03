
package Service;

import Store.Store;
import Account.AccountPriority;
import Account.AdminAccount;
import Account.CustomerAccount;
import ModelDatabase.GeneralList;
import ModelDatabase.ProductDB;
import ModelDatabase.StoreDB;
import Person.Person;
import Product.Product;
import java.time.LocalDate;
import java.util.Scanner;

public class StoreServiceDB {
    private AdminAccount adminAccount;
    private CustomerAccount nowCustomerAccount;
    private static Product[] Store;
    private Store gameStore;
    private static StoreDB storeDB;
    private static ProductDB productDB;
    private static final Scanner sc = new Scanner(System.in);
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    
    public StoreServiceDB(String storeName, AdminAccount admin){
        this.gameStore = new Store("PokeShop", admin);
        this.adminAccount = admin;
    }

    public static void main(String[] args) {
        Person p0 = new Person("Arzeus", "Pokemon Universe", LocalDate.of(1, 1, 1), "Azeus@mail.com", "0000000000");
        AdminAccount admin01 = new AdminAccount("Admin01","12345",p0);
        StoreService StoreService1 = new StoreService("Poke Shop", admin01);
        //StoreService1.insertTest();
        StoreService1.firstMenu();
    }
    
    public void insertTest(){
        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        Product pd03 = new Product("PD03","Dota2","GG game",0);
        Product pd04 = new Product("PD04","Dead By Daylight","Game price 300 Bug 3Million",300);
        Person p0 = new Person("Arzeus", "Pokemon Universe", LocalDate.of(1, 1, 1), "Azeus@mail.com", "0000000000");
        Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        Person p2= new Person("Jirayut", "Bangkok", LocalDate.of(2001, 1, 18), "jirayut.bal4ncez@mail.kmutt.ac.th", "0900000000");
        Person p3= new Person("Nippit", "Bangkok", LocalDate.of(2001, 2, 6), "nippit.c@mail.kmutt.ac.th", "0800000000");
        AdminAccount admin01 = new AdminAccount("Admin01","12345",p0);
        CustomerAccount MeLo=new CustomerAccount("MeLo","12345",p1);
        CustomerAccount Bal4ncez=new CustomerAccount("Bal4ncez","67890",p2);
        CustomerAccount Garnet_=new CustomerAccount("Garnet_","54321",p3);
        gameStore.addProduct(pd01);
        gameStore.addProduct(pd02);
        gameStore.addProduct(pd03);
        gameStore.addProduct(pd04);
        gameStore.addCustomerAccuont(MeLo);
        gameStore.addCustomerAccuont(Bal4ncez);
        gameStore.addCustomerAccuont(Garnet_);
        this.nowCustomerAccount=MeLo;
    }
    
    public void firstMenu(){
        try{
        int menuId;
        do {
            System.out.println("<<Welcome To "+gameStore.getStoreName()+ " >>");
            System.out.println("1. Log-In ");
            System.out.println("2. Register ");
            System.out.println("0. Exit ");
            System.out.print("Enter your menu : ");
            menuId = sc.nextInt();
            System.out.println("---------------------------------------------------------------------------------------------------");
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    logIn();
                    break;

                case 2:
                    register();
                    break;
                case 3:
                    gameStore.listCustomer();
                    break;
            }
        } while (menuId != 0);
        System.out.println("Thank You !");
        }catch (Exception e){
            System.out.println("\nPlease Enter Only 0-2");
        }
    }
    
    public void  logIn(){
        try{
        String menuLogInID;
        String menuLogInPassword;
        System.out.println("***** Log-In Menu *****");
        System.out.println("Please Enter Your UserID : ");
        menuLogInID = sc.next();
        System.out.println("Please Enter Your Password : ");
        menuLogInPassword=sc.next();
        
        if(gameStore.logInVer2(menuLogInID, menuLogInPassword)==AccountPriority.Customer){
            this.nowCustomerAccount=gameStore.codeToAccount(menuLogInID);
            customerMenu();
        }
        else if(gameStore.logInVer2(menuLogInID, menuLogInPassword)==AccountPriority.Admin){
            adminMenu();
        }
        else if(gameStore.logInVer2(menuLogInID, menuLogInPassword)==AccountPriority.Ban){
            System.out.println(RED+"This Account Has Been Ban."+BLACK);
        }
        else if(gameStore.logInVer2(menuLogInID, menuLogInPassword)==AccountPriority.Fail){
            System.out.println(RED+"Log-In Failed" + BLACK);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void register(){
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
        System.out.println("Please Enter Your Name : ");
        name = sc.next();
        System.out.println("Please Enter Your Address : ");
        address=sc.next();
        System.out.println("Please Enter Your Birth Date (1-31) : ");
        dateOfBirth = sc.nextInt();
        System.out.println("Please Enter Your Birth Month (1-12) : ");
        monthOfBirth = sc.nextInt();
        System.out.println("Please Enter Your Birth Year : ");
        yearOfBirth = sc.nextInt();
        System.out.println("Please Enter Your Email : ");
        email=sc.next();
        System.out.println("Please Enter Your Phone Number : ");
        phone=sc.next();
        System.out.println("Please Enter Your UserID : ");
        registerID = sc.next();
        System.out.println("Please Enter Your Password : ");
        registerPassword=sc.next();
        Person p = new Person(name, address, LocalDate.of(yearOfBirth, monthOfBirth, dateOfBirth), email, phone);
        CustomerAccount c = new CustomerAccount(registerID, registerPassword, p);
        gameStore.addCustomerAccuont(c);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println("\nSorry Some Thing Wrong.");}
    }
    
    public void adminMenu() {
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
                    gameStore.listCustomer();
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
    
    public void addProduct() {
        try{
        String productCode;
        String productName;
        String description;
        int price;
         System.out.println("----- Add Product -----");
         System.out.println("Add Product ID : ");
         productCode = sc.next();
         System.out.println("Add Product Name : ");
         productName = sc.next();
         System.out.println("Add Description : ");
         description = sc.next();
         System.out.println("Add Price : ");
         price = sc.nextInt();
         gameStore.addProduct(productCode, productName, description, price);
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void removeProduct() {
        try{
        String productCode;
        System.out.println("----- Remove Product -----");
        System.out.println("Please Enter Removing Product ID : ");
        productCode = sc.next();
        gameStore.removeProduct(productCode);
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void banCustomer() {
        try{
        String cusId;
        System.out.println("----- Ban Customer -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        gameStore.banCustomer(gameStore.codeToAccount(cusId));
        System.out.println("Ban " + cusId + " Complete");
        //System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void unBanCustomer() {
        try{
        String cusId;
        System.out.println("----- Unban Customer -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        gameStore.unBanCustomer(gameStore.codeToAccount(cusId));
        System.out.println("Unban " + cusId + " Complete");
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void addMoney() {
        try{
        int money;
        String cusId;
        System.out.println("----- Add Money -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        System.out.println("Please Enter the money : ");
        money = sc.nextInt();
        gameStore.addMoney(gameStore.codeToAccount(cusId), money);
        System.out.println("Add "+ money + " Wallet to " + cusId +" Complete" );
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void customerMenu(){
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
                    this.nowCustomerAccount = null;
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
                    gameStore.checkCart(nowCustomerAccount);
                    break;
                case 5:
                    buyProduct();
                    break;
                case 6:
                    gameStore.checkStorage(nowCustomerAccount);
                    break;
                case 7:
                    gameStore.checkMoney(nowCustomerAccount);
                    break;
            }
        } while (menuId != 0);
        }catch (Exception e){
            System.out.println("Please Enter Only 0-7");
        }
    }
    
    public void viewShop(){
        System.out.println("\nList all product");
        GeneralList<Product> prods = productDB.getAll();
        int i = 0;
        for (Product temp : prods) {
            System.out.println(i++ + ". " + temp);
        }
    }
    
    public void addProductToCart(){
        try{
        String productCode;
        System.out.println("----- Add Product To Cart -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.addToCart(this.nowCustomerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void removeProductFromCart(){
        try{
        String productCode;
        System.out.println("----- Remove Product From Cart -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.removeFromCart(this.nowCustomerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
    public void buyProduct(){
        try{
        String productCode;
        System.out.println("----- Buy Product  -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.buy(this.nowCustomerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
        }catch (Exception e){ System.out.println(" Sorry Some Thing Wrong.");}
    }
    
}
