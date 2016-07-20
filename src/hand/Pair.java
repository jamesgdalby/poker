package hand;

import java.util.ArrayList;

import cards.Card;

public class Pair extends Hand{
	
	private Card card1;
	private Card card2;
	
	public Pair(Card card1, Card card2){
		this.card1 = card1;
		this.card2 = card2;
		this.handRank = 1;
	}
	
	public String toString(){
		return "Pair hand: " + card1 + ", " +  card2;
	}
	
	public ArrayList<Card>getCards(){
		ArrayList<Card> allCards = new ArrayList<Card>();
		allCards.add(card1);
		allCards.add(card2);
		return allCards;
	}
	
	

}
