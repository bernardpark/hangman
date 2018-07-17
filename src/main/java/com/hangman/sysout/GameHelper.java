package com.hangman.sysout;

import static com.hangman.constant.Constants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
	public GameHelper() {
	}
	
	private String stringWordToGuess;
	private String underscoresWordToGuess;

	public void initGame() throws IOException, InterruptedException {
		clearConsole();
		System.out.println( WELCOME_MESSAGE );
		System.out.println( START_NEW_GAME );
		System.out.println( LINE_DIVIDER );
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String s = br.readLine();
		
		System.out.println( WORD_SELECTING );
		stringWordToGuess = selectRandomWord();
		underscoresWordToGuess = "";
		
		for( int i = 0; i < stringWordToGuess.length(); i++ ) {
			underscoresWordToGuess += "_";
		}
		
		guessChar( underscoresWordToGuess, 0, "" );
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

	public int guessChar( String word, int penalties, String guess ) {
		clearConsole();
		System.out.println( WORD_SELECTED );
		if ( !guess.isEmpty() ) {
    		System.out.println( "You guessed: " + guess );
		}
		else {
			System.out.println(" ");
		}
		System.out.println( word );
		if ( penalties < 1 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 2 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 3 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3_1 );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 4 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3_2 );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 5 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3 );
			System.out.println( GAME_LINE_NONE );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 6 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3 );
			System.out.println( GAME_LINE_4 );
			System.out.println( GAME_LINE_NONE );
		}
		else if ( penalties < 7 ) {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3 );
			System.out.println( GAME_LINE_4 );
			System.out.println( GAME_LINE_5_1 );
		}
		else {
			System.out.println( GAME_LINE_0 );
			System.out.println( GAME_LINE_1 );
			System.out.println( GAME_LINE_2 );
			System.out.println( GAME_LINE_3 );
			System.out.println( GAME_LINE_4 );
			System.out.println( GAME_LINE_5 );
			System.out.println( GAME_LOSE );
			return 1;
		}
		if ( stringWordToGuess.equals( word ) ) {
			System.out.println( GAME_WIN );
			return 2;
		}
		return 0;
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

}
