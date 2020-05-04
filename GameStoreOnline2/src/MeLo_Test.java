
import Account.AdminAccount;
import Store.Store;
import Product.Product;
import Account.CustomerAccount;
import ModelDatabase.AdminAccountDB;
import ModelDatabase.GeneralList;
import ModelDatabase.PersonDB;
import ModelDatabase.ProductDB;
import ModelDatabase.ProductInCartDB;
import ModelDatabase.StorageDB;
import ModelDatabase.StoreDB;
import ModelInterface.AdminInterface;
import ModelInterface.PersonInterface;
import ModelInterface.ProductInCartInterface;
import ModelInterface.ProductInterface;
import ModelInterface.StorageInterface;
import ModelInterface.StoreInterface;
import Person.Person;
import Product.ProductStatus;
import java.time.LocalDate;
import java.util.Scanner;


public class MeLo_Test {
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
        static ProductInterface pdb = new ProductDB();
        static ProductInCartInterface picd = new ProductInCartDB();
        static StorageInterface pisd = new StorageDB();
        static StoreInterface sd =new StoreDB();
        static AdminInterface ad = new AdminAccountDB();
        static PersonInterface pd = new PersonDB();
    
         public static void main(String[] args) {
             //findProductInCartByID(MeLo);
        }
        
         
         
        
       
        
        
        //----------------------------------------------------Product------------------------------------------------------//
        public static void getProduct(){
        System.out.println("\nList all Product");
        GeneralList<Product> prod = pdb.getAll();
        int i = 1;
        for (Product temp : prod) {
            System.out.println(i++ + ". " + temp);
            }
        }
        public static void findProductByID(){
            System.out.println("\nFinding Product");
            System.out.print("Please Enter Product ID : ");
            String productID = input.nextLine();
            Product p = pdb.findById(productID);
        }
        
        public static void findProductByName(){
            System.out.println("\nFinding Product");
            System.out.print("Please Enter Product Name : ");
            String productID = input.nextLine();
            GeneralList<Product> prod = pdb.findByName(productID);
            int i = 1;
            for (Product temp : prod) {
            System.out.println(i++ + ". " + temp);
            }
        }
        
        public static void insertProduct(Store s){
            System.out.println("\nInsert Product");
            System.out.print("Add Product ID : ");
            String productCode = input.nextLine();
            System.out.print("Add Product Name : ");
            String productName = input.nextLine();
            System.out.print("Add Description : ");
            String productDes = input.nextLine();
            System.out.print("Add Price : ");
            int productPrice = input.nextInt();
            Product p = new Product(productCode, productName,productDes, productPrice );
            pdb.insert(s,p);
        }
        
        public static void deleteProduct(){
            System.out.println("\nDelete Product");
            System.out.print("Delete Product ID : ");
            String productCode = input.nextLine();
            Product p = pdb.findById(productCode);
            pdb.delete(p);
        }
        
        public static void updateProduct(Store s){
            System.out.println("\nUpdate Product");
            System.out.print("Update Product ID : ");
            String productCode = input.nextLine();
            System.out.print("Update Product Name : ");
            String productName = input.nextLine();
            System.out.print("Update Description : ");
            String productDes = input.nextLine();
            System.out.print("Update Price : ");
            int productPrice = input.nextInt();
            Product p = new Product(productCode, productName,productDes, productPrice );
            //p.setProductStatus(ProductStatus.onSale);
            pdb.update(s, p);
        }
        //---------------------------------------------------Store--------------------------------------------------------//
        public static void getStore(){
        System.out.println("\nList all Store");
        GeneralList<Store> s = sd.getAll();
        int i = 1;
        for (Store temp : s) {
            System.out.println(i++ + ". " + temp);
            }
        }
        
        public static void findStoreByName(){
            System.out.println("\nFinding Store");
            System.out.print("Please Enter Store Name : ");
            String StoreName = input.nextLine();
            Store s = sd.findByName(StoreName);
            System.out.println(s);
            }
    
