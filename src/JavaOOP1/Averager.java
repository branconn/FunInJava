//Module 4 Lesson 8: Arrays

public class Averager {
	public static void main(String[] args) {


/* ~~~~~~~~~1-D Array manipulations~~~~~~~~~~~~~~~~~~~~~

		double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
		double tote = 0;
		double avg = 0;
		System.out.println("Length: " + weekHighs.length);
		for (int i = 0; i < weekHighs.length; i++) {
			tote += weekHighs[i];
			avg = tote / (i+1);
			System.out.println(tote + " / " + (i+1) + " = " + avg);
		}
		tote = 0;
		for (double dayHigh : weekHighs) { //for-each
			tote += dayHigh;
		}
		avg = tote / weekHighs.length;
		//double avg = tote / weekHighs.length;
		System.out.println(avg);

		String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};
		String result = "not found";
		for (String concept : concepts) {
			if (concept.equals("polymorphism")) {
				result = "found";
				break;
			}
		}
		System.out.println(result);

~~~~~~~~~~~~2-D array manipulations~~~~~~~~~~~~~~~~~~~~~~~~~ */

		final double MIN_T = 60.0;
		final double MAX_T = 90.0;
		final int DAYSINWEEK = 7;
		int numWeeks = 3;
		double[][] weekHighs = new double [numWeeks][DAYSINWEEK];
		double temp = 57.0;

		//column-major order
		for (int i=0; i < numWeeks; i++) {
			for (int j=0; j < DAYSINWEEK; j++) {
				weekHighs[i][j] = temp;
				temp += 3.2;
				System.out.printf("%.1f ", weekHighs[i][j]);
			}
		System.out.println();
		}

		//row-major order; 
		//think about the print-out order. Does it make sense?
		for (int ii = 0; ii < DAYSINWEEK; ii++) {
			for (int jj = 0; jj <numWeeks; jj++) {
				if ((weekHighs[jj][ii] >= MIN_T) 
					&& (weekHighs[jj][ii] <= MAX_T)) {
					System.out.printf("Go to park on day %d of week %d\n", ii+1, jj+1);
				}
			}
		}

	}

}


/* Notes:

An array is and ordered sequence of values where each element is of the same type
Array lengths are fixed. Length is a constant of an array.

declaration:
	elementType[] identifier //1-D array
	element[][] identifier //2-D array; array2d[row][col]
	element identifier[][] //alternative syntax
	//2-D arrays are actually nested arrays
instantiation:
	new elementType[Length]

all together now:
1)	double[] weekHighs = new double[7]; //initializing w/ default values
2)	double[] weekHighs = {80, 70, 74, 65, 73, 78, 81}; //intializing w/ values
3)	double[] weekHighs = new double[7];
	weekHighs[0] = 80;
	weekHighs[1] = 70;
		...
	weekHighs[7] = 81;

You can have arrays of primitives (doubles, chars, ints, etc.) or objects (strings, etc.)
An array of objects is an array of references to objects (not actual values)

Java creates default values:
	number prims: 	0.0
	booleans:	False
	objects:	null (no value) [i.e. variable has no address]

Command-line arguments:
	observe the initiating like of main function:
		public static void main(String[] args) {
	here, the input to the main method is an array of strings called args
	this array is passed from the command line when the java function is called
	e.g. java Averager 80 70 90 will set {"80"; "70"; "90"} as args

double average = (args.length > 0) ? (sum/args.length) : 0;
// if (args.length > 0) { average = sum/args.length } else { average = 0 };

Double is a utility "wrapper" class for the primitive double

Row-major order
Column-major order

Ragged arrays: java allows for arrays with rows of varying lengths
	double [][] array2d = {{0, 1, 2, 3},{0, 1}};
	or you can instantiate each row separately

*/