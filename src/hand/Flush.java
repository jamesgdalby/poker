package hand;

import java.util.ArrayList;

import cards.Card;

public class Flush extends Hand{
	
	private ArrayList<Card> cards;
	
	private Card card1, card2, card3, card4, card5;
	
	public Flush(ArrayList<Card> cards){
		this.cards = cards;
		this.handRank = 5;
	}
	
	public Flush(Card card1, Card card2, Card card3, Card card4, Card card5 ){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		
		setHighCard(this.findHighestCard(cards));
		
		this.handRank = 5;
	}	
	
	@Override
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	@Override
	public String toString(){
		return "Flush hand: " + card1 + ", " +  card2 + ", " +  card3 + ", " +  card4 + ", " +  card5;
	}

}
