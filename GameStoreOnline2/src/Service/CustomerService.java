package Service;

import Account.CustomerAccount;
import Product.Product;


public interface CustomerService {
    public abstract void viewShop();
    public abstract void addToCart(CustomerAccount customer , String productCode);
    public abstract void removeFromCart(CustomerAccount customer,String pdc);
    public abstract void buy(CustomerAccount customer,Product buyingProduct);
    public abstract void checkMoney(CustomerAccount customer);
    public abstract void checkCart(CustomerAccount customer);
    public abstract void checkStorage(CustomerAccount customer);
    //public abstract boolean register();
}
