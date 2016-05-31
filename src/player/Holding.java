package player;

import java.util.ArrayList;

import cards.Card;

public class Holding {
	
	private ArrayList<Card> cards;
	
	public Holding(){
		cards = new ArrayList<Card>(2);
	}
	
	public void addCard(Card c){
		cards.add(c);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}

}
