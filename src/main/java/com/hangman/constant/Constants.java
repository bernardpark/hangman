package com.hangman.constant;

public class Constants {
	public final static int MAX_LINE_LENGTH = 100;
	
	public final static String WELCOME_MESSAGE = "Welcome to Hangman!";
	public final static String START_NEW_GAME = "Hit Enter to start new game";
	
	public final static String WORD_SELECTING = "Selecting random word...";
	public final static String GUESSES_LEFT = "Guesses left: ";
	public final static String CHAR_GUESS = "    Guess a character!    ";
	public final static String CHAR_CORRECT = "Correct! You guessed: ";
	public final static String CHAR_INCORRECT = "Incorrect! You guessed: ";
	public final static String CHAR_DUPLICATE = "You already guessed: ";
	public final static String CHAR_INVALID =   "Your input was not a single character!";
	public final static String CHAR_INCORRECT_LIST = "Incorrect guesses: ";
	
	public final static String GAME_LINE_0 = "..........";
	public final static String GAME_LINE_1 = "|        |";
	public final static String GAME_LINE_2 = "|        O";
	public final static String GAME_LINE_3 = " |       /|\\";
	public final static String GAME_LINE_4 = "|        |";
	public final static String GAME_LINE_5 = " |       / \\";
	
	public final static String GAME_LINE_NONE = "|         ";
	public final static String GAME_LINE_3_1 = "|        |";
	public final static String GAME_LINE_3_2 = "|       /|";
	public final static String GAME_LINE_5_1 = "|       / ";

	public final static String GAME_WIN_1 = "Congratulations!";
	public final static String GAME_WIN_2 = "You saved Hangman!";
	public final static String GAME_LOSE = "Hangman Died!";
	public final static String GAME_LOSE_ANSWER = "Correct answer was: ";

	public final static String C_NEW_GAME = "C_NEW_GAME";
	public final static String C_CORRECT_GUESS = "C_CORRECT_GUESS";
	public final static String C_INCORRECT_GUESS = "C_INCORRECT_GUESS";
	public final static String C_DUPLICATE_GUESS = "C_DUPLICATE_GUESS";
	public final static String C_INVALID_GUESS = "C_INVALID_GUESS";

	public final static String C_CONTINUE_GAME = "C_CONTINUE_GAME";
	public final static String C_WIN_GAME = "C_WIN_GAME";
	public final static String C_LOSE_GAME = "C_LOSE_GAME";
	
	public static void bufferLoad( String character, int sleep ) {
		for ( int i = 0; i < MAX_LINE_LENGTH; i ++ ) {
			System.out.print( character );
			try {
				Thread.sleep( sleep );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static String lineDivider( String character, String message, boolean includeEdges ) {
		String returnString = "";
		int lineLength = MAX_LINE_LENGTH;
		
		if ( character.isEmpty() ) {
			character = " ";
		}
		
		if ( includeEdges ) {
			lineLength = lineLength - 4;
			returnString = returnString + "||";
			if ( message.isEmpty() ) {
				for ( int i = 0; i < lineLength; i ++ ) {
					returnString = returnString + character;
				}
			}
			else {
				int messageLength = message.length();
				int padLength = lineLength - messageLength;
				int padLeftLength = padLength / 2;
				int padRightLength = padLength - padLeftLength;
				for ( int i = 0; i < padLeftLength; i ++ ) {
					returnString = returnString + character;
				}
				returnString = returnString + message;
				for ( int i = 0; i < padRightLength; i ++ ) {
					returnString = returnString + character;
				}
			}
			returnString = returnString + "||";
		}
		
		else {
			if ( message.isEmpty() ) {
				for ( int i = 0; i < lineLength; i ++ ) {
					returnString = returnString + character;
				}
			}
			else {
				int messageLength = message.length();
				int padLength = lineLength - messageLength;
				int padLeftLength = padLength / 2;
				int padRightLength = padLength - padLeftLength;
				for ( int i = 0; i < padLeftLength; i ++ ) {
					returnString = returnString + character;
				}
				returnString = returnString + message;
				for ( int i = 0; i < padRightLength; i ++ ) {
					returnString = returnString + character;
				}
			}
		}
		return returnString;
	}
}
