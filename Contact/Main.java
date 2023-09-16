import java.util.Scanner;

public class Main {
     static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        ContactManager contactManager = new ContactManager(Contact.contactData());
        Contact.displayContacts(contactManager);

        System.out.print("\nYou have 8 contacts. Enter 'continue' to edit them: ");
    String status = scan.nextLine();


    while (status.equals("continue")) {
        System.out.print("\nChoose an index from 0 to 7: ");
        int index = scan.nextInt();
        scan.nextLine();       


        contactManager.getContact(index);
        contactManager.setContact(Contact.editedContact(), index);
        
        System.out.println("\n\nUPDATED CONTACTS\n\n");
        Contact.displayContacts(contactManager);
        System.out.print("Enter 'continue' to make more changes: ");
        status = scan.nextLine();
    }
        scan.close();



        
    }

}
