
package ModelDatabase;

import Account.CustomerAccount;
import DatabaseConection.DBConnection;
import Person.Person;
import Service.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerAccountDB {

    public int insert(Store str,CustomerAccount obj) {
        int nRow = 0;
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, obj.getUserID());
            pstm.setString(2, obj.getUserName());
            pstm.setString(3, obj.getPassword());
            pstm.setString(4, obj.getAccountStatusToString());
            pstm.setInt(5, obj.getMoney());
            pstm.setInt(6, obj.getCountCart());
            pstm.setInt(7, obj.getCountStorage());
            pstm.setString(8,str.getStoreName() );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nRow;
    }

    public int update(Store str,CustomerAccount obj) {
        int row = 0;
        String sql = "UPDATE wishlist SET cusid=?,cusname=?,password=?,accountStatus=?,money=?,countcart=?,countstorage=? WHERE cusid=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getUserID());
            stm.setString(2, obj.getUserName());
            stm.setString(3, obj.getPassword());
            stm.setString(4, obj.getAccountStatusToString());
            stm.setInt(5, obj.getMoney());
            stm.setInt(6, obj.getCountCart());
            stm.setInt(7, obj.getCountStorage());
            stm.setString(8,str.getStoreName() );
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public int delete(CustomerAccount cust) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM customer WHERE cusid=" + cust.getUserID();
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    public GeneralList<CustomerAccount> getAll() {
        GeneralList<CustomerAccount> custs = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person p,customer c WHERE c.cusname = p.name";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                custs.add(new CustomerAccount(rs.getString("cusid"), rs.getString("password"), p ,rs.getInt("money"), rs.getInt("countcart"), rs.getInt("countstorage")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return custs;
    }

    public CustomerAccount findById(int id) {
        CustomerAccount cust = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM person p,customer c WHERE c.cusname = p.name AND cusid=" + id;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                return new CustomerAccount(rs.getString("cusid"), rs.getString("password"), p ,rs.getInt("money"), rs.getInt("countcart"), rs.getInt("countstorage"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cust;
    }

    public GeneralList<CustomerAccount> findByName(String name) {
        GeneralList<CustomerAccount> custList = new GeneralList<>();
        String sql = "ELECT * FROM person p,customer c WHERE c.cusname = p.name AND cusid like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getString("name"), rs.getString("address"), rs.getInt("dateOfBirth"),rs.getInt("monthOfBirth"),rs.getInt("yearOfBirth"),rs.getString("email"),rs.getString("phone"));
                custList.add(new CustomerAccount(rs.getString("cusid"), rs.getString("password"), p ,rs.getInt("money"), rs.getInt("countcart"), rs.getInt("countstorage")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return custList;
    }

}
