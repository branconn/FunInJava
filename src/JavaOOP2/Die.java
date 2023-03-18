//Die class for the craps application
import java.util.Random;

public class Die {
//instance variables
	private int faceValue;
	private Random rand;

//static constants/variables
	public static final int SIDES = 6;

//constructors
	public Die() {
		faceValue = 1; //the initiazed value should be valid in the game logic
		rand = new Random();
	}

//accessors & mutators
	public int getFaceValue() {
		return faceValue;
	}
	public String toString() {
		return "Die with face value: " + faceValue;
	}

//helper methods

//public methods
	public int roll() {
		faceValue = rand.nextInt(SIDES) + 1;
		return faceValue;
	}	
	//this main method is only used to test the class
	public static void main(String[] args) {
		Die die1 = new Die();
		System.out.println(die1.toString());
		System.out.println(die1.roll());
		System.out.println(die1.roll());
	}
}