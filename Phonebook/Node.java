
public class Node {
		Contact contact;
		Node next;
		
		public Node(Contact data) {
			contact = data;
			next = null;
		}
		
		public void setNext(Node nextp) {
			next = nextp;
		}
	}

