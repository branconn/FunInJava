import java.util.Scanner;
public class Battleship {
	
	public static final int NUM_SHIPS = 5;
	public static final boolean SINGLE_PLAYER = true;
	public static final int NUM_GAMES = 10000;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	

		System.out.println("Welcome to battleship!");
		//System.out.println("\nCoordinates should be entered as R[space]C[enter]");
		
		int minRounds = 100;
		double totRounds = 0;
///////////////
		for (int g=0; g<NUM_GAMES; g++) {



		//System.out.println("\nPLAYER 1, ENTER YOUR SHIP'S COORDINATES.");
		//creates a 3-d array 2x5x5 where [0][5x5] is the LocBoard and [1][5x5] is the HitBoard
		int[] p1Score = {0, 0};
		char[][][] p1Boards = newBoards();

		//printBattleShip(p1Boards[0]);
		//System.out.println("these are the bounds of your area, 5x5 (0-4)");
		p1Boards[0] = placePieces(p1Boards[0], input, SINGLE_PLAYER);
		
		//for (int i=0; i<10; i++) { System.out.println(""); }

		//System.out.println("PLAYER 2, ENTER YOUR SHIP'S COORDINATES.");
		int[] p2Score = {0, 0};
		char[][][] p2Boards = newBoards();
		p2Boards[0] = placePieces(p2Boards[0], input, SINGLE_PLAYER);

		//for (int i=0; i<10; i++) { System.out.println(""); }

		boolean gameOn = true;
		boolean player1 = true;
		int rounds = 0;
		do{
			
			if (player1) {
				p2Boards = attack(p2Boards, 1, input, SINGLE_PLAYER);
				p1Score = checkScore(p2Boards);
				if (p1Score[0] > 4) {
					gameOn=false;
					//System.out.println("Player 1 won the game!\n");
				}
				rounds += 1;
				player1 = false;
			}
			else {
				p1Boards = attack(p1Boards, 2, input, SINGLE_PLAYER);
				p2Score = checkScore(p1Boards);
				if (p2Score[0] > 4) {
					gameOn=false;
					//System.out.println("Player 2 won the game!\n");
				}
				player1 = true;
			}
			//System.out.println("round: " + rounds);
			
			
		}while (gameOn);
		//System.out.println("game: " + g + "   rounds: " + rounds);

		if (rounds < minRounds) {minRounds = rounds;}
		if (rounds < 7) {
			System.out.println("FINAL BOARDS");
			System.out.println("\nPlayer 1:");
			printBattleShip(p1Boards[0]);
			System.out.println("\nPlayer 2:");
			printBattleShip(p2Boards[0]);	
		}
		
		totRounds += rounds;
		}//for(NUM_GAMES) loop
////////////////
		double avgRounds = totRounds / NUM_GAMES;
		System.out.println(NUM_GAMES + " games were played");
		System.out.printf("The average number of rounds was %.3f\n", avgRounds);
		System.out.println("The least number of rounds was " + minRounds);
	}

//TODO: instantiate a placement board and strike board for each player

	public static char[][][] newBoards() {
		char[][][] boards = new char [2][5][5];
		for (int h=0; h<2; h++){
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				boards[h][i][j] = '-';
			}
		}
		}
		return boards;	
	}


//TODO: create prompting loop
//TODO: pass user input into ship placements on board

	public static char[][] placePieces(char[][] board, Scanner response, boolean auto) {
		for (int i=1; i<6; i++) {
			boolean valid = false;
			while (!valid) {
				//System.out.print("Enter ship " + i + " location: ");
				int rowInd;
				int colInd;
				if (auto) {
					rowInd = (int)(Math.random() * NUM_SHIPS);
					colInd = (int)(Math.random() * NUM_SHIPS);
					//System.out.println(rowInd + " " + colInd);
				}
				else {
					rowInd = response.nextInt();
					colInd = response.nextInt();
				}
				if (rowInd >= 0 && rowInd < 5 && colInd >= 0 && colInd < 5) {
					if (board[rowInd][colInd] == '-') {
						board[rowInd][colInd] = '@';
						//printBattleShip(board);
						valid = true;
					}
					//else {System.out.println("You already have a ship there. Choose different coordinates.");}
					
				}
				else {
					//System.out.println("Invalid coordinates. Choose different coordinates.");
				}
			}
		}
		return board;
	}


//TODO: pass user input into strike locations on board
//TODO: check if a strike location is a hit on the opponent board

	public static char[][][] attack(char[][][] boards, int attacker, Scanner response, boolean auto) {
		boolean stillGuessing = true;
		do {
		//////
		//System.out.print("Player " + attacker + ", enter hit row/column: ");
		int rowInd;
		int colInd;
		if (auto) {
			rowInd = (int)(Math.random() * NUM_SHIPS);
			colInd = (int)(Math.random() * NUM_SHIPS);
			//System.out.println(rowInd + " " + colInd);
		}
		else {
			rowInd = response.nextInt();
			colInd = response.nextInt();
		}
		if (rowInd >= 0 && rowInd < 5 && colInd >= 0 && colInd < 5) {
			if (boards[0][rowInd][colInd] == 'X' | boards[0][rowInd][colInd] == 'O') {
				int a = 0;
				//System.out.println("\nYou've guessed that already");
			}
			else if (boards[0][rowInd][colInd] == '-') {
				boards[0][rowInd][colInd] = 'O';
				boards[1][rowInd][colInd] = 'O';
				//System.out.println("\nMiss");
				stillGuessing= false;
			}
			else if (boards[0][rowInd][colInd] == '@') {
				boards[0][rowInd][colInd] = 'X';
				boards[1][rowInd][colInd] = 'X';
				//System.out.println("\nHit");
				stillGuessing= false;
			}
			//else {System.out.println("\nSomething wrong happened");}		
		}
		/*else {
			System.out.println("\nInvalid coordinates. Choose different coordinates.");
		}*/
		//////
		}while (stillGuessing);
		//printBattleShip(boards[1]);
		return boards;
	}

//TODO: check for win scenario

	public static int[] checkScore(char[][][] boards) {
		int[] score = {0 , 0};
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (boards[0][i][j]=='X'){score[0]++;}
				else if (boards[0][i][j]=='O'){score[1]++;}
			}
		}
		return score;
		
	}


	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}