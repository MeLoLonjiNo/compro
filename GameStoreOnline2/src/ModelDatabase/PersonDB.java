//008 กฤษณพนธ์ รักเกียรติงาม
package ModelDatabase;

import DatabaseConection.DBConnection;
import ModelInterface.PersonInterface;
import Person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDB implements PersonInterface{
    
    @Override
    public int insert(Person obj) {
        String sql = "INSERT INTO person VALUES(?,?,?,?,?,?,?)";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getName());
            stm.setString(2, obj.getAddress());
            stm.setInt(3, obj.getDate());
            stm.setInt(4, obj.getMonth());
            stm.setInt(5, obj.getYear());
            stm.setString(6, obj.getEmail());
            stm.setString(7, obj.getPhone());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cannot insert in to dabase: " + ex.getMessage());
        }
        return row;
    }

    
    @Override
    public int update(Person oldObj,Person obj) {
        String sql = "UPDATE person SET name=?,address=?,dateOfBirth=?, monthOfBirth=?,yearOfBirth=?,email=?,phone=? WHERE name=? ";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getName());
            stm.setString(2, obj.getAddress());
            stm.setInt(3, obj.getDate());
            stm.setInt(4, obj.getMonth());
            stm.setInt(5, obj.getYear());
            stm.setString(6, obj.getEmail());
            stm.setString(7, obj.getPhone());
            stm.setString(8, oldObj.getName());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    
    @Override
    public int delete(Person prod) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM person WHERE name= '" + prod.getName()+"'";
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    
    @Override
    public GeneralList<Person> getAll() {
        GeneralList<Person> prods = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                prods.add(new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prods;
    }

    @Override
    public Person findByName(String name) {
        Person per = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person WHERE name like '%" + name+"%'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                per = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(per);
        return per;
    }

    
}
