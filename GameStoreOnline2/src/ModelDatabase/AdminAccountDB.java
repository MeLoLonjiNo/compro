
package ModelDatabase;

import Account.Account;
import Account.AdminAccount;
import DatabaseConection.DBConnection;
import ModelInterface.AdminInterface;
import Service.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AdminAccountDB{
   
    public int insert(AdminAccount obj , Account obj2 ,Store obj3) {
        int nRow = 0;
        String sql = "INSERT INTO admin VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getUserID());
            stm.setString(2, obj.getUserName());
            stm.setString(3, obj.getPassword());
            stm.setString(4, obj2.getAccountStatusToString());
            stm.setString(5, obj3.getStoreName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nRow;
    }

    public int update(AdminAccount adm , Account act , Store str) {
        int row = 0;
        String sql = "UPDATE admin SET cusid=?,cusname=?,money=?,countcart=?,countstorage=? WHERE cusid=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, adm.getUserID());
            stm.setString(2, adm.getUserName());
            stm.setString(3, adm.getPassword());
            stm.setString(4, act.getAccountStatusToString());
            stm.setString(5, str.getStoreName());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public int delete(AdminAccount adm) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM admin WHERE admid=" + adm.getUserID();
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public GeneralList<AdminAccount> getAll() {
        GeneralList<AdminAccount> adm = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM admin";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                adm.add(new AdminAccount(rs.getString("admid"), rs.getString("admname"), rs.getString("password"), rs.getAccountStatusToString("accountStatus"), rs.getStoreName("sname")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return adm;
    }

//    public AdminAccount findById(int id) {
//        AdminAccount adm = null;
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            String sql = "SELECT * FROM admin WHERE admid=" + id;
//            ResultSet rs = stm.executeQuery(sql);
//            if (rs.next()) {
//                return new AdminAccount(rs.getString("admid"), rs.getString("admname"), rs.getString("password"), rs.getAccountStatusToString("accountStatus"), rs.getStoreName("sname")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return adm;
//    }

//    public GeneralList<AdminAccount> findByName(String name) {
//        GeneralList<AdminAccount> admList = new GeneralList<>();
//        String sql = "SELECT * FROM admin WHERE admname like ?";
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stm = conn.prepareStatement(sql)) {
//            stm.setString(1, "%" + name + "%");
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                admList.add(new AdminAccount(rs.getString("admid"), rs.getString("admname"), rs.getString("password"), rs.getAccountStatusToString("accountStatus"), rs.getStoreName("sname")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return admList;
//    }
}
