package Person;


import java.time.LocalDate;
import java.util.Date;


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

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
    
}
