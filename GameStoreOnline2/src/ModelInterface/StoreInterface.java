
package ModelInterface;

import Account.AdminAccount;
import ModelDatabase.GeneralList;
import ModelInterface.GeneralInterface;
import Store.Store;

public interface StoreInterface{
    int insert(Store obj , AdminAccount obj2);
    int update(Store str , AdminAccount adm);
    int delete(Store str);
    GeneralList<Store> getAll();
    //Store findById(, int id);
    Store findByName(String name);
}
