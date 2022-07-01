//assignment for Module 1 of Data Struct & Algorithms
//package imports

public class HomebrewedArrayList {
    /*class description:
     *this is a limited replication of the ArrayList class
     */
    
    //instance variables
    private int size;
    private int capacity;
    private Integer[] backingArray;

    //static constants & variables
    public static final int INITIAL_CAPACITY = 4;

    //constructors
    public HomebrewedArrayList() {
        this(INITIAL_CAPACITY);
    }
    public HomebrewedArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.backingArray = new Integer[capacity];
    }

    //accessors & mutators
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }
    public Integer[] getArray() {
        return backingArray;
    }

    //helper (private) methods
    private void resize() { //creates a newArray with double capacity, copies elements to newArray and reassigns backingArray
        System.out.println("Capacity doubled from " + capacity + " to " + (capacity*2));
        capacity = 2 * capacity;
        Integer[] newArray = new Integer[capacity];
        for (int i=0; i < size; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    //public methods
    public void addToFront(Integer value) { //adds input parameter to the front of the array (shifts other elements right once)
        if (value == null) {
            throw new NullPointerException("Error: null passed as input");
        } else {
            if (size == capacity) { //checks if the capacity of the backingArray needs to be expanded (doubled)
                resize();
            }
            size++;
            for (int i=size; i>=1; i--) {
                backingArray[i] = backingArray[i-1];
            }
            backingArray[0] = value;
            System.out.println("Value " + backingArray[0] + " added to front, other elements shifted right.");
        }
    }
    public void addToBack(Integer value) { //addes input parameter to the end of the array
        if (value == null) {
            throw new NullPointerException("Error: null passed as input");
        } else {
            if (size == capacity) { //checks if the capacity of the backingArray needs to be expanded (doubled)
                resize();
            }
            size++;
            backingArray[size-1] = value;
            System.out.println("Value " + backingArray[size-1] + " added to index " + (size-1));
        }
    }
    public void removeFromFront() { //removes the first element in the array (shifts other elements left once)
        System.out.println("Value " + backingArray[0] + " removed from front, other elements shifted left.");
        for (int i=0; i<size; i++) {
            backingArray[i] = backingArray[i+1];
        }
        size--;
    }
    public void removeFromBack() { //removes the last element in the array (replaces will null)
        System.out.println("Value " + backingArray[size-1] + " removed from index " + (size-1));
        size--;
        backingArray[size] = null;
    }

    public static void main(String[] args) {
        //implementing a test case
        HomebrewedArrayList testArray = new HomebrewedArrayList();
        System.out.println("Initial capacity: " + testArray.capacity + " Initial size: " + testArray.size);
        testArray.addToFront(6);
        testArray.addToFront(5);
        testArray.addToBack(7);
        testArray.addToBack(8);
        testArray.addToFront(4);
        testArray.removeFromFront();
        testArray.removeFromBack();
        System.out.println("Final capacity: " + testArray.capacity + " Final size: " + testArray.size);
    }
}
