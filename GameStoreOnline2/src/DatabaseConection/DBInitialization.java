package DatabaseConection;


import DatabaseConection.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DBInitialization {
    
    public static void main(String[] args) {
        createTables();
    //    initializeDb(true);
    }
    
    public static void renew() {
        createTables();
    //    initializeDb(true);
    }
    
    private static void createTables(){
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {        
            try {stm.executeUpdate("DROP TABLE person");} catch (SQLException ex) {}   
            try {stm.executeUpdate("DROP TABLE customer");} catch (SQLException ex) {}
            try {stm.executeUpdate("DROP TABLE admin");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE product");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE productincart");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE storage");} catch (SQLException ex) {}  
            try {stm.executeUpdate("DROP TABLE store");} catch (SQLException ex) {}  
                    
            try {stm.executeUpdate("CREATE TABLE person(userid varchar(20) NOT NULL , name varchar(20) NOT NULL , address varchar(100) NOT NULL, dateOfBirth INT NOT NULL , monthOfBirth INT NOT NULL , yearOfBirth INT NOT NULL , email varchar(50) NOT NULL , phone INT NOT NULL , PRIMARY KEY (userid))");} catch (SQLException ex) {}   
            try {stm.executeUpdate("CREATE TABLE customer(cusid varchar(20) NOT NULL , cusname varchar(20) NOT NULL , password varchar(30) NOT NULL , accountStatus varchar(10) NOT NULL , money INT NOT NULL , countcart INT NOT NULL , countstorage INT NOT NULL , PRIMARY KEY (cusid))");} catch (SQLException ex) {}
            try {stm.executeUpdate("CREATE TABLE admin(admid varchar(20) NOT NULL , admname varchar(20) NOT NULL , password varchar(30) NOT NULL , accountStatus varchar(10) NOT NULL , PRIMARY KEY (admid))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE product(pcode varchar(20) NOT NULL , pname varchar(20) NOT NULL , description varchar(100) NOT NULL , price INT NOT NULL , pStatus varchar(10) NOT NULL , PRIMARY KEY (pcode))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE productincart(cusid varchar(20) NOT NULL , pcode varchar(20) NOT NULL , pname varchar(20) NOT NULL , description varchar(100) NOT NULL , price INT NOT NULL , PRIMARY KEY (cusid , pcode))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE storage(cusid varchar(20) NOT NULL , pcode varchar(20) NOT NULL , pname varchar(20) NOT NULL , description varchar(100) NOT NULL , price INT NOT NULL , PRIMARY KEY (cusid , pcode))");} catch (SQLException ex) {}  
            try {stm.executeUpdate("CREATE TABLE store(sname varchar(20) NOT NULL , admid varchar(20) NOT NULL , cusid varchar(20) NOT NULL , countcus INT NOT NULL , countp INT NOT NULL , PRIMARY KEY (admid , cusid))");} catch (SQLException ex) {}

        }catch (Exception ex) {
            System.out.println(ex.getMessage()+" แก้ไขตามคำแนะนำด้านบน แล้ว Run ใหม่จนกว่าจะผ่าน");
        }
    }
    
    private static void initializeDb(boolean show){
        String sqlPerson ="INSERT INTO person VALUES(?,?,?,?,?,?,?,?)";
        String sqlCustomer ="INSERT INTO customer VALUES(?,?,?,?,?)";
        String sqlAdmin ="INSERT INTO admin VALUES(?,?,?,?)";
        String sqlProduct ="INSERT INTO product VALUES(?,?,?,?,?)";
        String sqlProductInCart ="INSERT INTO productincart VALUES(?,?,?,?,?)";
        String sqlStorage ="INSERT INTO storage VALUES(?,?,?,?,?)";
        String sqlStore ="INSERT INTO store VALUES(?,?,?,?,?)";
            try(Connection conn = DBConnection.getConnection();
                PreparedStatement stmP = conn.prepareStatement(sqlPerson);
                PreparedStatement stmC = conn.prepareStatement(sqlCustomer);
                PreparedStatement stmAd = conn.prepareStatement(sqlAdmin);
                PreparedStatement stmPd = conn.prepareStatement(sqlProduct);
                PreparedStatement stmPc = conn.prepareStatement(sqlProductInCart);
                PreparedStatement stmSt = conn.prepareStatement(sqlStorage);
                PreparedStatement stmS = conn.prepareStatement(sqlStore);
                ) {
            Scanner sc;

            
            try {
                if(show)System.out.println("\n--- Import Person ---");
                sc=new Scanner(new File("files/person.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmP.setString(1, temp[0]);
                        stmP.setString(2, temp[1]);
                        stmP.setString(3, temp[2]);
                        stmP.setString(4, temp[3]);
                        stmP.setInt(5, Integer.parseInt(temp[4]));
                        stmP.setInt(6, Integer.parseInt(temp[5]));
                        stmP.setInt(7, Integer.parseInt(temp[6]));
                        stmP.setString(8, temp[7]);
                        stmP.executeUpdate();
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                if(show)System.out.println("\n--- Import Customer ---");
                sc=new Scanner(new File("files/customer.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmC.setString(1, temp[0]);
                        stmC.setString(2, temp[1]);
                        stmC.setInt(3, Integer.parseInt(temp[2]));
                        stmC.executeUpdate();
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                if(show)System.out.println("\n--- Import Admin ---");
                sc=new Scanner(new File("files/admin.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmAd.setString(1, temp[0]);
                        stmAd.setString(2, temp[1]);
                        stmAd.executeUpdate();
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
           
            try {
                if(show)System.out.println("\n--- Import Product ---");
                sc=new Scanner(new File("files/product.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmPd.setString(1, temp[0]);
                        stmPd.setString(2, temp[1]);
                        stmPd.setString(3, temp[2]);
                        stmPd.setInt(4, Integer.parseInt(temp[3]));
                        stmPd.setString(5, temp[4]);
                        stmPd.executeUpdate();                      
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                if(show)System.out.println("\n--- Import ProductInCart ---");
                sc=new Scanner(new File("files/productincart.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmPc.setString(1, temp[0]);
                        stmPc.setString(2, temp[1]);
                        stmPc.setString(3, temp[2]);
                        stmPc.setString(4, temp[3]);
                        stmPc.setInt(5, Integer.parseInt(temp[4]));
                        stmPc.executeUpdate();                      
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                if(show)System.out.println("\n--- Import Storage ---");
                sc=new Scanner(new File("files/storage.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmSt.setString(1, temp[0]);
                        stmSt.setString(2, temp[1]);
                        stmSt.setString(3, temp[2]);
                        stmSt.setString(4, temp[3]);
                        stmSt.setInt(5, Integer.parseInt(temp[4]));
                        stmSt.executeUpdate();                      
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            try {
                if(show)System.out.println("\n--- Import Store ---");
                sc=new Scanner(new File("files/store.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmS.setString(1, temp[0]);
                        stmS.setString(2, temp[1]);
                        stmS.setString(3, temp[2]);
                        stmS.setInt(4, Integer.parseInt(temp[3]));
                        stmS.setInt(5, Integer.parseInt(temp[4]));
                        stmS.executeUpdate();                      
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
                    
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
