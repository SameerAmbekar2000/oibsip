package java_internship_task2;

import java.util.Scanner;
import java.util.Random;

class Guess_Number {
	
	int System_Input;
	int User_Input;
	int No_Of_Guesses = 0;
	
	// generating random number using default constructor
	Guess_Number() {
		Random ran = new Random();
		this.System_Input = ran.nextInt(100) + 1;
	}
	
	
	// method to take user guesses
	public boolean takeUserInput() {
		if ( No_Of_Guesses < 10 ) {
			System.out.print("\n Guess the number that I thought : ");
			this.User_Input = GuessTheNumber.takeIntegerInput(100);
			No_Of_Guesses++;
			return false;
		}
		else {
			System.out.println("\n Game Over!! Number of attempts got finished \n");
			return true;
		}
	}
	
	
	//method to check user guess status
	public boolean isCorrectGuess() {
		
		if ( System_Input == User_Input ) {
			System.out.println(" Congratulations!!!  You guessed the number " + System_Input +
			" in " + No_Of_Guesses + " guesses");
			switch(No_Of_Guesses) {
				case 1:
				System.out.println(" Your score for this Round is 100 ");
				break;
				case 2:
				System.out.println(" Your score for this Round is 90 ");
				break;
				case 3:
				System.out.println(" Your score for this Round is 80 ");
				break;
				case 4:
				System.out.println(" Your score for this Round is 70 ");
				break;
				case 5:
				System.out.println(" Your score for this Round is 60 ");
				break;
				case 6:
				System.out.println(" Your score for this Round is 50 ");
				break;
				case 7:
				System.out.println(" Your score for this Round is 40 ");
				break;
				case 8:
				System.out.println(" Your score for this Round is 30 ");
				break;
				case 9:
				System.out.println(" Your score for this Round is 20 ");
				break;
				case 10:
				System.out.println(" Your score for this Round is 10 ");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( No_Of_Guesses < 10 && User_Input > System_Input ) {
			if ( User_Input - System_Input > 10 ) {
				System.out.println(" The Number entered is too High ");
			}
			else {
				System.out.println(" The Number entered is little High ");
			}
		}
		else if ( No_Of_Guesses < 10 && User_Input < System_Input ) {
			if ( System_Input - User_Input > 10 ) {
				System.out.println(" The Number entered is too low ");
			}
			else {
				System.out.println(" The Number entered is little low");
			}
		}
		return false;
	}
}

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
