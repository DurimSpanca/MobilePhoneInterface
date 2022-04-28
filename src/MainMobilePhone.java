import java.util.Scanner;

public class MainMobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("044 454 428");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter actions: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("\nShutting down... ");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }
    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact) == true){
            System.out.println("New contact has been added " + name + " Phone " + phone);
        } else {
            System.out.println("Cannot add contact, " + name + "already on file");
        }
    }
    private static void updateContact(){
        System.out.println("Enter a existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("Successfully updated record!");
        } else {
            System.out.println("Error updating record!");
        }
    }
    private static void queryContact(){
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Name:" + existingContactRecord.getName() + " phone number is: "
                            + existingContactRecord.getPhoneNumber());
    }
    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\nPress  ");
        System.out.println("0 - To shutdown");
        System.out.println("1 - To print actions");
        System.out.println("2 - To add new contacts");
        System.out.println("3 - To update an existing contact");
        System.out.println("4 - To remove existing contact");
        System.out.println("5 - Query if an existing contact exists");
        System.out.println("6 - To print a list of available actions");
        System.out.println("Chose your actions: ");
    }
    private static void removeContact(){
        System.out.println("Enter existing contact: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found!");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted.");
        } else {
            System.out.println("Error deleting contact.");
        }
    }
}
