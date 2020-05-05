//008 กฤษณพนธ์ รักเกียรติงาม
package ModelInterface;

import ModelDatabase.GeneralList;

public interface GeneralInterface <T> {
    int insert(T obj);
    int update(T obj);
    int delete(T obj);
    GeneralList<T> getAll();
    T findById(int id);
    GeneralList<T> findByName(String name);
}
