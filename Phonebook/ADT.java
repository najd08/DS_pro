/*linked list: This class will represent the linked list data structure used to store the contacts. 
 * It should have methods for adding, searching, and deleting contacts from the list. */

import java.util.LinkedList;
import java.util.Scanner;

public class ADT<Contact>{
	
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		

	}
	
	
	private Node head;
	private Node current;
	
	LinkedList<Contact> ADT = new LinkedList<Contact>();
	
	ADT(){
		head= current = null;
	}
 
	public void add(Contact val) {
		Node tmp;
		if (head==null) {
			current = head = new Node (val);
		}
		else {
			tmp = current.next;
			current.next = new Node (val);
			current = current.next;
			current.next = tmp;
		}
	}

	
	public boolean search(Contact c){
		Node prev = current;
		current = head;
		while(current != null) {
			if(current.contact.equals(c))
				return true;
			current = current.next;
		}
		current = prev;
		return false;
	}
	
	public void delete(Contact c) {
		current = head;
		Node prev = null;
		while(current != null) {
			if(current.contact.equals(c)) {
				if(prev == null)         //If it was in the beginning of the list
					head = current.next;
				else 
					prev.next = current.next;
				break;
			}
			prev = current;
			current = current.next;
		}
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
		  
		 }
	}
}
