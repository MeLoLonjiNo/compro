package Service;

import Account.CustomerAccount;


public interface CustomerService {
    public abstract void viewShop();
    public abstract void addToCart(CustomerAccount customer , String productCode);
    public abstract void removeFromCart(CustomerAccount customer,String pdc);
    public abstract void buy();
    public abstract int checkMoney();
    public abstract void checkCart();
    public abstract boolean register();
}
