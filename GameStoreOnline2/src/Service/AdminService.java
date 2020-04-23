package Service;


import Account.CustomerAccount;
import Product.Product;


    public interface AdminService {
        public void addProduct(Product pd);
        public void removeProduct(Product pd);
        public void banCustomer(CustomerAccount id);
        public String unBanCustomer();
        public String addMoney();
        public String addAdmin();
}
