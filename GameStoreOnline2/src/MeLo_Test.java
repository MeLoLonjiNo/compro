
import Account.AdminAccount;
import Store.Store;
import Product.Product;
import Account.CustomerAccount;
import ModelDatabase.GeneralList;
import ModelDatabase.ProductDB;
import ModelDatabase.ProductInCartDB;
import ModelInterface.ProductInCartInterface;
import ModelInterface.ProductInterface;
import Person.Person;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class MeLo_Test {
        Person p0= new Person("Azeus", "The Land of God", LocalDate.of(1, 1, 1), "Azeus@mail.pokedex", "0123456789");
        AdminAccount a1 = new AdminAccount("Azeus","10130" , p0);
        Store store = new Store("PokeShop", a1);
        static Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        static CustomerAccount MeLo=new CustomerAccount("c1","12345",p1);
         Person p2= new Person("Jirayut", "Bangkok", LocalDate.of(2001, 1, 18), "jirayut.bal4ncez@mail.kmutt.ac.th", "0900000000");
        CustomerAccount Bal4ncez=new CustomerAccount("Bal4ncez","12345",p2);
         Person p3= new Person("Nippit", "Bangkok", LocalDate.of(2001, 2, 6), "nippit.c@mail.kmutt.ac.th", "0800000000");
        CustomerAccount Garnet_=new CustomerAccount("Garnet_","12345",p3);
        static ProductInterface pdb = new ProductDB();
        static ProductInCartInterface picd = new ProductInCartDB();
    
         public static void main(String[] args) {
             //getProduct();
             getProductInCart(MeLo);
        }

        public static void getProduct(){
        System.out.println("\nList all Product");
        GeneralList<Product> prod = pdb.getAll();
        int i = 1;
        for (Product temp : prod) {
            System.out.println(i++ + ". " + temp);
         }
        }
        
       public static void getProductInCart(CustomerAccount c){
        System.out.println("\nList all ProductInCart");
        GeneralList<Product> prod = picd.getAll(c);
        int i = 1;
        for (Product temp : prod) {
            System.out.println(i++ + ". " + temp);
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
        
    
}
