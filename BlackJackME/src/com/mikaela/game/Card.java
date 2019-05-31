package com.mikaela.game;

public class Card {
	private String faceValue;                      //Card Characteristics
	private String suit;
	private int cardValue;
	private boolean inPlay;
	
	
	public void setFaceValue(String faceValue) {              //Getters &Setters
		this.faceValue = faceValue;
	}
	
	public String getFaceValue() {
		return this.faceValue;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public int getCardValue(){
		return this.cardValue;
	}
	
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
	
	public void setInPlay(boolean inPlay) {
		this.inPlay = inPlay;
	}
	
	public boolean getInPlay() {
		return this.inPlay;
	}
	
	public Card() {}
	public Card (String faceValue, String suit, int cardValue, boolean inPlay) {            //Creating a Card
		this.faceValue = faceValue;
		this.suit = suit;
		this.cardValue = cardValue;
		this.inPlay = inPlay;
	}
	
	
}
