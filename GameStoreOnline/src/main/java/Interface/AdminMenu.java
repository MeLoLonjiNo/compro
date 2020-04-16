
package Interface;

import java.util.Scanner;

public class AdminMenu {
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
    public static Scanner sc = new Scanner(System.in);
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
}
