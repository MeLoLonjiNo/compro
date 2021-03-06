//109 จิรายุส เจษฎาการุณ
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
    public int delete(CustomerAccount cus,Product obj) {
        int row = 0;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "DELETE FROM storage WHERE cusid='" + cus.getUserID() + "' AND pcode='" + obj.getProductCode() + "'";
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
    public Product findById(CustomerAccount cus, String id) {
         Product prod = null;
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            String sql = "SELECT * FROM product p,storage st,customer ct where p.pcode = st.pcode and st.cusid = ct.cusid and st.pcode = '"+ id +"' and ct.cusid ='" + cus.getUserID() +"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                prod = new Product(rs.getString("pcode"), rs.getString("pname"), rs.getString("description"),rs.getInt("price"),rs.getString("pStatus"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //System.out.println(prod);
        return prod;
    }
    
}