        public static void insertStore(){
            System.out.println("\nInsert Product");
            System.out.print("Add Store Name : ");
            String storeName = input.nextLine();
            System.out.print("Add Admin ID : ");
            String aid = input.next();
            AdminAccount a = ad.findById(aid);
            Store s = new Store(storeName,a);
            sd.insert(s, a);
            //sd.insert(s, admin01);
        }
        
        public static void deleteStore(){
            System.out.println("\nDelete Product");
            System.out.print("Delete Store Name : ");
            String storeCode = input.nextLine();
            Store p = sd.findByName(storeCode);
            sd.delete(p);
        }
        
        public static void updateStore(Store s){
            System.out.println("\nUpdate Store");
            System.out.print("Update Store Name : ");
            String StoreName = input.nextLine();
            System.out.print("Update Store Admin ID : ");
            String adminID = input.nextLine();
            AdminAccount a = ad.findById(adminID);
            System.out.print("Update Nunber of Customer : ");
            int numCus = input.nextInt();
            System.out.print("Update Nunber of Product : ");
            int numPro = input.nextInt();
            Store ns = new Store(StoreName,a ,numCus, numPro);
            sd.update(ns,a);
        }
        //-------------------------------------------------------------------Person------------------------------------------------------------//
        
        public static void getPerson(){
        System.out.println("\nList all Person");
        GeneralList<Person> perd = pd.getAll();
        int i = 1;
        for (Person temp : perd) {
            System.out.println(i++ + ". " + temp);
            }
        }
        
        public static void findPersonByName(){
            System.out.println("\nFinding Person");
            System.out.print("Please Enter Person Name : ");
            String personName = input.nextLine();
            Person prod = pd.findByName(personName);
        }
        
        public static void insertPerson(){
            System.out.println("\nInsert Person");
            System.out.print("Add Name : ");
            String personName = input.next();
            System.out.print("Add Address : ");
            String personAddress = input.next();
            System.out.print("Add Birth Date (1-31) : ");
            int date = input.nextInt();
            System.out.print("Add Birth Month (1-12) : ");
            int month = input.nextInt();
            System.out.print("Add Birth Year : ");
            int year = input.nextInt();
            System.out.print("Add Email : ");
            String personEmail = input.next();
            System.out.print("Add Phone : ");
            String personPhone = input.next();
            Person p = new Person(personName,personAddress,date,month ,year,personEmail, personPhone);
            pd.insert(p);
        }
        
        public static void deletePerson(){
            System.out.println("\nDelete Person");
            System.out.print("Delete Person Name : ");
            String personName = input.next();
            Person p = pd.findByName(personName);
            pd.delete(p);
        }
        
        public static void updatePerson(){
            System.out.println("\nUpdate Person");
            System.out.print("Update Person Name : ");
            String oldName = input.next();
            Person op = pd.findByName(oldName);
            System.out.print("Add Name : ");
            String personName = input.next();
            System.out.print("Add Address : ");
            String personAddress = input.next();
            System.out.print("Add Birth Date (1-31) : ");
            int date = input.nextInt();
            System.out.print("Add Birth Month (1-12) : ");
            int month = input.nextInt();
            System.out.print("Add Birth Year : ");
            int year = input.nextInt();
            System.out.print("Add Email : ");
            String personEmail = input.next();
            System.out.print("Add Phone : ");
            String personPhone = input.next();
            Person p = new Person(personName,personAddress,date,month ,year,personEmail, personPhone);
            pd.update(op,p);
        }
                
        
        
    }
        
        
