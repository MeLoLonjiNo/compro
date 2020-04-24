
import Service.Store;
import Product.Product;
import Account.CustomerAccount;
import Person.Person;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class MeLo_Test {
    public static void main(String[] args) {
        Store store = new Store(10);
        Person p1= new Person("Kritsanapon", "Bangkok", LocalDate.of(2000, 9, 11), "kritsanapon.melo@mail.kmutt.ac.th", "0800000000");
        CustomerAccount MeLo=new CustomerAccount("MeLoLonJiNo","12345",p1);
        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        Product pd03 = new Product("PD03","Dota2","GG game",0);
        Product pd04 = new Product("PD04","Dead By Daylight","Game price 300 Bug 3Million",300);
//        
        store.addProduct(pd01);
        store.addProduct(pd02);
        store.addProduct(pd03);
        store.addProduct(pd04);
        //store.removeProduct(pd03);
        store.viewShop();
        //store.addToCart(MeLo, "PD01");
        //MeLo.addProductToChart(pd01);
        //MeLo.addProductToChart(pd02);
        MeLo.checkProductInCart();
//        c1.addToCart(pd01);
//        store.addToCart("pd04");
//        store.checkCart();

    }
}
