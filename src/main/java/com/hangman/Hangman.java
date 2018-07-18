package com.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.hangman.sysout.GameHelper;
import static com.hangman.constant.Constants.*;

public class Hangman {
	public static void main( String[] args ) throws IOException, InterruptedException {
		// GameHelper is a class that starts the game.
		// initGame() initializes the game and selects a random word.
		GameHelper gameHelper = new GameHelper();
		gameHelper.initGame();

		// These are variables used to run the code as intended.
		// You will be modifying penalties and underscored word.
		int penalties = 0;
		String selectedWord = gameHelper.getStringWordToGuess();
		String underscoredWord = gameHelper.getUnderscoresWordToGuess();
		String guessCode = new String();

		// These are example data types that can help find your solution.
		// You are welcome to use these, or create more as needed.
		// If written efficiently, you will not need any more than these.
		Set<Character> correctChars = new HashSet<Character>();
		Set<Character> incorrectChars = new HashSet<Character>();
		Set<Integer> correctIndeces = new HashSet<Integer>();
		char[] wordChars = selectedWord.toCharArray();
		
		// This helps the game understand what you've
		gameHelper.setIncorrectGuesses( incorrectChars );

		while ( true ) {
			// This code will take a character input from the console.
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
			String userInput = br.readLine();

			// YOUR CODE HERE should do the following
			// - A boolean variable named inputIsSingleChar has been initialized.
			//   - If userInput is empty or longer than a single character,
			//     inputIsNotSingleChar must be true.
			//   - Otherwise, inputIsNotSingleChar must be true.
			// - Replace the following line.
			// (EX.) boolean inputIsNotSingleChar = (YOUR CONDITIONAL EXPRESSION HERE)
			boolean inputIsNotSingleChar = true;

			if ( inputIsNotSingleChar ) {
				guessCode = gameHelper.invalidGuess( underscoredWord, penalties, userInput );
			}

			else {
				char inputCharacter = userInput.trim().charAt( 0 );
				// YOUR CODE HERE should do the following
				// Now, you've verified that the user input is a single character.
				// - A char variable named inputCharacter has been initialized.
				//   - IF inputCharacter HAS already been guessed
				//     THEN write guessCode = gameHelper.duplicateGuess( underscoredWord, penalties, userInput );
				//   - IF inputCharacter HAS NOT already been guessed
				//     AND selectedWord DOES NOT CONTAIN the inputCharacter
				//     THEN increment penalties by 1
				//     AND write guessCode = gameHelper.incorrectGuess( underscoredWord, penalties, userInput );
				//   - IF inputCharacter HAS NOT already been guessed
				//     AND selectedWord DOES CONTAIN the inputCharacter
				//     THEN replace the right underscores in underscoredWord
				//     AND do not increment penalties
				//     AND write guessCode = gameHelper.correctGuess( underscoredWord, penalties, userInput );
			}

			if ( guessCode.equals( C_WIN_GAME ) || guessCode.equals( C_LOSE_GAME ) ) {
				break;
			}
		}
	}
}
