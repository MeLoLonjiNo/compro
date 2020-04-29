
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
            
            try {stm.executeUpdate("CREATE TABLE account(userid varchar(20) IS NOT NULL , password varchar(30) IS NOT NULL , accountStatus varchar(10) IS NOT NULL , PRIMARY KEY (userid) , FOREIGN KEY (userid))");} catch (SQLException ex) {}         
            try {stm.executeUpdate("CREATE TABLE person(userid varchar(20) IS NOT NULL , name varchar(20) IS NOT NULL , address varchar(100) IS NOT NULL, dateOfBirth int IS NOT NULL , email varchar(50) IS NOT NULL , phone int IS NOT NULL , PRIMARY KEY (userid) , FOREIGN KEY (userid))");} catch (SQLException ex) {}   
            try {stm.executeUpdate("CREATE TABLE customer(cusid varchar(20) IS NOT NULL , cusname varchar(20) IS NOT NULL , money int IS NOT NULL , PRIMARY KEY (cusid) , FOREIGN KEY (cusid))");} catch (SQLException ex) {}
            try {stm.executeUpdate("CREATE TABLE admin(admid varchar(20) IS NOT NULL , admname varchar(20) IS NOT NULL , PRIMARY KEY (admid) , FOREIGN KEY (admid))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE product(pcode varchar(20) IS NOT NULL , pname varchar(20) IS NOT NULL , description(100) IS NOT NULL , price INT IS NOT NULL , pStatus varchar(10) IS NOT NULL , PRIMARY KEY (pcode) , FOREIGN KEY (pcode))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE productincart(cusid varchar(20) IS NOT NULL , pcode varchar(20) IS NOT NULL , pname varchar(20) IS NOT NULL , description varchar(100) IS NOT NULL , price INT IS NOT NULL , PRIMARY KEY (cusid , pcode) , FOREIGN KEY (cusid))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE storage(cusid varchar(20) IS NOT NULL , pcode varchar(20) IS NOT NULL , pname varchar(20) IS NOT NULL , description(100) IS NOT NULL , price INT IS NOT NULL , PRIMARY KEY (cusid , pcode) , FOREIGN KEY (cusid))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE store(sname varchar(20) IS NOT NULL , admid varchar(20) IS NOT NULL , cusid varchar(20) IS NOT NULL , countcus INT IS NOT NULL , countp INT IS NOT NULL , PRIMARY KEY (admid , cusid) , FOREIGN KEY (admid , cusid))");} catch (SQLException ex) {}
        }catch (Exception ex) {
            System.out.println(ex.getMessage()+" แก้ไขตามคำแนะนำด้านบน แล้ว Run ใหม่จนกว่าจะผ่าน");
        }
    }
}
