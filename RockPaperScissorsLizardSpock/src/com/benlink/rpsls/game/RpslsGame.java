package com.benlink.rpsls.game;

import com.benlink.rpsls.enums.Rpsls;
import com.benlink.rpsls.player.RpslsPlayer;

public class RpslsGame {
	private RpslsPlayer player1;
	private RpslsPlayer player2;
	
	public final int PLAY_TO_POINTS = 5;
	
	// The result of playing the game is that we return the winner
	public RpslsPlayer playGame(){
		
		do{
			switch(Rpsls.compareTo(player1.choose(), player2.choose())){
			case 0:
				System.out.println("Tie.  Nobody wins.");
				break;
			case 1:
				System.out.println(player1.getName() + " wins the round.");
				player1.scoreAPoint();
				break;
			case -1:
				System.out.println(player2.getName() + " wins the round.");
				player2.scoreAPoint();
				break;
			}
			
			System.out.println(player1.getName() + " has " + player1.getScore());
			System.out.println(player2.getName() + " has " + player2.getScore());
			
		} while (player1.getScore() < PLAY_TO_POINTS && player2.getScore() < PLAY_TO_POINTS);
		
		if(player1.getScore() > player2.getScore()){
			return player1;
		} else {
			return player2;
		}		
	}
	
	public RpslsPlayer getPlayer1() {
		return player1;
	}
	public void setPlayer1(RpslsPlayer player1) {
		this.player1 = player1;
	}
	public RpslsPlayer getPlayer2() {
		return player2;
	}
	public void setPlayer2(RpslsPlayer player2) {
		this.player2 = player2;
	}
}
