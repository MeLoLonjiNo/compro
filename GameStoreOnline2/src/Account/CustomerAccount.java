//008 กฤษณพนธ์ รักเกียรติงาม

package Account;
import Person.Person;
import Product.Product;

public class CustomerAccount extends Account{
    
    private int countCart;
    private int countStorage;
    private int money;
    private static final String RED = "\u001B[031m";
    private static final String BLACK = "\u001B[030m";
    
    public CustomerAccount(Account account)  {
        super(account);
        money = 2000;
        countCart=0;
        countStorage=0;
    }

    public int getCountCart() {
        return countCart;
    }

    public int getCountStorage() {
        return countStorage;
    }
    
    public CustomerAccount(String id , String password , Person person){
        super(id, password, person);
        money = 2000;
        countCart=0;
        countStorage=0;
    }
    
    public CustomerAccount(String id , String password , Person person , int money,int countC,int countS,String status){
        super(id, password, person,status);
        this.money = money;
        countCart=countC;
        countStorage=countS;
    }
    
    public void addCountCart(){
        this.countCart++;
    }
    
    public void deCountCart(){
        this.countCart--;
    }
    
    public void addCountStorage(){
        this.countStorage++;
    }
    
    public void deCountStorage(){
        this.countStorage--;
    }
    
    public boolean prePay(int productPrice){
        if(this.money>=productPrice){
            return true;
    }
        else{return false;}
    }
    
    public void pay(int productPrice){
        this.money = money-productPrice;
    }
     
    public  int payment(Product payingProduct){
        if(payingProduct==null){return -1;}
        if(money-payingProduct.getPrice()<0){return -2;}
        else money = money-payingProduct.getPrice(); {return money;}
        
     }

    public int getMoney() {
        return money;
    }
    
    public void getStringMoney() {
        System.out.println("Meney : "+money);
    }
    
    public void setAccountStatus (AccountStatus status){
        super.setAccountStatus(status);
    }
    
    public void addMoney(int addingMoney){
        this.money=money+addingMoney;
    }

    @Override
    public String toString() {
        return "Customer Account ID : "+super.getUserID()+"\nCustomer Name "+super.getUserName()+"\nCustomer Money : "+this.money+"\nCustomer Account Status : "+this.getAccountStatusToString();
    }
    
    public String toString2() {
        return "Customer Account ID : "+super.getUserID()+"\nCustomer Account Password : "+super.getPassword();
    }
}