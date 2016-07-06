package hand;

import java.util.ArrayList;
import java.util.Comparator;

import cards.Card;

public class Hand {
	
	private Card highCard;
	public int handRank;
	
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
	
	public Card findHighestCard(ArrayList<Card> cards){
		cards.sort(new Comparator<Card>(){

			@Override
			public int compare(Card card1, Card card2) {							
				return card1.value - card2.value;
				
			}
		});
		
		return cards.get(cards.size()-1);
	}
	
	

}
