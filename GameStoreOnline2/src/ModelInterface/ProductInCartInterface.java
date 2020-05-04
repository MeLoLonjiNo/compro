package ModelInterface;

import Account.CustomerAccount;
import ModelDatabase.GeneralList;
import Product.Product;

public interface ProductInCartInterface{
    int insert(CustomerAccount cus ,Product obj);
    //int update(CustomerAccount cus ,Product obj);
    int delete(CustomerAccount cus ,Product obj);
    GeneralList<Product> getAll(CustomerAccount cus);
    Product findById(CustomerAccount cus, String id);
    //GeneralList<Product> findByName(CustomerAccount cus,String name);
}