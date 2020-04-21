package Service;


import Product.Product;


    public interface AdminService {
        public void addProduct(Product pd);
        public void removeProduct(Product pd);
        public String banCustomer();
        public String unBanCustomer();
        public String addMoney();
        public String addAdmin();
}
