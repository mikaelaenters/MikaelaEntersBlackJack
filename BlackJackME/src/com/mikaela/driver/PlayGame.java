package com.mikaela.driver;

import java.util.Scanner;

import com.mikaela.game.BoardManager;
import com.mikaela.game.Dealer;
import com.mikaela.game.Player;

public class PlayGame {

	public static void main(String[] args) {
	BoardManager game = new BoardManager();
	//Scanner scanner = new Scanner(System.in);
	//boolean keepPlaying;
	//String response = "";
	
	//	do {
			game.startGame();
			game.createPlayers();
			game.dealPlayers();
			game.displayHand();
			game.playerMoves();
			game.dealerTurn();
			
//			System.out.println("Would you like to play another game? Enter Y/N: ");
//			response = scanner.next();
//			scanner.nextLine();
//			
//				if(response.equals("y")) {
//					keepPlaying = true;
//				}
//				else {
//					keepPlaying = false;
//				}
//		
//  if they would like to play again reset game with same players 
//		}while(keepPlaying);
		
		System.out.println("Thank You For Playing!");

	}

}