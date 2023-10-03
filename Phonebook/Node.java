
public class Node {
		private Object data;
		Node next;
		
		public Node(Object data) {
			this.data = data;
			next = null;
		}
		
		public void setNext(Node nextp) {
			next = nextp;
		}
	}

