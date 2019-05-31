package com.mikaela.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardManager {
	public Dealer dealer;
	public List<Player> playerList;
	public static int turnNumber;
	public int size;
	public BoardManager() {
		CardDeck cardDeck = new CardDeck();
		playerList = new ArrayList<>();
		turnNumber = 0;
	}
	
	//Start Game;
	public void startGame() {
		System.out.println("Welcome To BlackJack!");          //Welcome Statement
		System.out.println("BlackJack can be played"            //Set number of players
					+ " with up to 4 players.");
	}
	
	//Get Number Of Players;
	public int getNumberOfPlayers() {
		Scanner scanner = new Scanner(System.in);       //Input from console
		int numberOfPlayers;
		String input;	
		boolean validInput = false;                          //Need user to enter a valid numberOfPlayers	
			
		do {
			System.out.println("Please enter the number of players: ");
			
			while(!(scanner.hasNextInt())) {
					System.out.println("Please enter a valid number of Players(1-4): ");
					scanner.next();
				}
					
				numberOfPlayers = scanner.nextInt();
				scanner.nextLine();
					
				if (numberOfPlayers > 4 || numberOfPlayers < 1) {
					System.out.print("You enterd " + numberOfPlayers 
								     + ". Please enter a valid number of Players(1-4): ");
					}
				else {
					validInput = true;
				}
			}while(!validInput);              
		
		return numberOfPlayers;
		}
			
		//Create Players;
		public void createPlayers() {
			
			int numberOfPlayers = getNumberOfPlayers();
			
			for(int i = 0; i <= numberOfPlayers; i++) {           //Add the numberOfPlayers and Dealer to the list 
				
				if(i < numberOfPlayers) {
					playerList.add(new Player("Player #" + (i + 1)));
				}
				else {
					playerList.add(new Dealer("Dealer"));              //Create a new player each time with the playerNumber (Players 1-4);
				}
			}
			this.size = numberOfPlayers;
		}
			
		//Deal Players;
		public void dealPlayers() {
			int dealCount = 0;
			
			while(dealCount < playerList.size() * 2) {
				for(int i = 0; i < playerList.size(); i++) {
					playerList.get(i).setPlayerHand(Dealer.dealACard());                //Deals everyone including the dealer a cardHand
					dealCount++;
				}
			}
		}
			
		//View All Player Hands &Add Hand Total;
		public void displayHand() {
			for(int i = 0; i < playerList.size(); i++) {
				playerList.get(i).viewHand(playerList.get(i).getPlayerHand());              //Dealer MUST have first card hidden at the start
			}
		}
		
			
		//Check First IF Any Players Can Split;
			
//			for(int i = 0; i < playerList.size()-1; ) {                                    //Iterates over each player
//				//for(int j = 0; j < playerList.get(i).getPlayerHand().size(); j++) {        //Iterates over each players cardHand
//					if(playerList.get(i).getPlayerHand().get(0).getCardValue() == playerList.get(i).getPlayerHand().get(1).getCardValue()) {
//						System.out.println("Both of your cards have a value of " + playerList.get(i).getPlayerHand().get(0).getCardValue() + "!");
//						System.out.println("Do you want to split your cards? Enter Y/N: ");  
//						//TODO USE SCANNER HERE GET INPUT GO EITHER WAY 
//				}
//				
//	
//			}
//			
//			
//		//Evaluate Possible Moves;
//		public void whatIsNext() {
//			for(int i = 0; i < playerList.size() - 1; i++) {
//				if(playerList.get(i).getHandTotal() < 21) {         //If they can HIT or STAND
//					playerList.get(i).setCanHit(true);
//				}
//				else
//				
//			}	
			
		//}
		
		
//		//After Split, Hit &Stand;
		public void playerMoves() {
			String move = "";
			
		
			for(int i = 0; i < playerList.size() - 1; i++ ) { 
				do {
					System.out.println("------- " + playerList.get(i).getPlayerNumber() + " -------");
					move = hitStandPrompt();
					
					if(move.equals("hit")) {
						playerList.get(i).hit();          //HIT first 
							
						if(playerList.get(i).getHandTotal() < 21) {         //If they can HIT or STAND
								playerList.get(i).setCanHit(true);
							}
						else if(playerList.get(i).getHandTotal() > 21) {   //If they bust
								System.out.println("You busted!");
								playerList.get(i).setCanHit(false);
							}
						else {                                             //If they get 21
								System.out.println("You got Black Jack!");
								playerList.get(i).setCanHit(false);
								playerList.get(i).setHasBlackJack(true);
							}
						}
					
					else if(move.equals("stand")) {
						playerList.get(i).stand();
					}
				}while(playerList.get(i).getCanHit()); //|| !(playerList.get(i).getIsStanding()));
			}
		}
		
		//HELPER METHOD 	
			public String hitStandPrompt() {	
				Scanner scanner = new Scanner(System.in);       //Input from console
				String input = "";
				String move = "";
				boolean validInput = false;
				
					System.out.println("Do you want to HIT or STAND? Enter H/S: ");
					input = scanner.next();
					scanner.nextLine();
					
					do {
						if (input.equals("h") || input.equals("H")) {             //HIT
							validInput = true;
							move = "hit";
						}
						else if (input.equals("s") || input.equals("S")){         //STAND
							validInput = true;
							move = "stand";
						}
						else {
							System.out.println("Please enter H to hit or S to stand: ");
							input = scanner.next();
							scanner.nextLine();
						}
					}while(!validInput);	
				
				return move;
				
			}                                       
			
			
//		//Evaluate If Players Can Still HIT;
//		public void otherPossibleMoves() {
//			String move = "";
//			boolean stop = false;
//			
//			do {
//				for(int i = 0; i < playerList.size() - 1; i++) {
//					if(!(playerList.get(i).getIsStanding()) && playerList.get(i).getCanHit()) {
//						System.out.println("------- " + playerList.get(i).getPlayerNumber() + " -------");
//						move = hitStandPrompt();
//						
//						if(move.equals("hit")) {
//							playerList.get(i).hit();          //HIT first 
//								if(playerList.get(i).getHandTotal() < 21) {         //If they can HIT or STAND
//									playerList.get(i).setCanHit(true);
//								}
//								else if(playerList.get(i).getHandTotal() > 21) {   //If they bust
//									System.out.println("You busted!");
//									playerList.get(i).setCanHit(false);
//								}
//								else {                                             //If they get 21
//									System.out.println("You got Black Jack!");
//									playerList.get(i).setCanHit(false);
//								}
//							}
//						
//						else if(move.equals("stand")) {
//							playerList.get(i).stand();
//						}
//					}
//				}
//			}
//		
	
		//Dealer Hit Or Stand Based On Dealer Moves;
			public void dealerTurn() {	
				System.out.println("------- " + playerList.get(size).getPlayerNumber() + " -------");
				
				for(int i = 0; i < playerList.get(size).getPlayerHand().size(); i++) {
					System.out.println("Card " + (i + 1) + ": " + playerList.get(size).getPlayerHand().get(i).getFaceValue() + " of " + playerList.get(playerList.size() - 1).getPlayerHand().get(i).getSuit() + ".");
				}
				
				System.out.println("The hand total for " + playerList.get(size).getPlayerNumber() + " is " + playerList.get(playerList.size() - 1).getHandTotal() + ".");
			
//				do {
//					if(playerList.get(size).getHandTotal() < 16) {
//						playerList.get(size).hit();
//					}
//					else if (playerList.get(size).getHandTotal() >= 16) {
//						playerList.get(size).stand();
//					}
//					else {
//						System.out.println("The Dealer Has Black Jack!");
//						playerList.get(size).setHasBlackJack(true);//Dealer Has Black Jack
//					}
//				}while(playerList.get(size).getHandTotal() < 16); //|| playerList.get(playerList.size() - 1).getHandTotal() >= 21);
//			}
			}
			
			
//		//Display All Current Scores;
//			
//			public void displayCurrentGame() {
//				for(int i = 0; i < playerList.size() - 1; i++) {
//					System.out.println("------- " + playerList.get(i).getPlayerNumber() + " -------");
//					System.out.println(playerList.get(i).getPlayerNumber() + " : " + playerList.get(i).getHandTotal());
//					System.out.println(playerList.get(size).getPlayerNumber() + " : " + playerList.get(size).getHandTotal());
//					
//					if(playerList.get(i).getHandTotal() 
//					
//				}
//			}
//			
//		//Display Losses;
//			public void gameResults() {
//				if()
//			}
			
		//Calculate Game Points;	
			
		//Continue or Exit?
		
			//RESET!!!!!!
			
			
	
	
}
