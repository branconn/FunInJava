//java class template

public class BST <T extends Comparable<T>> {

//instance variables
	private int size;
	private Node<T> root;
	private T[] traverseArray;
	private Node<T> traverseRoot;

//static constants/variables
	private class Node<T extends Comparable<T>> {
		T data;
		Node<T> left;
		Node<T> right;
		Node<T> newNode;
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

//constructors
	public BST() {
		this.size = 0;
		this.root = null;
	}
	public BST(T newData) {
		this.size = 0;
		addNode(newData);
	}
	public BST(T[] newData) {
		this.size = 0;
		addNode(newData);
	}

//accessors & mutators
	public int getSize() { return size; }
	public T getRoot() { return root.data; }
	//public void setNode(int addedInt) {}

//helper methods

	/*
/////////////
/////
 this is a look-forward implementation of the add method. A pointer reinforcement implementation is preferred.

	private void addNodeHelper(Node<T> curr, Node<T> newNode) {
		if (curr.data.compareTo(newNode.data) < 0) {
			if (curr.left == null) { 
				curr.left = newNode; 
				System.out.println(newNode.data + " is left child of " + curr.data);
			}
			else { addNodeHelper(curr.left, newNode);}
		} 
		else if (curr.data.compareTo(newNode.data) > 0) {
			if (curr.right == null) { 
				curr.right = newNode;
				System.out.println(newNode.data + " is right child of " + curr.data);
			}
			else { addNodeHelper(curr.right, newNode); }
		} else { System.out.println("Node already exists in tree"); }

	}
/////
/////////////
	*/

	//this is the pointer reinforcement implementation of the add method
	//"reinforcement" means you return the expected value as you exit the recursion stack
	private Node<T> addNodeHelper(Node<T> curr, T data) {
		if (curr == null) {
			System.out.println(data + " has been added.");
			this.size ++;
			return new Node<T>(data); //////////////////////////////
		} else if (curr.data.compareTo(data) < 0) {
			System.out.println(data + " flows to right of " + curr.data);
			curr.right = addNodeHelper(curr.right, data);
		} else if (curr.data.compareTo(data) > 0) {
			System.out.println(data + " flows to left of " + curr.data);
			curr.left = addNodeHelper(curr.left, data);
		}
		return curr;
	}

	private boolean searchNodeHelper(Node<T> curr, T data) {
		if (curr.data.compareTo(data) == 0) {
			return true;
		} else if (curr.data.compareTo(data) > 0) {
			if (curr.left == null) { 
				return false;
			}
			else { return searchNodeHelper(curr.left, data);}
		} 
		else {
			if (curr.right == null) { 
				return false;
			}
			else { return searchNodeHelper(curr.right, data); }
		}

	}


	private Node<T> preOrderHelper(Node<T> curr, Node<T> tRoot) {
		if (curr == null) {
			pass;
		} else {
			tRoot = new Node<T>(curr.data);
			System.out.println(curr.data);
			tRoot.right = preOrderHelper(curr.left, tRoot.right);
			tRoot.right = preOrderHelper(curr.right, tRoot.right);
		}
		return tRoot; 
	}

/*

	private void preOrderHelper(Node<T> curr) {
		if (curr != null) {
			System.out.println(curr.data);
			preOrderHelper(curr.left);
			preOrderHelper(curr.right);
		} 
	}

	private int inOrderHelper(Node<T> curr, Node<T> tRoot) {
		if (curr != null) {
			iter = inOrderHelper(curr.left, tRoot.right);
			traverseNode.right = curr;
			System.out.println(curr.data);
			iter = inOrderHelper(curr.right, tRoot.right);
		} 
		return iter;
	}
	private int postOrderHelper(Node<T> curr, Node<T>) {
		if (curr != null) {
			iter = postOrderHelper(curr.left, iter);
			iter = postOrderHelper(curr.right, iter);
			traverseArray[iter] = curr.data;
			System.out.println(curr.data);
		} 
		return iter;
	}
*/

//public methods
	public void addNode(T newData) {
		root = addNodeHelper(root, newData);	
	}

	public void addNode(T[] newDataArray) {
		for (T newData : newDataArray) {
			root = addNodeHelper(root, newData);
		}
	}
	public void searchNode(T data) {
		if (root == null) {
			System.out.println("Tree is empty. Use addNode(data) to add a node");
		} else if (searchNodeHelper(root, data)) {
			System.out.println("Found node " + data + " in tree");
		} else { System.out.println("Node is not in tree"); }
	}

	public void preOrder() {
		if (size > 0) {
			traverseRoot = preOrderHelper(root, traverseRoot);
		}
		Node<T> presenter = traverseRoot;
		while (presenter != null) {
			System.out.print(presenter.data + "; ");
			presenter = presenter.right;
		}
		System.out.print("\n");
	}
/*
//////////////
/////
	public T[] inOrder() {
		T[]traverseArray = (T[])new Object[size];
		if (size > 0) {
			inOrderHelper(root, 0);
		}
		return traverseArray;
	}
	public T[] postOrder() {
		T[]traverseArray = (T[])new Object[size];
		if (size > 0) {
			postOrderHelper(root, 0);
		}
		return traverseArray;
	}

	public T[] preOrder() {
		T[]traverseArray = (T[])new Object[size];
		if (size > 0) {
			preOrderHelper(root, 0);
		}
		return traverseArray;

	}
	public T[] inOrder() {
		T[]traverseArray = (T[])new Object[size];
		if (size > 0) {
			inOrderHelper(root, 0);
		}
		return traverseArray;
	}
	public T[] postOrder() {
		T[]traverseArray = (T[])new Object[size];
		if (size > 0) {
			postOrderHelper(root, 0);
		}
		return traverseArray;
	}



	public <T> T[] levelOrder() {
		traverseArray = new T[size];
		Node qHead = root;
		Node qTail = root;
		Node curr = root;
		int i = 0;
		while (curr != null) {
			traverseArray[i] = qHead.data;
			if (qHead.left != null) {
				qHead.left = qTail.right;
				qTail = qTail.right;
			}
			if (qHead.right != null) {
				qHead.right = qTail.right;
				qTail = qTail.right;
			}
			qHead
		}
	}
/////
//////////////
*/

	public static void main(String[] args) {
		Integer[] nodeArray = {24, 13, 6, 21, 40, 30, 8, 45, 33};
		BST<Integer> myBST = new BST<>(nodeArray);
		System.out.println("Size: " + myBST.getSize());
		System.out.println("Root: " + myBST.getRoot());
		myBST.preOrder();
		//System.out.println("Pre-order: " + java.util.Arrays.toString(myBST.preOrder()));
		//System.out.println("In-order: " + java.util.Arrays.toString(myBST.inOrder()));
		//System.out.println("Post-order: " + java.util.Arrays.toString(myBST.postOrder()));
		myBST.searchNode(22);
		myBST.addNode(22);
		myBST.searchNode(22);
		
	}
}

/* Notes

*/