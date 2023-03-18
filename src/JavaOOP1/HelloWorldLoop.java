//Module 3, Lesson 7: Iteration

public class HelloWorldLoop {
	public static void main(String[] args) {
		//int counter = 0; //initialization
		//while (counter < 20) { //condition
		//do {
		//for (int i = 0; i < 20; i++) { //loop header
			//System.out.print(counter + ".. ");
			//counter++; //update
		//}
		//while (counter < 20);
		//System.out.print("\n");
		//for (int pow = 20; pow <= 40; pow*=0.9) { //unbounded example
		//for (int pow = 1; pow <= 40; pow*=2) {
			//System.out.println(pow);
		//}

		int outerCounter = 0;
		while (outerCounter <= 5) {
			int innerCounter = 0;
			while (innerCounter <= 5) {
				System.out.println("Outer: " + outerCounter + "  Inner: " + innerCounter);
				if (outerCounter+innerCounter >= 9) {
					System.out.println("Break");
					//innerCounter--;
					//outerCounter--;
					//break; //break statements only apply to their  containing loop
					innerCounter++;
					continue;
				}
				innerCounter++;
			}
		outerCounter++;
		}
		for (int i = 50; i > 0; i -= 10) {
			System.out.print(i);
		}
	}
}


/* Notes
while (booleanExpresison)
	bodyStatement;

while (booleanExpression) {
	bodyStatement;
	bodyStatement;
}

do-while statement: hmm this sounds new..
	statements first without any precondition,
	then expression to loop
do {
	bodyStatement;
	bodyStatement;
}
while (booleanExpression); 

for statement: you already know bro bro

for (counterIntialization; condition; incrementation) {
	bodyStatement;
}
you can initialize the counter outside the for-loop header to expand its scope beyond the method

also note: for loop can be unbounded just like a while loop

the continue statement skips the rest of the code in the loop, but continues onto the next iteration

*/