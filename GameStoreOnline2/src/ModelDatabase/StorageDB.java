package ModelDatabase;

import Account.CustomerAccount;
import DatabaseConection.DBConnection;
import ModelInterface.StorageInterface;
import Product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StorageDB implements StorageInterface{

    
    @Override
    public int insert(CustomerAccount cus,Product obj) {
        String sql = "INSERT INTO storage VALUES(?,?)";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, cus.getUserID());
            stm.setString(2, obj.getProductCode());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cannot insert in to database: " + ex.getMessage());
        }
        return row;
    }

    @Override
    public int update(CustomerAccount cus,Product obj) {
        String sql = "UPDATE storage SET cusid=?,pcode=? WHERE cusid=? ";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, cus.getUserID());
            stm.setString(2, obj.getProductCode());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    
    @Override
    public int delete(CustomerAccount cus,Product obj) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM storage WHERE cusid=" + cus.getUserID() + "AND pcode=" + obj.getProductCode();
            row = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return row;
    }

    @Override
    public GeneralList<Product> getAll(CustomerAccount cus) {
        GeneralList<Product> prods = new GeneralList<>();
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT P.* FROM PRODUCT P , STORAGE PS WHERE P.PCODE=PS.PCODE AND PS.CUSID = '" + cus.getUserID() + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                prods.add(new Product(rs.getString("pcode"), rs.getString("pname"), rs.getString("description"),rs.getInt("price"),rs.getString("pStatus")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prods;
    }

    @Override
    public Product findById(CustomerAccount cus, int id) {
         Product prod = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql2 = "SELECT pcode FROM storage WHERE cusid=" + cus.getUserID();
            String sql = "SELECT * FROM product where pro_id=" + sql2;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                prod = new Product(rs.getString("pcode"), rs.getString("pname"), rs.getString("description"),rs.getInt("price"),rs.getString("pStatus"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(prod);
        return prod;
    }

    @Override
    public GeneralList<Product> findByName(CustomerAccount cus, String name) {
        GeneralList<Product> prodList = new GeneralList<>();
        String sql2 = "SELECT pname FROM storage WHERE cusid=" + cus.getUserID();
        String sql = "SELECT * FROM product WHERE "+ sql2 +" like " + name;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                prodList.add(new Product(rs.getString("pcode"), rs.getString("pname"), rs.getString("description"),rs.getInt("price"),rs.getString("pStatus")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return prodList;
    }

    
}
