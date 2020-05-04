
package ModelInterface;

import Account.Account;
import Account.AdminAccount;
import ModelDatabase.GeneralList;
import Store.Store;

public interface AdminInterface{
    int insert(AdminAccount obj , Account obj2 ,Store obj3);
    int update(AdminAccount adm , Account act , Store str);
    int delete(AdminAccount adm);
    GeneralList<AdminAccount> getAll();
    AdminAccount findById(String id);
    GeneralList<AdminAccount> findByName(String name);
}
