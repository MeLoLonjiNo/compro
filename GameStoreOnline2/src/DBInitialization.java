
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nippit
 */
public class DBInitialization {
    
    public static void main(String[] args) {
    
    }
    
    public static void renew() {
        
    }
    
    private static void createTables(){
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            try {stm.executeUpdate("DROP TABLE account");} catch (SQLException ex) {}         
            try {stm.executeUpdate("DROP TABLE person");} catch (SQLException ex) {}   
            try {stm.executeUpdate("DROP TABLE customer");} catch (SQLException ex) {}
            try {stm.executeUpdate("DROP TABLE admin");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE product");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE productincart");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE storage");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE store");} catch (SQLException ex) {}  
            
            try {stm.executeUpdate("CREATE TABLE account()");} catch (SQLException ex) {}         
            try {stm.executeUpdate("CREATE TABLE person()");} catch (SQLException ex) {}   
            try {stm.executeUpdate("CREATE TABLE customer()");} catch (SQLException ex) {}
            try {stm.executeUpdate("CREATE TABLE admin()");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE product()");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE productincart()");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE storage()");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE store()");} catch (SQLException ex) {}
        }catch (Exception ex) {
            System.out.println(ex.getMessage()+" แก้ไขตามคำแนะนำด้านบน แล้ว Run ใหม่จนกว่าจะผ่าน");
        }
    }
}
