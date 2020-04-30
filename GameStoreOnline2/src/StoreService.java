
import Account.AccountPriority;
import Account.AdminAccount;
import Account.CustomerAccount;
import Person.Person;
import Product.Product;
import Service.Store;
import java.time.LocalDate;
import java.util.Scanner;


public class StoreService {
    private AdminAccount adminAccount;
    private CustomerAccount customerAccount;
    private Product[] Store;
    private Store gameStore;
    private static final Scanner sc = new Scanner(System.in);
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    
    public StoreService(String storeName, AdminAccount admin){
        this.gameStore = new Store("PokeShop", admin);
        this.adminAccount = admin;
    }

    public static void main(String[] args) {
        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        Product pd03 = new Product("PD03","Dota2","GG game",0);
        Product pd04 = new Product("PD04","Dead By Daylight","Game price 300 Bug 3Million",300);
        Product testStore[] = {pd01, pd02, pd03};
        Person person01 = new Person("Arzeus", "Pokemon Universe", LocalDate.of(1, 1, 1), "Azeus@mail.com", "0000000000");
        AdminAccount admin01 = new AdminAccount("Admin01","12345",person01);
        StoreService StoreService1 = new StoreService("Poke Shop", admin01);
        StoreService1.firstMenu();
    }
   
    public void firstMenu(){
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
    }
    
    public void  logIn(){
        String menuLogInID;
        String menuLogInPassword;
        System.out.println("***** Log-In Menu *****");
        System.out.println("Please Enter Your UserID : ");
        menuLogInID = sc.next();
        System.out.println("Please Enter Your Password : ");
        menuLogInPassword=sc.next();
        
        if(gameStore.logInVer2(menuLogInID, menuLogInPassword)==AccountPriority.Customer){
            this.customerAccount=gameStore.codeToAccount(menuLogInID);
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
    }
    
    public void register(){
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
    }
    
    public void adminMenu() {
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
                    break;
                case 1:
                    gameStore.viewShop();
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
    }
    
    public void addProduct() {
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
        
    }
    
    public void removeProduct() {
        String productCode;
        System.out.println("----- Remove Product -----");
        System.out.println("Please Enter Removing Product ID : ");
        productCode = sc.next();
        gameStore.removeProduct(productCode);
        //System.out.println("Remove Product Complete" );
        //System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void banCustomer() {
        String cusId;
        System.out.println("----- Ban Customer -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        gameStore.banCustomer(gameStore.codeToAccount(cusId));
        System.out.println("Ban " + cusId + " Complete");
        //System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void unBanCustomer() {
        String cusId;
        System.out.println("----- Unban Customer -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        gameStore.unBanCustomer(gameStore.codeToAccount(cusId));
        System.out.println("Unban " + cusId + " Complete");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void addMoney() {
        int money;
        String cusId;
        System.out.println("----- Add Money -----");
        System.out.println("Please Enter Customer ID : ");
        cusId = sc.next();
        System.out.println("Please Enter the money : ");
        money = sc.nextInt();
        gameStore.addMoney(gameStore.codeToAccount(cusId), money);
        System.out.println("Add "+ money + " Wallet to" + cusId +" Complete" );
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void customerMenu(){
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
                    System.out.println("");
                    break;
                case 1:
                    gameStore.viewShop();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    removeProductFromCart();
                    break;
                case 4:
                    gameStore.checkCart(customerAccount);
                    break;
                case 5:
                    buyProduct();
                    break;
                case 6:
                    gameStore.checkStorage(customerAccount);
                    break;
                case 7:
                    gameStore.checkMoney(customerAccount);
                    break;
            }
        } while (menuId != 0);
    }
    
    public void addProductToCart(){
        String productCode;
        System.out.println("----- Add Product To Cart -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.addToCart(this.customerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void removeProductFromCart(){
        String productCode;
        System.out.println("----- Remove Product From Cart -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.removeFromCart(this.customerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    public void buyProduct(){
        String productCode;
        System.out.println("----- Buy Product  -----");
        System.out.println("Please Enter Product ID : ");
        productCode = sc.next();
        gameStore.buy(this.customerAccount, productCode);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
}