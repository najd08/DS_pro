/*linked list: This class will represent the linked list data structure used to store the contacts. 
 * It should have methods for adding, searching, and deleting contacts from the list. */

public class ADT{
	private Node head;
	private Node current;
	
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
}
