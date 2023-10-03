/*linked list: This class will represent the linked list data structure used to store the contacts. 
 * It should have methods for adding, searching, and deleting contacts from the list. */

public class ADT{
	private Node head;
	private Node current;
 
	public void add(Object val) {
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
}
