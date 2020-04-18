
public class MeLo_Test {
    public static void main(String[] args) {
        Store store = new Store(10);
        Product pd01 = new Product("PD01","Final Fantasy VII Remake","Game Form Square Enix",1000);
        Product pd02 = new Product("PD02","Final Fantasy XV ","Game Form Square Enix",1500);
        Product pd03 = new Product("PD03","Dota2","GG game",0);
        
        store.addProduct(pd01);
        store.addProduct(pd02);
        store.addProduct(pd03);
        store.addProduct(pd01);
        store.viewShop();
    }
}
