//044 นิพพิชฌ์ โชติโก
package ModelInterface;

import Account.AdminAccount;
import ModelDatabase.GeneralList;
import Store.Store;

public interface AdminInterface{
    int insert(AdminAccount adm ,Store str);
    int update(AdminAccount adm ,Store str);
    int delete(AdminAccount adm);
    GeneralList<AdminAccount> getAll();
    AdminAccount findById(String id);
    GeneralList<AdminAccount> findByName(String name);


}
