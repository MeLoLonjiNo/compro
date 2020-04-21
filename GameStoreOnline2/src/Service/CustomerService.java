package Service;


public interface CustomerService {
    public void viewShop();
    public void addToCart(String productCode);
    public void removeFromCart();
    public void buy();
    public int checkMoney();
    public void checkCart();
    public boolean register();
}
