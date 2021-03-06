package linked_list;

public class LinkedList {
	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void insertHead(int data) {
		if(isEmpty()) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		}else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		
		// C. Obj
		// obj->next = head
		// change head
	}
	
	public void insertNext(int nextTo, int data) {
		// search for the node
		Node result = search(nextTo);
		
		if(result != null) {
			Node newNode = new Node(data);
			newNode.next = result.next;
			
			result.next = newNode;
			
			if(tail == result) {
				tail= newNode;
			}
		}
		
		
		
	}
	
	public Node search(int data) {
		Node temp = head;
		
		while(temp != null) {
			if(temp.getData() == data) {
				return temp;
			}
			
			temp = temp.next;
		}
		
		return null;
	}
	
	
	public void insertTail(int data) {
		if(isEmpty()) {	// list is empty
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		}else {
			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
		}		
	}
	
	
	public void delete(int data) {
		Node current = head;
		Node previous = head;
		
		while(current != null) {
			if(current.getData() == data) {
				if(current == head) {	// *************
					head = current.next;
				}
				
				if(current == tail) {	// *************
					tail = previous;
				}
				
				previous.next = current.next;
				
				current.next = null;	//************
				
				return;
			}
			
			previous = current;
			current = current.next;
		}
	}
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		
		return false;
	}
	
	public void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.getData());
			
			temp = temp.next;
		}
	}
	
}
