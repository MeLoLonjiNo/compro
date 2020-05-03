
package ModelInterface;

import ModelDatabase.GeneralList;
import Product.Product;

public interface ProductInCartInterface<CustomerAccount,Product>{
    int insert(CustomerAccount cus ,Product obj);
    int update(CustomerAccount cus ,Product obj);
    int delete(CustomerAccount cus ,Product obj);
    GeneralList<Product> getAll(CustomerAccount cus);
    CustomerAccount findById(CustomerAccount cus, int id);
    GeneralList<Product> findByName(CustomerAccount cus,String name);
}
