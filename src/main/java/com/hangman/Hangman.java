package com.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hangman.sysout.GameHelper;

public class Hangman {
    public static void main( String[] args ) throws IOException, InterruptedException {
    	// GameHelper is a class that starts the game.
    	// initGame() initializes the game and selects a random word.
    	GameHelper gameHelper = new GameHelper();
    	gameHelper.initGame();
    	
    	int penalties = 0;
    	String selectedWord = gameHelper.getStringWordToGuess();
    	String underscoredWord = gameHelper.getUnderscoresWordToGuess();
    	
    	while ( true ) {
    		// This code will take a character input from the console.
    		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    		String userInput = br.readLine();
    		
    		// YOUR CODE HERE should do the following
    		// - A boolean variable named inputIsSingleChar has been initialized.
    		//   - If userInput is empty or longer than a single character,
    		//     inputIsSingleChar must be false.
    		//   - Otherwise, inputIsSingleChar must be true.
    		// - Replace the following line.
    		// (EX.) boolean inputIsSingleChar = (YOUR CONDITIONAL EXPRESSION HERE)
    		boolean inputIsSingleChar = true;

    		if ( !inputIsSingleChar ) {
        		System.out.println( "Your input was not a single character!" );
    		}

    		else {
    			char inputCharacter = userInput.trim().charAt( 0 );
        		// YOUR CODE HERE should do the following
        		// Now, you've verified that the user input is a single character.
    			// - A char variable named inputCharacter has been initialized.
    			//   - IF selectedWord does not contain the inputCharacter
    			//     AND the inputCharacter HAS NOT already been guessed
    			//     THEN increment penalties by 1
    			//     AND print out the message "Wrong guess!"
    			//   - IF selectedWord contains the inputCharacter
    			//     AND the inputCharacter HAS NOT already been guessed
    			//     THEN replace the right underscores in underscoredWord
    			//     AND do not increment penalties
    			//     AND print out the message "Correct!"
    			//   - IF inputCharacter HAS already been guessed
    			//     THEN do not increment penalties
    			//     AND print out the message "You've already guessed that!"
    			
    			
    			int guessCode = gameHelper.guessChar( underscoredWord, penalties, userInput );
    			if ( guessCode == 1 || guessCode == 2 ) {
    				break;
    			}
    		}
    		
    	}
    }
}
