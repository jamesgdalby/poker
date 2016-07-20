package hand;

import java.util.ArrayList;

import cards.Card;

public class ThreeOfAKind extends Hand{
	
	private Card card1;
	private Card card2;
	private Card card3;
	
	public ThreeOfAKind(Card card1, Card card2, Card card3){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.handRank = 3;
	}
	
	public String toString(){
		return "Three of a kind hand: " + card1 + ", " +  card2 + ", " +  card3;
	}
	
	public ArrayList<Card>getCards(){
		ArrayList<Card> allCards = new ArrayList<Card>();
		allCards.add(card1);
		allCards.add(card2);
		allCards.add(card3);
		return allCards;
	}

}
