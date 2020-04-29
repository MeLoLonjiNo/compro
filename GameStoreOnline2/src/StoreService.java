
import Account.AdminAccount;
import Account.CustomerAccount;
import Person.Person;
import Product.Product;
import Service.Store;
import java.time.LocalDate;
import java.util.Scanner;


public class StoreService {
    private AdminAccount adminAccount;
//    private CustomerAccount[] customerAccount;
    private Product[] Store;
    private Store gameStore;
    private static final Scanner sc = new Scanner(System.in);
    
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
        if(gameStore.logIn(menuLogInID, menuLogInPassword)==1){
            System.out.println("customerMenu");
            //customerMenu();
        }
        else if(gameStore.logIn(menuLogInID, menuLogInPassword)==2){
            System.out.println("adminMenu");
            //adminMenu();
        }
        else if(gameStore.logIn(menuLogInID, menuLogInPassword)==-1){
            System.out.println("Log-In Failed");
        }
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
       
    }
    
}
