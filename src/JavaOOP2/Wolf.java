//java class Wolf which is a subclass of class Canine
import java.util.Arrays;
import java.util.Random;
public class Wolf extends Canine implements Groomable, Comparable<Wolf> {
	
//instance variables
	protected int rank;


//static constants/variables
	public static final int PACK_SIZE = 10;

//constructors
	public Wolf(double size, int rank) {
		super(size);
		this.rank = rank;
	}

//accessors & mutators
	public int getRank() {
		return rank;
	}
//helper methods

//public methods
	public void bark() { //overriding the parent bark method
		for (int i=0; i<3; i++) {
			System.out.println("Bark");
		}
		
	}

	public void groom() { System.out.println("lick");}

	public int compareTo(Wolf anotherWolf) {
		return -(rank - ((Wolf)anotherWolf).rank);
	}

	public String toString() {
		return ("Rank " + rank + ", Size " + size);
	}


	public static void main(String[] args) {
		Wolf alpha = new Wolf(17.1, 1);
		Wolf puppy = new Wolf(2.4, 10);
		int rankDiff = alpha.compareTo(puppy);
		System.out.println("Alpha is "+ rankDiff + " ranks away relative to puppy");

		Wolf[] pack = new Wolf[PACK_SIZE];

		Random rand = new Random(); //instance of random class

		for (int i = 0; i < PACK_SIZE; i++) {
			int randRank = rand.nextInt(9) + 1;
			double randSize = Math.round((rand.nextDouble() * 20)*10.0)/10.0;
			pack[i] = new Wolf(randSize, randRank);
		}

		System.out.println("Unsorted Pack: " + Arrays.toString(pack));
		Arrays.sort(pack);
		System.out.println("===========================");
		System.out.println("Sorted Pack: " + Arrays.toString(pack));
	}
}

/* Notes

Our first implementation of compareTo,

	public int compareTo(Object anotherWolf) {

does not constrain the type of object in the input, so we can put anything in like a String and it compiles. The problem shows up a runtime which is harder to root cause. We want a solution that constrains the compareTo types to be like for any Class implementing it.

The solution is a generic type, which is an interface or class that is capable of accepting input that describes the type of data it can work with. That's what Comparable is, and it accepts a formal input describing the admissable type e.g.

	public class Wolf extends Canine implements Groomable, Comparable<Wolf> {
	...
	public int compareTo(Wolf anotherWolf) {



*/