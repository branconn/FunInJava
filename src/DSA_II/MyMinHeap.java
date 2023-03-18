//java class template
import java.util.Arrays;


public class MyMinHeap {

//instance variables
private int size;
private int capacity;
private int[] backingArray;

//static constants/variables


//constructors
	public MyMinHeap() {
		this.size = 0;
		this.capacity = 10;
		this.backingArray = new int[capacity];
	}

//accessors & mutators


//helper methods
	private int upHeap(int indx) {
		int parent  = indx / 2;
		if (backingArray[parent] < backingArray[indx] || indx == 1) {
			return indx;
		}

		int poppedData = backingArray[indx];
		backingArray[indx] = backingArray[parent];
		backingArray[parent] = poppedData;
		parent = upHeap(parent);
		return indx;
	}
	private int downHeap(int indx) {
		int child = 2 * indx;
		if (child > size) {
			return indx;
		}
		if (child + 1 <= size) {
			child = ((backingArray[child] < backingArray[child+1]) ? child : child+1);
		}
		if (backingArray[indx] < backingArray[child]) {
			return indx;
		}

		int poppedData = backingArray[indx];
		backingArray[indx] = backingArray[child];
		backingArray[child] = poppedData;
		child = downHeap(child);

		return indx;
	}

//public methods

	public void add(int data) {
		if (size+1 > capacity) { //resize backing array if necessary
			int[] newArray  = new int[2 * capacity];
			capacity = 2 * capacity;
			for (int i = 1; i <= size; i++) {
				newArray[i] = backingArray[i];
			}
			backingArray = newArray;
		}
		size++;
		backingArray[size] = data;
		if (size > 1) {
			upHeap(size);
		}
	}
	public int remove() {
		if (size < 1) {
			return 0;
		} else if (size == 1) {
			int removed = backingArray[1];
			backingArray[1] = 0;
			size--;
			return removed;
		} else {
			int removed = backingArray[1];
			backingArray[1] = backingArray[size];
			backingArray[size] = 0;
			size--;
			downHeap(1);
			return removed;
		}
	}

	public void show() {
		System.out.println(Arrays.toString(backingArray));
	}

	public static void main(String[] args) {
		MyMinHeap alcore = new MyMinHeap();
		alcore.add(5);
		alcore.add(4);
		alcore.add(9);
		alcore.add(2);
		alcore.add(1);
		alcore.show();
		alcore.remove();
		alcore.show();
	}
}

/* Notes

*/