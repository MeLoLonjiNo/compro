
package ModelInterface;

import ModelDatabase.GeneralList;
import Person.Person;

public interface PersonInterface{
    int insert(Person obj);
    int update(Person obj);
    int delete(Person prod);
    GeneralList<Person> getAll();
//    Person findById(int id);
    GeneralList<Person> findByName(String name);
}
