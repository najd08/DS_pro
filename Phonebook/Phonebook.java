/*This class will represent the phonebook application itself. 
 * It should have a field for the linked list ADT that stores the contacts and 
 * methods for interacting with the list (e.g., adding, searching, and deleting contacts). 
 * You will also need to schedule events and appointments with contacts.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Phonebook {
Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Linked Tree Phonebook!");

	}
	
	private ADT clist;
	
	Phonebook(){
		clist = new ADT();
	}
	
	public void addC(Contact c) {
		if(existContact(c))
			System.out.println("This contact has been added previously!");
		else
			clist.add(c);
	}
	
	public boolean existContact(Contact c) {
		if(clist.searchMatch(c.getName(), c.getEmail())==true)   // if it's found
			return true;
		return false;
	}
	
    public void display() {
    	String name, pnumber,email,adress,birthday,note;
    
    	boolean flag = true; 
    	while(flag) { //To repeat showing the menu 
				System.out.println("choose an option:"
				+ "1. Add a contact\n"
				+ "2. Search for a contact\n"
				+ "3. Delete a contact\n"
				+ "4. Schedule an event\n"
				+ "5. Print event details\n"
				+ "6. Print contacts by first name\n"
				+ "7. Print all events alphabetically\n"
				+ "8. Exit\n"
				+ "Enter your choice:");
		
		try {  // Input handling using exceptions
		 int choice = input.nextInt();
		 switch(choice) {
		 case 1:  // Add contact
			System.out.println("\nEnter the contact's name: ");
			 name = input.nextLine();
		    System.out.println(" Enter the contact's phone number: ");
		     pnumber = input.nextLine();
		    System.out.println("Enter the contact's email address: ");
		     email = input.nextLine();
		    System.out.println(" Enter the contact's address: ");
		     adress = input.nextLine();
		    System.out.println( "Enter the contact's birthday:  ");
		     birthday = input.nextLine();
		    System.out.println("Enter any notes for the contact: ");
		     note = input.nextLine();
		      Contact c = new Contact(name,pnumber,email,adress,birthday,note);
		      if( this.existContact(c) != true) //checking if it already exists
		    	  clist.add(c);
		      else
		    	  System.out.println("Contact already exists");
		      break;
		 case 2: //Search a contact
			 
		 case 3: //Delete a contact
		 case 4: //Add event
		 case 5: //print even details
		 case 7: //print all events alphabetically
		 case 8: // if user wants to exit
			 flag = false; //to break the loop
			 System.out.println("Goodbye!");
		 } // End switch
		 }catch(InputMismatchException e) {
			 System.out.println("Please enter a number!");
			 input.nextLine();
		 }
		}// end while loop 
    	}
	
	

}
