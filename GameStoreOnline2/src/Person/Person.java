//008 กฤษณพนธ์ รักเกียรติงาม
package Person;
import java.time.LocalDate;

public class Person {
    private String name;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;

    public Person(String name, String address, LocalDate dateOfBirth, String email, String phone) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
    }
    
    public Person(String name, String address, int date, int month , int year, String email, String phone) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = LocalDate.of(year, month, date);
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public int getDate() {
        return dateOfBirth.getDayOfMonth();
    }
    
    public int getMonth() {
        return dateOfBirth.getMonthValue();
    }
    
    public int getYear() {
        return dateOfBirth.getYear();
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
  
   
    @Override
    public String toString() {
        return "Name : " + name + "\nAddress : " + address + "\nDateOfBirth : " + dateOfBirth + "\nEmail : " + email + "\nPhone : " + phone;
    }
    
    
    
}
