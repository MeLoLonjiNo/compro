
import Account.AdminAccount;
import Account.CustomerAccount;
import ModelDatabase.CustomerAccountDB;
import ModelDatabase.GeneralList;
import ModelDatabase.ProductDB;
import ModelDatabase.StorageDB;
import ModelInterface.CustomerInterface;
import ModelInterface.ProductInterface;
import ModelInterface.StorageInterface;
import Person.Person;
import Product.Product;
import Store.Store;
import java.time.LocalDate;
import java.util.Scanner;

public class Mint_Test {
        static  Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        static  Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        static  Product pd03 = new Product("PD03","Dota2","GG game",0);
        static  Product pd04 = new Product("PD04","Dead By Daylight","Game price 300 Bug 3Million",300);
        static  Product pd21 = new Product("PD21","Dead By Daylight","Game price 300 Bug 3Million",300);
        static  Person p0 = new Person("Arzeus", "Pokemon Universe", LocalDate.of(1, 1, 1), "Azeus@mail.com", "0000000000");
        static  Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        static  Person p2= new Person("Jirayut", "Bangkok", LocalDate.of(2001, 1, 18), "jirayut.bal4ncez@mail.kmutt.ac.th", "0900000000");
        static  Person p3= new Person("Nippit", "Bangkok", LocalDate.of(2001, 2, 6), "nippit.c@mail.kmutt.ac.th", "0800000000");
        static  AdminAccount admin01 = new AdminAccount("a1","12345",p0);
        static  CustomerAccount MeLo=new CustomerAccount("c1","12345",p1);
        static  CustomerAccount Bal4ncez=new CustomerAccount("c2","67890",p2);
        static  CustomerAccount Garnet_=new CustomerAccount("c3","54321",p3);
        static  Store store = new Store("PokeShop", admin01);
        
        static Scanner input = new Scanner(System.in);
        static CustomerInterface cad = new CustomerAccountDB();
        static ProductInterface pd = new ProductDB();
        static StorageInterface srd = new StorageDB();
        
        public static void main(String[] args) {
            insertStorage();
        
        
        }
        
        public static void insertStorage(){
            System.out.println("\nInsert Storage");
            System.out.print("Enter customer id : ");
            int cusid = input.nextInt();
            System.out.print("Enter product id : ");
            String proid = input.next();
            CustomerAccount c = cad.findById(cusid);
            Product p = pd.findById(proid);
            srd.insert(c, p);
            
        }
}
