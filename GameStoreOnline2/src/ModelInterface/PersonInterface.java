
package ModelInterface;

import ModelDatabase.GeneralList;
import Person.Person;

public interface PersonInterface{
    int insert(Person obj);
    int update(Person oldObj,Person obj);
    int delete(Person prod);
    GeneralList<Person> getAll();
//    Person findById(int id);
    Person findByName(String name);
}
