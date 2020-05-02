package ModelDatabase;
import Account.AdminAccount;
import DatabaseConection.DBConnection;
import Person.Person;
import Service.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreDB{

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

    public int update(Store str , AdminAccount adm) {
        String sql = "UPDATE product SET sname=?, admid=?, countcus=? , countp=? WHERE sname=? ";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, str.getStoreName());
            stm.setString(2, adm.getUserID());
            stm.setInt(3, str.getCountCustomer());
            stm.setInt(4, str.getCountProduct());
            stm.setString(5, str.getStoreName());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public int delete(Store str) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM store WHERE sname=" + str.getStoreName();
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public GeneralList<Store> getAll() {
        GeneralList<Store> str = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM store s, admin a,person p WHERE s.sname=a.sname AND a.admname=p.name";
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

    public GeneralList<Store> findByName(String name) {
        GeneralList<Store> strList = new GeneralList<>();
        String sql = "SELECT * FROM store s, admin a,person p WHERE s.sname=a.sname AND a.admname=p.name AND sname like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                AdminAccount a = new AdminAccount(rs.getString("admid"), rs.getString("password"), p );
                strList.add(new Store(rs.getString("sname"),a, rs.getInt("countcus"),rs.getInt("countp")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return strList;
    }
}