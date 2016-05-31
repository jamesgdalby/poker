package table;

import java.util.ArrayList;

import cards.Card;

public class Board {
	
	private ArrayList<Card> cards;
	
	public Board(){
		cards = new ArrayList<Card>(5);
	}
	
	public void addCard(Card c){
		cards.add(c);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}

}
