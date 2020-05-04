package ModelDatabase;
import Account.AdminAccount;
import DatabaseConection.DBConnection;
import ModelInterface.StoreInterface;
import Person.Person;
import Store.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreDB implements StoreInterface{

    @Override
    public int insert(Store obj , AdminAccount obj2) {
        String sql = "INSERT INTO store VALUES(?,?,?,?)";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getStoreName());
            stm.setString(2, obj2.getUserID());
            stm.setInt(3, obj.getCountCustomer());
            stm.setInt(4, obj.getCountProduct());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cannot insert in to dabase: " + ex.getMessage());
        }
        return row;
    }

    @Override
    public int update(Store str , AdminAccount adm) {
        String sql = "UPDATE store SET admid=?, countcus=? , countp=? WHERE sname=? ";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stm = conn.prepareStatement(sql)) {
            //stm.setString(1, str.getStoreName());
            stm.setString(1, adm.getUserID());
            stm.setInt(2, str.getCountCustomer());
            stm.setInt(3, str.getCountProduct());
            stm.setString(4, str.getStoreName());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public int delete(Store str) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM store WHERE sname = '"+ str.getStoreName()+"'";
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public GeneralList<Store> getAll() {
        GeneralList<Store> str = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM store s, admin a,person p WHERE s.admid=a.admid AND a.admname=p.name";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                AdminAccount a = new AdminAccount(rs.getString("admid"), rs.getString("password"), p );
                str.add(new Store(rs.getString("sname"), a, rs.getInt("countcus"),rs.getInt("countp")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }

    @Override
    public Store findByName(String name) {
        String sql = "SELECT * FROM store s,person p,admin a WHERE s.admid=a.admid AND a.admname=p.name  AND s.sname like ? ";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                AdminAccount a = new AdminAccount(rs.getString("admid"), rs.getString("password"), p );
                return new Store(rs.getString("sname"),a, rs.getInt("countcus"),rs.getInt("countp"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
    