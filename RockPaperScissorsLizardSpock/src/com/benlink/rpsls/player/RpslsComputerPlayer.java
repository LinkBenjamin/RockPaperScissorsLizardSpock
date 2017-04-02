package com.benlink.rpsls.player;

import com.benlink.rpsls.enums.Rpsls;

public class RpslsComputerPlayer extends RpslsPlayer implements RpslsPlayerInterface{

	
	@Override
	public Rpsls choose() {
		int choice = (int) (Math.random() * 5);
		Rpsls response = Rpsls.LIZARD;
		
		switch(choice){
		case 0:
			response = Rpsls.ROCK;
			break;
		case 1:
			response = Rpsls.PAPER;
			break;
		case 2:
			response = Rpsls.SCISSORS;
			break;
		case 3:
			response = Rpsls.LIZARD;
			break;
		case 4:
			response = Rpsls.SPOCK;
			break;
		}
		
		System.out.println(getName() + " has chosen " + response + ".");
		
		return response;
	}


}
