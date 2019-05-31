package com.mikaela.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {
	
	public static List<Card> cardDeck = new ArrayList<>();    //We want the cardDeck to have only one set of cards no matter the number of players.                                                              //Holds all 52 Cards
	private final String[] cardRanks = {"Ace","Two","Three","Four","Five","Six","Seven",	  //Card ranks
			                               "Eight","Nine","Ten","Jack","Queen","King"};       
	private final String[] cardSuits = {"Clubs","Diamonds","Hearts","Spades"};                //Card suits
	public CardDeck() {
	//	cardDeck = new ArrayList<>();                    //Create cardDeck
		             
		//Populate cardDeck
		
		
		for(int i = 0; i < cardSuits.length; i++) {        									//4 cardSuits
			for(int j = 0; j < cardRanks.length; j++) {   									//13 cardRanks
				if(j == 0) {
					cardDeck.add(new Card(cardRanks[j], cardSuits[i], 11, false));
				}
				else if(j >= 10) {
					cardDeck.add(new Card(cardRanks[j], cardSuits[i], 10, false));
				}
				else {
				cardDeck.add(new Card(cardRanks[j], cardSuits[i], (j + 1), false));		//Add to cardDeck 52 new cards by value, suit, inPlay
				}
			}
			
		}
	}
}
