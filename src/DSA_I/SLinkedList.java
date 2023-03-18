//java class template
import java.util.Iterator;


public class SLinkedList<T> implements Iterable {

//instance variables
	//declaring the head node
	private Node head;
	private Node tail;
	private int size = 0;

//static constants/variables


//constructors


//accessors & mutators
	public int getSize() { return size; }
	public Object getHead() { return head.data; }
	public Object getTail() { return tail.data; }

//helper methods
	//a nested private class for the Iterator of the LinkedList
	//acts as a deconstructed while loop
	private class SLLIterator<T> implements Iterator<T> {
		private Node<T> curr;
		SLLIterator () { curr = head; }
		public boolean hasNext() { return curr != null; } //public for Iterator object
		public T next() {				//public for Iterator object
			if (hasNext()) {
				T temp = curr.data;
				curr = curr.next;
				return temp;
			}
			return null;
		}
	}	

	//a nested private class for the Node (it could also be a separate file)
	private static class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
		private T data;
		private Node<T> next;
		
		//constructor for Node class
		private Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		//overload on Node constructor
		private Node(T data) {this(data, null);}

		@Override public int compareTo(Node<T> otherNode) {
			if (this.data == otherNode.data) { return 0; }
			//else if (this.data < otherNode.data) { return -1; }
			else { return 1; }	
		}
	}
/*
	private Node<T> rRemove(Node<T> curr) {
		if (curr == null) {
			return null;
		}
		curr.next = rRemove(curr.next);
		if (curr != null && curr.data.compareTo(curr.next.data)==0) {
			return curr.next;
		}
		return curr;
	}
*/
//public methods

	public Iterator<T> iterator() {
		return new SLLIterator<>(); //this is the current instance of a class
	}

	public void addToFront(T data) {
		Node newNode = new Node(data); 
		if (size == 0) { tail = newNode; } //sets tail at first addition to front
		newNode.next = head;		//points to previous head
		head = newNode;			//reassigns new node as head
		size++;
	}

	public void removeDuplicates() {
		head = rRemove(head);
	}

	public static void main(String[] args) {
		/*
		SLinkedList<String> courses = new SLinkedList<>();
		courses.addToFront("Biology");
		courses.addToFront("Physics");
		courses.addToFront("Calculus");
		courses.addToFront("Literature");
		*/

		SLinkedList<Integer> repeats = new SLinkedList<>();
		repeats.addToFront(7);
		repeats.addToFront(3);
		repeats.addToFront(3);
		repeats.addToFront(2);
		repeats.addToFront(-1);	

		//implicit use of Iterator. For-each loops cannot be used to alter data
		
		for (Object repeat : repeats) {
			System.out.println("Test: " + repeat);
		}
		System.out.println("------------");
		System.out.printf("Size of LinkedList: %d \n", repeats.getSize());
		System.out.println("Head of LinkedList: " + repeats.getHead());
		System.out.println("Tail of LinkedList: " + repeats.getTail());
		//explicit use of Iterator
		System.out.println("------------");
		repeats.removeDuplicates();
		for (Object repeat : repeats) {
			System.out.println("Test: " + repeat);
		}
		/*
		Iterator<String> courseIt = courses.iterator();
		while (courseIt.hasNext()) {
			String data = courseIt.next();
			System.out.println(data);
		} */

	}
}

/* Notes

*/