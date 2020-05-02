
package ModelDatabase;

import DatabaseConection.DBConnection;
import ModelInterface.PersonInterface;
import Product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDB implements PersonInterface{

    @Override
    public int insert(Person obj) {
        String sql = "INSERT INTO product VALUES(?,?,?,?,?)";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, obj.getProductCode());
            stm.setString(2, obj.getProductName());
            stm.setString(3, obj.getDescription());
            stm.setInt(4, obj.getPrice());
            stm.setString(5, obj.getProductStatusToString());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cannot insert in to dabase: " + ex.getMessage());
        }
        return row;
    }

    @Override
    public int update(Person prod) {
        String sql = "UPDATE product SET pcode=?,pname=?,description=?, price=?,pStatus=? WHERE pcode=? ";
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, prod.getProductCode());
            stm.setString(2, prod.getProductName());
            stm.setString(3, prod.getDescription());
            stm.setInt(4, prod.getPrice());
            stm.setString(5, prod.getProductStatusToString());
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
            String sql = "DELETE FROM product WHERE pcode=" + prod.getProductCode();
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
            String sql = "SELECT * FROM product";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                prods.add(new Person(rs.getString("pcode"), rs.getString("pname"), rs.getString("description"),rs.getInt("price"),rs.getString("pStatus")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prods;
    }

    @Override
    public Person findById(int id) {
        Product prod = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM product where pro_id=" + id;
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
    public GeneralList<Person> findByName(String name) {
        GeneralList<Product> prodList = new GeneralList<>();
        String sql = "SELECT * FROM product WHERE pro_name like ?";
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
