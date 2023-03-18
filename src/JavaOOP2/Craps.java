//Craps class is the client and logic class for the craps application

public class Craps {

//instance variables
	private Die die1, die2;
	private int point;

//static constants/variables

//constructors
	public Craps() {
		die1 = new Die();
		die2 = new Die();
	}

//accessors & mutators

//helper methods
	private int toss() {
		int total = die1.roll() + die2.roll();
		System.out.println("Die One: " + die1.getFaceValue()
			+ ", Die Two: " + die2.getFaceValue());
		return total;
	}
	private void go() {
		point = toss();
		System.out.println("Point: " + point);
		if ((point == 7) || (point == 11)) {
			System.out.println("Winner winner");
		}
		else if ((point == 2) || (point == 3) || (point == 12)) {
			System.out.println("Loser loser");
		}
		else {
			System.out.println("Enter stage 2");
			stage2();
		}
	}
	private void stage2() { //why was this public?
		boolean endGame = false;
		
		while (!endGame) {
			int total = toss();

			System.out.println("Total: " + total);
			if (total == point) {
				System.out.println("Winner!");
				endGame = true;
			}
			else if (total == 7) {
				System.out.println("You rolled 7, so you lost!");
				endGame = true;
			}
		}
	}

//public methods
	public static void main(String[] args) {
		System.out.println("Let's play a game of craps");
		Craps game1 = new Craps();
		game1.go();
	}
}