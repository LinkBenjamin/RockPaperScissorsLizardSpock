package com.benlink.rpsls.player;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.benlink.rpsls.enums.Rpsls;

public class RpslsPlayer implements RpslsPlayerInterface{
	private String name;
	private int score;
	private Scanner keyboard;
	
	public RpslsPlayer(){
		name = "";
		score = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void scoreAPoint() {
		this.score++;
	}

	public Scanner getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	@Override
	public Rpsls choose() {
		boolean valid = false;
		Rpsls result = Rpsls.ROCK;
		
		do{
			
			System.out.print(getName() + ", make your choice (Rock, Paper, Scissors, Lizard, Spock) : ");
			String response = getKeyboard().next();
			
			response = response.trim().toUpperCase();
						
			try{
				result = Rpsls.valueOf(response);
				valid = true;
			} catch (IllegalArgumentException illegalArg) {
				System.out.println("You, uh, have to pick from the list, genius.");
			} catch (NoSuchElementException noSuch){
				System.out.println("You'll need to try that again.  That wasn't one of the choices.");
			} catch (NullPointerException nullPointer){
				System.out.println("You seem to misunderstand.  You have to pick one...");
			}
			
		} while (!valid);
		
		System.out.println(getName() + " has chosen " + result + ".");
		
		return result;
	}
}
