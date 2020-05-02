
package ModelDatabase;

import Account.CustomerAccount;
import DatabaseConection.DBConnection;
import ModelInterface.CustomerInterface;
import ModelDatabase.GeneralList;
import Person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerAccountDB implements CustomerInterface{

   @Override
    public int insert(CustomerAccount obj) {
        int nRow = 0;
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, obj.getUserID());
            pstm.setString(2, obj.getUserName());
            pstm.setInt(3, obj.getMoney());
            pstm.setInt(4, obj.getCountCart());
            pstm.setInt(5, obj.getCountStorage());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nRow;
    }

    @Override
    public int update(CustomerAccount cust) {
        int row = 0;
        String sql = "UPDATE wishlist SET cusid=?,cusname=?,money=?,countcart=?,countstorage=? WHERE cusid=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, cust.getUserID());
            stm.setString(2, cust.getUserName());
            stm.setInt(3, cust.getMoney());
            stm.setInt(4, cust.getCountCart());
            stm.setInt(5, cust.getCountStorage());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public int delete(CustomerAccount cust) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM wishlist WHERE cusid=" + cust.getUserID();
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public GeneralList<CustomerAccount> getAll() {
        GeneralList<CustomerAccount> custs = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM customer";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                custs.add(new CustomerAccount(rs.getString("cusid"), rs.getString("password"), rs2.getObject(sql, person)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return custs;
    }

    @Override
    public CustomerAccount findById(int id) {
        CustomerAccount cust = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM customer WHERE cus_id=" + id;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                return new CustomerAccount(rs.getInt("cus_id"), rs.getString("cus_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cust;
    }

    @Override
    public GeneralList<CustomerAccount> findByName(String name) {
        GeneralList<CustomerAccount> custList = new GeneralList<>();
        String sql = "SELECT * FROM customer WHERE cus_name like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                custList.add(new CustomerAccount(rs.getInt("cus_id"), rs.getString("cus_name")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return custList;
    }

}
