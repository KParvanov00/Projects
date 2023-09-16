import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact(String name, String phoneNumber, String birthDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {        
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int toAge(String birthDate) {
        LocalDate parsedBirthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(parsedBirthDate, currentDate);
        return period.getYears();
    }
    public static Contact[] contactData() {
        return new Contact[] {
                new Contact("John Doe", "555-123-4567", "1985-01-01"),
                new Contact("Jane Smith", "555-987-6543", "1990-02-14"),
                new Contact("Alice Johnson", "555-345-6789", "1975-03-30"),
                new Contact("Bob Brown", "555-567-8910", "2000-12-25"),
                new Contact("Charlie Davis", "555-111-2222", "1983-07-04"),
                new Contact("Diana White", "555-333-4444", "1997-11-18"),
                new Contact("Ethan Green", "555-555-6666", "1988-05-22"),
                new Contact("Fiona Black", "555-777-8888", "2002-10-31")
        };
    }
    public static void displayContacts(ContactManager contactManager) {
        for (int i = 0; i < 8; i++) {
            Contact contact = contactManager.getContact(i);
            System.out.println(contact);
            System.out.println("\n");
        }
    }
    public String toString() {
        return "Name: " + this.name + "\n" +
            "Phone number: " + this.phoneNumber + "\n" +
            "Birth Date: " + this.birthDate + "\n" +
            "Age: " + this.age + " year old\n";
    }
    public static Contact editedContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\tName: ");
        // pick up name
        String name=scanner.nextLine();
        
        System.out.print("\tPhone Number: ");
        // pick up number
        String phoneNumber=scanner.nextLine();
        
        System.out.print("\tBirth Date: ");
        // pick up birth date
        String birth=scanner.nextLine();
    
        // return a Contact object
        Contact contact=new Contact(name, phoneNumber,birth);
        return contact;
    }
    
    

}