//        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Action role-playing game developed and published by Square Enix",1890);
//        Product pd02 = new Product("PD02","Final Fantasy XV ","Action role-playing game developed and published by Square Enix",845);
//        Product pd03 = new Product("PD03","Dota2","Multiplayer online battle arena (MOBA) video game developed and published by Valve.",0);
//        Product pd04 = new Product("PD04","Dead By Daylight","Multiplayer (4vs1) horror game where one player takes on the role of the Killer and 4 players take on the role of the Survivor",369);
//        Product pd05 = new Product("PD05","Warframe","Cooperative free-to-play third person online action game set in an evolving sci-fi world.",0);
//        Product pd06 = new Product("PD06","Tom Clancy's Rainbow Six® Siege"," Online tactical shooter video game developed by Ubisoft Montreal and published by Ubisoft.",600);
//        Product pd07 = new Product("PD07","Overwatch","Team-based multiplayer first-person shooter (6VS6)",650);
//        Product pd08 = new Product("PD08","Resident Evil 3 Remake","A survival horror game that remake from Resident Evil 3: Nemesis (1999)",1890);
//        Product pd09 = new Product("PD09","PLAYERUNKNOWN'S BATTLEGROUNDS","Battle royale shooter that pits 100 players against each other in a struggle for survival.",559);
//        Product pd10 = new Product("PD10","League of Legends","Team-based strategy game where two teams of five powerful champions face off to destroy the other's base.",0);
//        Product pd11 = new Product("PD11","Tekken 7","A fighting game developed and published by Bandai Namco Entertainment.",1290);
//        Product pd12 = new Product("PD12","Devil May Cry 5","The ultimate Devil Hunter is back in style, in the game action fans have been waiting for.",800);
//        Product pd13 = new Product("PD13","Half-Life: Alyx","Half-Life: Alyx is Valve’s VR return to the Half-Life series.",699);
//        Product pd14 = new Product("PD14","Rocket League®","Rocket League is a high-powered hybrid of arcade-style soccer",369);
//        Product pd15 = new Product("PD15","League of Runeterra","Free-to-play online digital collectible card game from League of Legends",0);
//        Product pd16 = new Product("PD16","FIFA 20","A football simulation video game published by Electronic Arts as part of the FIFA series.",1000);
//        Product pd17 = new Product("PD17","STAR WARS Jedi: Fallen Order™","A third person action-adventure title from Respawn.",1699);
//        Product pd18 = new Product("PD18","DARK SOULS™ III","Prepare yourself and Embrace The Darkness!",1500);
//        Product pd19 = new Product("PD19","Sid Meier’s Civilization® VI","Civilization VI offers new ways to interact with your world",1600);
//        Product pd20 = new Product("PD20","Valorant","The shooter blends gameplay mechanics and ideas from multiple popular shooters in the past",0);
        //Product pd05 = new Product("PD05",null,null,100);
        //
        //store.addProduct(pd01);
        //store.addProduct(pd02);
        //store.addProduct(pd03);
        //store.addProduct(pd04);
        //store.addProduct(pd05);
        //store.addProduct(null);
        //store.removeProduct(pd03);
        //store.removeProduct(pd03);
        //store.viewShop();
        //store.addToCart(MeLo, "pd01");
        //store.addToCart(MeLo, pd02);
        //store.addToCart(MeLo, "024");
        //store.addToCart(MeLo, pd02);
        //store.addToCart(MeLo, "pd02");
        //store.checkCart(MeLo);
        //store.removeFromCart(MeLo, pd02);
        //store.removeFromCart(MeLo, "024");
        //store.addToCart(MeLo, pd03);
        //store.checkCart(MeLo);
        //store.checkMoney(MeLo);
        //store.buy(MeLo, pd01);
        //store.buy(MeLo, pd05);
        //store.buy(MeLo, null);
        //store.addToCart(MeLo, "pd01");
        //store.buy(MeLo, pd01);
        //store.buy(MeLo, pd02);
        //store.buy(MeLo, pd04);
        //store.buy(MeLo, pd03);
        //store.checkCart(MeLo);
        //store.checkStorage(MeLo);
        //store.checkMoney(MeLo);
        //store.addMoney(MeLo, 1000);
        //store.checkMoney(MeLo);
        //store.listCustomer();
        //MeLo.addProductToChart(pd01);
        //MeLo.addProductToChart(pd02);
        //MeLo.checkProductInCart();
//        store.checkCart();
//        store.addCustomerAccuont(MeLo);
//        store.addCustomerAccuont(Bal4ncez);
//        store.addCustomerAccuont(Garnet_);
//        store.addCustomerAccuont(MeLo);
//        store.listCustomer();

