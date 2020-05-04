
import Account.AdminAccount;
import Account.CustomerAccount;
import ModelDatabase.AdminAccountDB;
import ModelDatabase.PersonDB;
import ModelDatabase.StoreDB;
import ModelInterface.AdminInterface;
import ModelInterface.PersonInterface;
import ModelInterface.StoreInterface;
import Person.Person;
import Store.Store;
import java.time.LocalDate;
import java.util.Scanner;


public class Gn_Test {
        static Person p0= new Person("Azeus", "The Land of God", LocalDate.of(1, 1, 1), "Azeus@mail.pokedex", "0123456789");
        static AdminAccount a1 = new AdminAccount("Azeus","10130" , p0);
        static Store store = new Store("PokeShop", a1);
        static Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        static CustomerAccount MeLo=new CustomerAccount("c1","12345",p1);
        static Person p2= new Person("Jirayut", "Bangkok", LocalDate.of(2001, 1, 18), "jirayut.bal4ncez@mail.kmutt.ac.th", "0900000000");
        static CustomerAccount Bal4ncez=new CustomerAccount("c2","12345",p2);
        static Person p3= new Person("Nippit", "Bangkok", LocalDate.of(2001, 2, 6), "nippit.c@mail.kmutt.ac.th", "0800000000");
        static CustomerAccount Garnet_=new CustomerAccount("c3","12345",p3);
        
        static Scanner input = new Scanner(System.in);
        static AdminInterface ad = new AdminAccountDB();
        static PersonInterface p = new PersonDB();
        static StoreInterface s = new StoreDB();
        
//        static ProductInCartInterface picd = new ProductInCartDB();
//        static StorageInterface pisd = new StorageDB();
        
        public static void main(String[] args) {
            
//            insertAdmin();
            updateAdmin();
    }
        
        
        public static void insertAdmin() {
            System.out.println("\nInsert Admin");
            System.out.print("Press Enter Adminid :");
            String admid = input.nextLine();
            System.out.print("Press Enter Password :");
            String admpass = input.nextLine();
            AdminAccount adm = new AdminAccount(admid ,admpass ,p0);
            ad.insert(adm ,store);       
    }
        
        public static void updateAdmin() {
            System.out.println("\nInsert Admin");
            System.out.print("Press Enter Adminid :");
            String admid = input.nextLine();
            System.out.print("Press Enter Password :");
            String admpass = input.nextLine();
            AdminAccount adm = new AdminAccount(admid ,admpass ,p0);
            ad.insert(adm ,store);
    }
}
