package com.benlink.rpsls.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.benlink.rpsls.game.RpslsGame;
import com.benlink.rpsls.player.RpslsComputerPlayer;
import com.benlink.rpsls.player.RpslsPlayer;

public class Driver {
	public static final String[] NAMES = {"Sheldon", "Leonard", "Raj", "Howard", "Penny"};

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

	private static RpslsPlayer meetComputer(Scanner keyboard) {
		int randomNumber = (int) (Math.random() * NAMES.length);
		
		RpslsComputerPlayer player = new RpslsComputerPlayer();
		
		player.setName(NAMES[randomNumber]);
		player.setKeyboard(keyboard);
		
		return player;
	}

	private static RpslsPlayer meetHuman(Scanner keyboard) {
		RpslsPlayer player = new RpslsPlayer();
		
		player.setName(askUserString("Enter the name of this player: ", keyboard));
		player.setKeyboard(keyboard);
		
		return player;
	}

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
	
	private static String askUserString(String prompt, Scanner keyboard){
		System.out.print(prompt);
		return keyboard.next();
	}
}
