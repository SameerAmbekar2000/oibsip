package java_internship_task2;

import java.util.Scanner;

public class GuessTheNumber {

	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("\n Please choose the number between 1 to " + limit);
				    System.out.print("\t");
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println(" Enter only the integer values");
				flag = false;
			}
		};
		return input;
	}
	
	// main method
	public static void main(String[] args) {
		
		// input for start the game
		System.out.println("\n************************ WELCOME TO THE NUMBER GUESSING GAME ************************ \n");
		System.out.println("\n *********** GAME MENU *********** ");
		System.out.println(" 1. Start the Game \n 2. Exit the Game \n ");
		System.out.print("\n Enter your choice : \n ");
		int choice =  takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			// to check next round is there or not
			while ( nextRound == 1 ) {
				// creating object of Game class
				Guess_Number game = new Guess_Number();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println(" ROUND " + ++noOfRound + " STARTED...");
				
				// to check correct guess and limit cross
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				// input for next round
				System.out.print("\n Do you want to continue to the next round ?? \n");
				System.out.println("\n 1. Next Round \n 2. Exit \n");
				System.out.println(" Enter your choice : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
