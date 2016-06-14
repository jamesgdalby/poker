package hand;

import java.util.ArrayList;

import cards.Card;

public class Hand {
	
	private Card highCard;
	
	public Hand(){
		
	}

	public Card getHighCard() {
		return highCard;
	}

	public void setHighCard(Card highCard) {
		this.highCard = highCard;
	}
	
	public ArrayList<Card>getCards(){
		return new ArrayList<Card>();
	}
	
	

}
