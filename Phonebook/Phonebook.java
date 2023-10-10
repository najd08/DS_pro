/*This class will represent the phonebook application itself. 
 * It should have a field for the linked list ADT that stores the contacts and 
 * methods for interacting with the list (e.g., adding, searching, and deleting contacts). 
 * You will also need to schedule events and appointments with contacts.*/

import java.util.Scanner;

public class Phonebook {
Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		

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
		if(clist.search(c)==true)   // if it's found
			return true;
		return false;
	}
    public void display() {
		
		System.out.println("Welcome to the Linked Tree Phonebook! Please choose an option:\n"
				+ "\n"
				+ "1. Add a contact\n"
				+ "\n"
				+ "2. Search for a contact\n"
				+ "\n"
				+ "3. Delete a contact\n"
				+ "\n"
				+ "4. Schedule an event\n"
				+ "\n"
				+ "5. Print event details\n"
				+ "\n"
				+ "6. Print contacts by first name\n"
				+ "\n"
				+ "7. Print all events alphabetically\n"
				+ "\n"
				+ "8. Exit\n"
				+ "\n"
				+ "Enter your choice:");
		 int choice = input.nextInt();
		 
		 switch(choice) {
		 case 1: 
			System.out.println("Enter the contact's name: ");
		    System.out.println(" Enter the contact's phone number: ");
		    System.out.println("Enter the contact's email address: ");
		    System.out.println(" Enter the contact's address: ");
		    System.out.println( "Enter the contact's birthday:  ");
		    System.out.println("Enter any notes for the contact: ");
		 case 2:
		 case 3:
		 case 4:
		 case 5:
		 case 7:
		 case 8:
		  
		 }
	}
	
	

}
