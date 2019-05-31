package com.mikaela.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer extends Player {
	private List<Card> dealerHand = new ArrayList<>();
	private String playerNumber;
	private int dealerHandTotal;
	private boolean canHit;
	private boolean isStanding;
	private boolean hasBlackJack;
	
	
	
	public Dealer(String playerNumber) {                          
		super(playerNumber);
		this.dealerHandTotal = 0;
		this.canHit = false;
		this.isStanding = false;
		this.hasBlackJack = false;
	}
	
	@Override
	public void setHasBlackJack(boolean hasBlackJack) {
		this.hasBlackJack = hasBlackJack;
	}
	
	@Override
	public boolean getHasBlackJack() {
		return this.hasBlackJack;
	}
	@Override
	public void setCanHit(boolean canHit) {
		this.canHit = canHit;
	}
	
	@Override
	public boolean getCanHit() {
		return this.canHit;
	}
	
	@Override
	public void setIsStanding(boolean isStanding) {
		this.isStanding = isStanding;
	}
	
	@Override
	public boolean getIsStanding() {
		return this.isStanding;
	}
	
	@Override
	public void setPlayerHand(Card newCard) {               //Set the Dealer hand 
		this.dealerHand.add(newCard);
		this.setHandTotal(newCard);  
	}
//	public void setDealerHand(List<Card> dealerHand) {                         //Getters &Setters
//		this.dealerHand = dealerHand;
//	}
	@Override
	public List<Card> getPlayerHand(){
		return this.dealerHand;
	}
	
	public static Card dealACard() {                                            //Deals cardhand to any player
		Random randomCard = new Random();
		//List<Card> cardHand = new ArrayList<>();
		Card newCard = new Card();

			for(int j = 0; j < CardDeck.cardDeck.size(); j++) {
				newCard = CardDeck.cardDeck.get(randomCard.nextInt(CardDeck.cardDeck.size())); 
				//if(!(CardDeck.cardDeck.get(j).getInPlay())) {
				 if(!(newCard.getInPlay())){
					newCard.setInPlay(true); 
					break;
				 }
			}
		
		return newCard;
	}
	
	@Override
	public void viewHand(List<Card> cardHand) { 
			System.out.println("Dealer: ");                    //Dealer First Round view 
			System.out.println("Card 1: " + cardHand.get(0).getFaceValue() + " of " + cardHand.get(0).getSuit() + ".");
			System.out.println("Card 2: is hidden.");
	}
	

	
//	@Override
//	public void setHandTotal(Card newCard){            //Calculate the total value in player hand
//		this.dealerHandTotal = super.setHandTotal(newCard);
//	}
	
	
	
	
	
}
