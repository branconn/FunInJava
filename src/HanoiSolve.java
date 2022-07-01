//based on the thought experiment in DSA1:M1 - ArrayLists & Recursion
//package imports
import java.util.ArrayList;


public class HanoiSolve {
    /*class description:
     * this class implements a recursive algorithm that solves a virtual Tower of Hanoi with (n) rings.
     * there are 3 poles: A, B, C. There are n rings on the A pole with decreasing radii from base to top.
     * the goal is to move the rings from pole A to pole C in the same ordered configuration while following these rules:
     * - only one ring can be moved at a time
     * - smaller radius rings can never be below larger radius rings
     * - when moving a ring, only the top ring on a pole can be removed and added to the top of another pole
    */
    
    //instance variables
    private int n;
    private int moves;
    private ArrayList<Integer> poleA;
    private ArrayList<Integer> poleB;
    private ArrayList<Integer> poleC;  

    //static constants & variables
    public static final int DEFAULT_RINGS = 4;

    //constructors
    public HanoiSolve() {
        this(DEFAULT_RINGS);
    }
    public HanoiSolve(int n) {
        this.n = n;
        moves = 0;
        poleA = new ArrayList<>(n);
        poleB = new ArrayList<>(n);
        poleC = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            poleA.add((Integer)i);
        }
        System.out.println("Pole A: " + poleA);
        System.out.println("Pole B: " + poleB);
        System.out.println("Pole C: " + poleB);
        System.out.println("moves: " + moves);
        System.out.println("----------------");
    }

    //accessors & mutators

    //helper (private) methods

    //public methods
    public void play(int i, ArrayList<Integer> startPole, ArrayList<Integer> goalPole, ArrayList<Integer> otherPole) {
        if (i==n-1) {
            goalPole.add((Integer)i);
            startPole.remove((Integer)i);
            moves++;
            System.out.println("Pole A: " + startPole);
            System.out.println("Pole B: " + otherPole);
            System.out.println("Pole C: " + goalPole);
            System.out.println("moves: " + moves);
            System.out.println("----------------");
        } else {
            play((i+1), startPole, otherPole, goalPole);
            goalPole.add((Integer)i);
            startPole.remove((Integer)i);
            moves++;
            System.out.println("Pole A: " + startPole);
            System.out.println("Pole B: " + otherPole);
            System.out.println("Pole C: " + goalPole);
            System.out.println("moves: " + moves);
            System.out.println("----------------");
            play((i+1), otherPole, goalPole, startPole);
        }
    }
    
    public static void main(String[] args) {
        //
        HanoiSolve testCase = new HanoiSolve();
        testCase.play(0, testCase.poleA, testCase.poleB, testCase.poleC); //there is definitely a cleaner way to call a recursive method in a class
    }
}
