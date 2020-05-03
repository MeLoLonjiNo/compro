
package ModelInterface;

import ModelDatabase.GeneralList;
import Product.Product;
import Store.Store;

public interface ProductInterface{
    int insert(Store store,Product obj);
    int update(Store store,Product prod);
    int delete(Product prod);
    GeneralList<Product> getAll();
    Product findById(int id);
    GeneralList<Product> findByName(String name);
}
