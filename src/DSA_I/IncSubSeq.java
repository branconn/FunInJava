//attempt at coding recursive counter for increasing subsequences found in an array

public class IncSubSeq {

//instance variables


//static constants/variables
	static int[] fullArray = {1,7,3,5,2,8,10,24,-1,-5,4};
	static int[] a = new int[fullArray.length];
	static int answer = 0;

//constructors


//accessors & mutators


//helper methods


//public methods

	public static int counterBoi(int[] array, int[] countArray) {
		if (i == fullArray.length) { return count + 1; }
		else {
			//logic
			return counterBoi(array, countArray);
		}
		int count = 5;
		return count;
	}

	public static void main(String[] args) {

		answer = counterBoi(fullArray, a);
		
		System.out.println(answer);

	}
}

/* Notes

*/