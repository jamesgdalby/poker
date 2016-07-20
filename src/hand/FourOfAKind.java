package hand;

import java.util.ArrayList;

import cards.Card;

public class FourOfAKind extends Hand {
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	
	public FourOfAKind(Card card1, Card card2, Card card3, Card card4){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.handRank = 7;
	}
	
	public String toString(){
		return "Four of a kind hand: " + card1 + ", " +  card2 + ", " +  card3 + ", " +  card4;
	}
	
	public ArrayList<Card>getCards(){
		ArrayList<Card> allCards = new ArrayList<Card>();
		allCards.add(card1);
		allCards.add(card2);
		allCards.add(card3);
		allCards.add(card4);
		return allCards;
	}
}
