package com.mikaela.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mikaela.game.Dealer;
public class Player {
	private List<Card> playerHand = new ArrayList<>();
	private int handTotal;
	private String playerNumber;
	private boolean canHit;
	private boolean isStanding;
	private boolean hasBlackJack;
	private boolean win;
	private boolean tie;
	
	public Player(String playerNumber) {
		this.playerNumber = playerNumber;
		this.handTotal = 0;
		this.canHit = false;
		this.isStanding = false;
		this.hasBlackJack = false;
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}
	
	public boolean getWin() {
		return this.win;
	}
	
	public void setTie(boolean tie) {
		this.tie = tie;
	}
	
	public boolean getTie() {
		return this.tie;
	}
	
	public void setHasBlackJack(boolean hasBlackJack) {
		this.hasBlackJack = hasBlackJack;
	}
	
	public boolean getHasBlackJack() {
		return this.hasBlackJack;
	}
	
	public void setCanHit(boolean canHit) {
		this.canHit = canHit;
	}
	
	public boolean getCanHit() {
		return this.canHit;
	}
	
	public void setIsStanding(boolean isStanding) {
		this.isStanding = isStanding;
	}
	
	public boolean getIsStanding() {
		return this.isStanding;
	}
	
	public void setPlayerHand(Card newCard) {               //Getters &Setters
		this.playerHand.add(newCard);
		this.setHandTotal(newCard);                         //Adds the total with each card added to hand
	}
	
	public List<Card> getPlayerHand(){
		return this.playerHand;
	}
	
	public void setHandTotal(Card newCard){            //Calculate the total value in player hand
		this.handTotal = this.handTotal + newCard.getCardValue();
	}
	
	public int getHandTotal() {
		return this.handTotal;
	}
	
	public String getPlayerNumber() {
		return this.playerNumber;
	}
	
	
	//METHODS;
	
	public void viewHand(List<Card> cardHand) {
		System.out.println(this.getPlayerNumber() + ": "); 
			//if(cardHand.size() == 2) {                                     //For beginning view
				//if(this.getPlayerNumber().equals("Dealer")) {
//					System.out.println("Card 1: " + cardHand.get(0).getFaceValue() + " of " + cardHand.get(0).getSuit() + ".");
//					System.out.println("Card 2: is hidden.");
//				}
//				
//				else {
					for(int i = 0; i < cardHand.size(); i++) {
						System.out.println("Card " + (i + 1) + ": " + cardHand.get(i).getFaceValue() + " of " + cardHand.get(i).getSuit() + ".");
					//}
				}
				System.out.println("The hand total for " + this.getPlayerNumber() + " is " + this.getHandTotal() + ".");
			//}
	}
	
	
	
	public void stand() {
		this.setIsStanding(true);
		this.setCanHit(false);
	}
	
	
	public void hit() {
		this.setPlayerHand(Dealer.dealACard());          //Adds the card to the playerHand and sets the handTotal
		System.out.println(this.getPlayerNumber() + " Hit and Received: " + this.getPlayerHand().get(playerHand.size()-1).getFaceValue() + " of " + this.getPlayerHand().get(playerHand.size()-1).getSuit());
		System.out.println("Your hand total is now " + this.getHandTotal() + ".");
	}
//	public List<Card> hit(List<Card> cardHand){
//		Random randomCard = new Random();
//
//		List<Card> tempCardHand = new ArrayList<>();
//				
//			for(int j = 0; j < CardDeck.cardDeck.size(); j++) {
//					if(!(CardDeck.cardDeck.get(j).getInPlay())){
//						tempCardHand.add(CardDeck.cardDeck.get(j));
//					}
//			}
//				
//			Card newCard = tempCardHand.get(randomCard.nextInt(tempCardHand.size()));      
//		
//			newCard.setInPlay(true);
//			
//			cardHand.add(newCard);
//			
//			//this.setHandTotal(cardHand);                           //Sets the new handTotal after a player hits. 
//			
//			return cardHand;
//	}
//	
	
	
}
