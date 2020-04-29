package Service;


import Account.CustomerAccount;
import Product.Product;


    public interface AdminService {
        public void addProduct(Product pd);
        public void addProduct(String productCode , String productName , String description , int price);
        public void removeProduct(Product pd);
        public void banCustomer(CustomerAccount customerAccount);
        public void unBanCustomer(CustomerAccount customerAccount);
        public void addMoney(CustomerAccount customerAccount,int money);
        public void listCustomer();
        
}
