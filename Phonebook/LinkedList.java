/*linked list: This class will represent the linked list data structure used to store the contacts. 
 * It should have methods for adding, searching, and deleting contacts from the list. */

import java.util.Comparator;
import java.util.List;

public class LinkedList<T extends Comparable<T>>{
	
	private Node<T> head;
	private Node<T> current;
	int size;
	
	
	LinkedList(){
		head= current = null;
		size = 0;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public void findFirst () {
        current = head;
     }
	
    public void findNext () {
        current = current.next;
    }
    
    public void update (T data) {
        current.data = data;
}
 
	public boolean add(T data) {
		Node<T>tmp;
		if (empty()) { 
		  current = head = new Node<T> (data);
		}
		else {
			if (head.getData().compareTo(data) >0)
            {
                tmp = new Node(data);
                tmp.setNext(head);
                head = tmp;
            }
            else
            {
                Node<T> prev = null;
                current = head;
                
                while (( current != null ) && (current.getData().compareTo(data) <= 0))
                {
                    prev = current;
                    current = current.getNext();
                }
                tmp = new Node (data);
                if ( current != null)
                {
                    tmp.next = current;
                    prev.next = tmp;
                    current = tmp;
                }
                else
                    current = prev.next =tmp;
            }
		}
		size++;
		return true;
	}

	 // Method to check if the contact that is being added has a name or email that exists in the list 
	public boolean searchMatch(String name, String email){
		Node<T> prev = current;
		current = head;
		while(current != null) {
			if(((Contact)current.data).getName().equalsIgnoreCase(name)||((Contact)current.data).getEmail().equalsIgnoreCase(email))
				return true;
			current = current.next;
		}
		current = prev;
		return false;
	}
	
	public boolean search(T data) {
		Node<T>prev = current;
		current = head;
		while(current != null) {
			if(current.getData().equals(data))
				return true;
			current = current.next;
		}
		current = prev;
		return false;
		
	}
	
	public boolean searchByName(String name) {
		Node<T>prev = current;
		current = head;
		while(current != null) {
			Contact cont = ((Contact)current.data);
			int index = cont.getName().indexOf(" ");
			String firstName = cont.getName().substring(0, index);
			if(firstName.equalsIgnoreCase(name)) {
				System.out.println(cont);
				return true;}
			current = current.next;
		}
		current = prev;
		return false;
	}
	
	public boolean searchByPhoneNumber(String pNumber) {
		Node<T>prev = current;
		current = head;
		while(current != null) {
			Contact cont = ((Contact)current.data);
			if(cont.getNumber().equals(pNumber)) {
				System.out.println("Number is found!\n"+ cont);
				return true;}
			current = current.next;
		}
		current = prev;
		return false;
	}
	
	public void delete(T c) {
		if(empty())
			System.out.println("There is no contact to delete!");
		else {
		current = head;
		Node<T> prev = null;
		while(current != null) {
			if(current.data.equals(c)) {
				if(prev == null)         //If it was in the beginning of the list
					head = current.next;
				else 
					prev.next = current.next;
				System.out.println("Contact has been deleted!");
				break;
			}
			prev = current;
			current = current.next;
		}}
		}
		
		
	

	public T remove(T tRemove) {
		if (search (tRemove) == false) //if not found
		       return null; 
	  T data = current.getData();
	        
	  if (current == head) 
	       head = head.next;
	        
	  else {
	         Node <T>tmp = head;

	         while (tmp.next != current)
	           tmp = tmp.next;
	           tmp.next = current.next;
	        }
	  
	   if (current.next == null)
	        current = head;
	   else
	       current = current.next;
	       size -- ;
	       return data;    
		
	}

	

	
	
}
