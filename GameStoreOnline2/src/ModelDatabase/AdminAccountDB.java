//044 นิพพิชฌ์ โชติโก
package ModelDatabase;

import Account.AdminAccount;
import DatabaseConection.DBConnection;
import ModelInterface.AdminInterface;
import Person.Person;
import Store.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminAccountDB implements AdminInterface{
   
    @Override
    public int insert(AdminAccount adm ,Store str) {
        int nRow = 0;
        String sql = "INSERT INTO admin VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, adm.getUserID());
            stm.setString(2, adm.getUserName());
            stm.setString(3, adm.getPassword());
            stm.setString(4, adm.getAccountStatusToString());
            stm.setString(5, str.getStoreName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nRow;
    }

    @Override
    public int update(AdminAccount adm ,Store str) {
        int row = 0;
        String sql = "UPDATE admin SET admid=?,admname=?,password=?,accountStatus=?,sname=? WHERE admid=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, adm.getUserID());
            stm.setString(2, adm.getUserName());
            stm.setString(3, adm.getPassword());
            stm.setString(4, adm.getAccountStatusToString());
            stm.setString(5, str.getStoreName());
            stm.setString(6, adm.getUserID());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public int delete(AdminAccount adm) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM admin WHERE admid='" + adm.getUserID() +"'";
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public GeneralList<AdminAccount> getAll() {
        GeneralList<AdminAccount> adm = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person p,admin a WHERE a.admname = p.name";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                adm.add(new AdminAccount(rs.getString("admid"), rs.getString("password"), p ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return adm;
    }

    @Override
    public AdminAccount findById(String id) {
        AdminAccount adm = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person p,admin a WHERE a.admname = p.name AND admid= '" + id+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                return new AdminAccount(rs.getString("admid"), rs.getString("password"), p );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return adm;
    }

    @Override
    public GeneralList<AdminAccount> findByName(String name) {
        GeneralList<AdminAccount> admList = new GeneralList<>();
        String sql = "SELECT * FROM admin WHERE admname like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                admList.add(new AdminAccount(rs.getString("admid"), rs.getString("password"), p ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return admList;
    }

    
}
