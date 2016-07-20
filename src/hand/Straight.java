package hand;

import java.util.ArrayList;

import cards.Card;

public class Straight extends Hand{
	
	private Card card1, card2, card3, card4, card5;
	
	public Straight(Card card1, Card card2, Card card3, Card card4, Card card5 ){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		setHighCard(card5);
		this.handRank = 4;
	}	
	
	@Override
	public ArrayList<Card> getCards(){
		return new ArrayList<Card>(){{
			add(card1);
			add(card2);
			add(card3);
			add(card4);
			add(card5);
		}};
	}
	
	public String toString(){
		return "Straight hand: " + card1 + ", " +  card2 + ", " +  card3 + ", " +  card4 + ", " +  card5;
	}
	
	

}
