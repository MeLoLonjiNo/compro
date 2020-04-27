
package Interface;


import Account.AdminAccount;
import Account.CustomerAccount;
import Product.Product;
import Person.Person;
import Service.Store;
import java.util.Scanner;

public class GameStoreService {
    private CustomerAccount ctac;
    private AdminAccount adac;
    private Product games[];
    private Store store;
    public static Scanner sc = new Scanner(System.in);
    
//    public static int store() {
//        System.out.println("1.Buy Game");
//        System.out.println("2.View Game in Cart");
//        System.out.println("3.Remove Game in Cart");
//        System.out.println("");
//        int selected = sc.nextInt();
//        sc.nextLine();
//        return selected;
//    }
    public static int menu() {
        System.out.println("<<Main Admin Menu>>");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Ban Customer");
        System.out.println("4. Unban Customer");
        System.out.println("5. Add money");
        System.out.println("6. Add Admin");
        System.out.println("7. Exit");
        System.out.print("Enter Your Menu[1-7]: ");
        int selected = sc.nextInt();
        sc.nextLine();
        return selected;
    }
    
    public static void main(String[] args) {
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 6:
                    System.out.println("6");
                    break;
                case 1:
                    System.out.println("1");
                    //newClub();
                    break;
                case 2:
                    System.out.println("2");
                    //subscribe();
                    break;
                case 3:
                    System.out.println("3");
                    //edit();
                    break;
                case 4:
                    System.out.println("4");
                    //unSubscribe();
                    break;
                case 5:
                    System.out.println("5");
                    //listMember();
                    break;
                case 7:
                    System.out.println("Exit");
                    //newClub();
                    break;
                
                default:
                    System.out.println("Invalid choice, please select 1-7 ONLY");
            }
        } while (choice != 7);
    }

//          เผื่อได้ใช้ เป็นหน้าระบบ
//    public static int gameStore() {
//    System.out.println("<<Game Store Online>>");
//        System.out.println("1. Register");
//        System.out.println("2. Log-In");
//        System.out.println("3. Exit");
//        System.out.print("Enter Your Number[1-3]: ");
//        int selected = sc.nextInt();
//        sc.nextLine();
//        return selected;
//    }
//    
//    public static void main(String[] args) {
//        int number = 0;
//        do {
//            number = gameStore();
//            switch (number) {
//                case 1:
//                    System.out.println("1");
//                    //register();
//                    break;
//                case 2:
//                    System.out.println("2");
//                    //subscribe();
//                    break;
//                case 3:
//                    System.out.println("Exit");
//                    //newClub();
//                    break;
//                
//                default:
//                    System.out.println("Invalid choice, please select 1-3 ONLY");
//            }
//        } while (number != 3);
//     }
//     public static int register() {
//    System.out.println("<<Register>>");
//        String id;
//        String password;
//        System.out.println("Enter your ID : ");
//        id = sc.nextLine();
//        System.out.println("Enter your Password : ");
//        password = sc.nextLine();
//        System.out.println("ID : " + id + "\nPassword" + password);
//        
//        return 1;
//    }
}

