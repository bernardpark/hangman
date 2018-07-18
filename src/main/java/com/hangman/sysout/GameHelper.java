package com.hangman.sysout;

import static com.hangman.constant.Constants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameHelper {
	public GameHelper() {
	}
	
	private String stringWordToGuess;
	private String underscoresWordToGuess;
	private Set<Character> incorrectGuesses = new HashSet<Character>();

	public void initGame() throws IOException, InterruptedException {
		clearConsole();
		System.out.println( lineDivider( "-", "", false ) );
		System.out.println( lineDivider( "*", "", true ) );
		System.out.println( lineDivider( "#", "", true ) );
		System.out.println( lineDivider( "-", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", WELCOME_MESSAGE, true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", START_NEW_GAME, true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "-", "", true ) );
		System.out.println( lineDivider( "#", "", true ) );
		System.out.println( lineDivider( "*", "", true ) );
		System.out.println( lineDivider( "-", "", false ) );
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String s = br.readLine();

		System.out.println( lineDivider( "", WORD_SELECTING, false ) );
		bufferLoad( "%", 10 );
		
		stringWordToGuess = selectRandomWord();
		underscoresWordToGuess = "";
		
		for( int i = 0; i < stringWordToGuess.length(); i++ ) {
			underscoresWordToGuess += "_";
		}
		
		guessChar( underscoresWordToGuess, 0, "", C_NEW_GAME );
	}
	
	public void initialGuess() {
		guessChar( underscoresWordToGuess, 0, "", C_NEW_GAME );
	}
	
	public String correctGuess( String word, int penalties, String guess ) {
		return guessChar( word, penalties, guess, C_CORRECT_GUESS );
	}
	
	public String incorrectGuess( String word, int penalties, String guess ) {
		return guessChar( word, penalties, guess, C_INCORRECT_GUESS );
	}
	
	public String duplicateGuess( String word, int penalties, String guess ) {
		return guessChar( word, penalties, guess, C_DUPLICATE_GUESS );
	}
	
	public String invalidGuess( String word, int penalties, String guess ) {
		return guessChar( word, penalties, guess, C_INVALID_GUESS );
	}

	public String guessChar( String word, int penalties, String guess, String guessCode ) {
		clearConsole();
		System.out.println( lineDivider( "#", "", false ) );
		System.out.println( lineDivider( "*", CHAR_GUESS, false ) );
		System.out.println( lineDivider( "#", "", false ) );
		System.out.println( lineDivider( "-", GUESSES_LEFT + ( 7 - penalties ), true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "-", incorrectCharsMessage(), true ) );
		System.out.println( lineDivider( "", "", true ) );
		if ( guessCode.equals( C_NEW_GAME ) ) {
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( guessCode.equals( C_CORRECT_GUESS ) ) {
			System.out.println( lineDivider( "", CHAR_CORRECT + guess, true ) );
		}
		else if ( guessCode.equals( C_INCORRECT_GUESS ) ) {
			System.out.println( lineDivider( "", CHAR_INCORRECT + guess, true ) );
		}
		else if ( guessCode.equals( C_DUPLICATE_GUESS ) ) {
			System.out.println( lineDivider( "", CHAR_DUPLICATE + guess, true ) );
		}
		else if ( guessCode.equals( C_INVALID_GUESS ) ) {
			System.out.println( lineDivider( "", CHAR_INVALID, true ) );
		}
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "-", "", true ) );
		System.out.println( lineDivider( "", "", true ) );
		System.out.println( lineDivider( "", word, true ) );
		System.out.println( lineDivider( "", "", true ) );
		if ( penalties < 1 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 2 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 3 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 4 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 5 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 6 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3, true ) );
			System.out.println( lineDivider( "", GAME_LINE_4, true ) );
			System.out.println( lineDivider( "", GAME_LINE_NONE, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else if ( penalties < 7 ) {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3, true ) );
			System.out.println( lineDivider( "", GAME_LINE_4, true ) );
			System.out.println( lineDivider( "", GAME_LINE_5_1, true ) );
			System.out.println( lineDivider( "", "", true ) );
			System.out.println( lineDivider( "", "", true ) );
		}
		else {
			System.out.println( lineDivider( "", GAME_LINE_0, true ) );
			System.out.println( lineDivider( "", GAME_LINE_1, true ) );
			System.out.println( lineDivider( "", GAME_LINE_2, true ) );
			System.out.println( lineDivider( "", GAME_LINE_3, true ) );
			System.out.println( lineDivider( "", GAME_LINE_4, true ) );
			System.out.println( lineDivider( "", GAME_LINE_5, true ) );
			System.out.println( lineDivider( "", GAME_LOSE, true ) );
			System.out.println( lineDivider( "", GAME_LOSE_ANSWER + stringWordToGuess, true ) );
			System.out.println( lineDivider( "#", "", false ) );
			return C_LOSE_GAME;
		}
		if ( stringWordToGuess.equals( word ) ) {
			System.out.println( lineDivider( "", GAME_WIN_1, true ) );
			System.out.println( lineDivider( "", GAME_WIN_2, true ) );
			System.out.println( lineDivider( "#", "", false ) );
			return C_WIN_GAME;
		}
		System.out.println( lineDivider( "#", "", false ) );
		return C_CONTINUE_GAME;
	}
	
	private static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println( "" );
		}
	}

	private String selectRandomWord() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource( "words.txt" ).getFile());
		
		Scanner sc = new Scanner( file );
		int counter = 0;
		while ( sc.hasNextLine() ) {
			sc.nextLine();
			counter++;
		}
		
        Random rand = new Random();
        int randInt = rand.nextInt( counter );
		
		sc = new Scanner( file );
		counter = 0;
		while ( counter < randInt ) {
			sc.nextLine();
			counter++;
		}
		
		return sc.nextLine().trim();
	}
	
	private String incorrectCharsMessage() {
		String returnString = CHAR_INCORRECT_LIST;
		boolean firstChar = true;
		for ( char c : incorrectGuesses ) {
			if ( !firstChar ) {
				returnString = returnString + ", ";
			}
			returnString = returnString + c;
			firstChar = false;
		}
		return returnString;
	}

	public String getStringWordToGuess() {
		return stringWordToGuess;
	}

	public void setStringWordToGuess(String stringWordToGuess) {
		this.stringWordToGuess = stringWordToGuess;
	}

	public String getUnderscoresWordToGuess() {
		return underscoresWordToGuess;
	}

	public void setUnderscoresWordToGuess(String underscoresWordToGuess) {
		this.underscoresWordToGuess = underscoresWordToGuess;
	}

	public Set<Character> getIncorrectGuesses() {
		return incorrectGuesses;
	}

	public void setIncorrectGuesses(Set<Character> incorrectGuesses) {
		this.incorrectGuesses = incorrectGuesses;
	}

}
