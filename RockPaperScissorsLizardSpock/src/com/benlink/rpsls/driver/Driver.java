package com.benlink.rpsls.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.benlink.rpsls.game.RpslsGame;
import com.benlink.rpsls.player.RpslsComputerPlayer;
import com.benlink.rpsls.player.RpslsPlayer;

/**
 * Drivers gonna drive
 * 
 * @author Ben Link
 *
 */
public class Driver {
	public static final String[] NAMES = {"Sheldon", "Leonard", "Raj", "Howard", "Penny"};

    /**
     * As in, the whole Spanish Main, savvy?
     * 
     * @param args You know.  Arrrgs.
     */
    public static void main(String[] args) {
    	
    	// Initialize stuffs
    	Scanner keyboard = new Scanner(System.in);
    	boolean stillPlaying = true;
    	
    	// Main Game Loop
    	do{
        	//   Who's playing?
    		List<String> values = new ArrayList<String>();
    		values.add("Two Humans");
    		values.add("Two Computers");
    		values.add("Human vs Computer ULTIMATE SHOWDOWN");
        	
    		int gameType = askUserNumeric("Who's playing?", values, keyboard);
    		
    		RpslsGame game = new RpslsGame();
    		
    		switch(gameType){
    		case 1:
    			game.setPlayer1(meetHuman(keyboard));
    			game.setPlayer2(meetHuman(keyboard));
    			break;
    		case 2:
    			game.setPlayer1(meetComputer(keyboard));
    			game.setPlayer2(meetComputer(keyboard));
    			break;
    		case 3:
    			game.setPlayer1(meetHuman(keyboard));
    			game.setPlayer2(meetComputer(keyboard));
    			break;
    		}
    		
        	RpslsPlayer winner = game.playGame();
        	
        	System.out.println(winner.getName() + " is the first to 5 points!");
        	
    		stillPlaying = askUserBoolean("Do you want to play again? (y/n) : ", keyboard);
    		
    	} while(stillPlaying); 
    	
    	keyboard.close();
    }

	/**
	 * Arr, this be a way to meet a new Computerized player.
	 * He randomly picks his name from the list.
	 * 
	 * @param keyboard Unused, but passed in anyway for completeness' sake
	 * @return The new player.
	 */
	private static RpslsPlayer meetComputer(Scanner keyboard) {
		int randomNumber = (int) (Math.random() * NAMES.length);
		
		RpslsComputerPlayer player = new RpslsComputerPlayer();
		
		player.setName(NAMES[randomNumber]);
		player.setKeyboard(keyboard);
		
		return player;
	}

	/**
	 * Avast, this be how ye meet a new landlubber!
	 * 
	 * @param keyboard Here be how he tells ye his name
	 * @return The player object
	 */
	private static RpslsPlayer meetHuman(Scanner keyboard) {
		RpslsPlayer player = new RpslsPlayer();
		
		player.setName(askUserString("Enter the name of this player: ", keyboard));
		player.setKeyboard(keyboard);
		
		return player;
	}

	/**
	 * Ask a question.  Get a yes or a no for an answer
	 * 
	 * @param prompt 
	 * @param keyboard
	 * @return yes or no = true or false
	 */
	private static boolean askUserBoolean(String prompt, Scanner keyboard) {
		boolean valid = false;
		boolean returnValue = false;
		
		do{
			System.out.print(prompt);
			String response = keyboard.next();
			
			if(response.substring(0, 1).toUpperCase().equals("Y")){
				valid = true;		
				returnValue = true;
				break;
			}
			
			if(response.substring(0, 1).toUpperCase().equals("N")){
				valid = true;
				returnValue = false;
				break;
			}
			
			System.out.println("Hard to follow directions, eh?  Try again, doofus.");
			
		} while (!valid);
		
		return returnValue;
	}

	/**
	 * Ask for a choice, send a list of possible responses, get back a number.  
	 * 
	 * @param prompt
	 * @param values
	 * @param keyboard
	 * @return the choice
	 */
	private static int askUserNumeric(String prompt, List<String> values, Scanner keyboard){
		boolean valid = false;
		int returnValue = 0;
		
		do{
			System.out.println(prompt);
			
			int i=0;
			for(String value: values){
				System.out.println(++i + " - " + value);
			}
			
			int response = keyboard.nextInt();
			keyboard.nextLine();
			
			if(response > 0 && response <= i){
			
				returnValue = response;
				valid = true;
			
			} else {
				
				System.out.println("You really don't follow directions well, do you...");
				
			}
			
		} while (!valid);
		
		return returnValue;
	}
	
	/**
	 * Ask a user for a string of text, and he'll give it to ye
	 * 
	 * @param prompt
	 * @param keyboard
	 * @return the string
	 */
	private static String askUserString(String prompt, Scanner keyboard){
		System.out.print(prompt);
		return keyboard.next();
	}
}
