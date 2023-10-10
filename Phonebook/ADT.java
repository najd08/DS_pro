/*linked list: This class will represent the linked list data structure used to store the contacts. 
 * It should have methods for adding, searching, and deleting contacts from the list. */

import java.util.LinkedList;

public class ADT{
	
	private Node head;
	private Node current;
	
	LinkedList ADT = new LinkedList ();
	
	ADT(){
		head= current = null;
	}
 
	public void add(Contact val) {
		Node tmp;
		if (head==null) { // If list is empty
		  current = head = new Node (val);
		}
		else {
			tmp = current.next;
			current.next = new Node (val);
			current = current.next;
			current.next = tmp;
		}
	}

	 // Method to check if the contact that is being added has a name or email that exists in the list 
	public boolean searchMatch(String name, String email){
		Node prev = current;
		current = head;
		while(current != null) {
			if(((Contact)current.contact).getName().equalsIgnoreCase(name)||((Contact)current.contact).getEmail().equalsIgnoreCase(email))
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
	
	
}
