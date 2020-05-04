
package ModelInterface;

import Account.CustomerAccount;
import ModelDatabase.GeneralList;
import Store.Store;

public interface CustomerInterface{
    int insert(Store str,CustomerAccount obj);
    int update(Store str,CustomerAccount obj);
    int delete(CustomerAccount cust);
    GeneralList<CustomerAccount> getAll();
    CustomerAccount findById(String id);
    GeneralList<CustomerAccount> findByName(String name);
}
