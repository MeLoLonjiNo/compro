
import Account.AdminAccount;
import Service.Store;
import Product.Product;
import Account.CustomerAccount;
import Person.Person;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class MeLo_Test {
    public static void main(String[] args) {
        Person p0= new Person("Azeus", "The Land of God", LocalDate.of(1, 1, 1), "Azeus@mail.pokedex", "0123456789");
        AdminAccount a1 = new AdminAccount("Azeus","10130" , p0);
        Store store = new Store("PokeShop", a1);
        Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        CustomerAccount MeLo=new CustomerAccount("MeLoLonJiNo","12345",p1);
         Person p2= new Person("Jirayut", "Bangkok", LocalDate.of(2001, 1, 18), "jirayut.bal4ncez@mail.kmutt.ac.th", "0900000000");
        CustomerAccount Bal4ncez=new CustomerAccount("Bal4ncez","12345",p2);
         Person p3= new Person("Nippit", "Bangkok", LocalDate.of(2001, 2, 6), "nippit.c@mail.kmutt.ac.th", "0800000000");
        CustomerAccount Garnet_=new CustomerAccount("Garnet_","12345",p3);
        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        Product pd03 = new Product("PD03","Dota2","GG game",0);
        Product pd04 = new Product("PD04","Dead By Daylight","Game price 300 Bug 3Million",300);
        //Product pd05 = new Product("PD05",null,null,100);

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
        store.addCustomerAccuont(MeLo);
        store.addCustomerAccuont(Bal4ncez);
        store.addCustomerAccuont(Garnet_);
        store.addCustomerAccuont(MeLo);
        store.listCustomer();
        
    }
}
