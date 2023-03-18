//java class implementing the Selection sort algorithm
import java.util.Arrays;
import java.util.Random;
public class SelectionSort {

//instance variables

//static constants/variables
	public static Integer[] TEST_ARRAY = {3, 7, 13, 1, 93, 0, -42, 6, 6};
	public static Integer[] BIG_TEST = new Integer[1000000];


//constructors

//accessors & mutators

//helper methods

//public methods
	public static Integer[] selectSort(Integer[] unsorted) {
		Integer poppedVal;
		int swapIndex;
		for (int i=0; i < unsorted.length-1; i++) { 			//loop for each pass (n-1)
			swapIndex = i; 						//class calls minIndex
			for (int j=i + 1; j < unsorted.length; j++) { 		//loop for each comparison
				if (unsorted[j].compareTo(unsorted[swapIndex]) < 0) {
					swapIndex = j;
				}
			}
			poppedVal = unsorted[i];
			unsorted[i] = unsorted[swapIndex];
			unsorted[swapIndex] = poppedVal;
		}
	return unsorted;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0; i < BIG_TEST.length; i++) {
			BIG_TEST[i] = rand.nextInt(1000000);
		}
		//System.out.println(Arrays.toString(TEST_ARRAY));
		Integer[] sortedArray = selectSort(BIG_TEST);
		//System.out.println(Arrays.toString(sortedArray));
		System.out.println(BIG_TEST[(BIG_TEST.length - 1)]);
	}
}

/* Notes

*/