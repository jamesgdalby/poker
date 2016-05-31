package hand;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import cards.Card;

public class HandUtil {
	
	public static Hand findHand(ArrayList<Card> playerCards, ArrayList<Card> boardCards){
		
		ArrayList<Card> allCards = new ArrayList<Card>();
		allCards.addAll(playerCards);
		allCards.addAll(boardCards);
		
		Card highCard = findHighestCard(allCards);
		
		
		
		return null;
	}
	
	private static Card findHighestCard(ArrayList<Card> cards){
		
		Card highestCurrentCard = cards.get(0);
		
		for(int i = 1; i < cards.size(); i++){
			if(highestCurrentCard.value > cards.get(i).value){
				highestCurrentCard = cards.get(i);
			}
		}
		
		return highestCurrentCard;
	}
	
	private static Hand getPair(ArrayList<Card> cards){
		
		HashMap<Integer, Integer> cardMap = new HashMap<Integer, Integer>();
		
		for(Card c : cards){
			Integer currentValue = cardMap.get(c.value);
			if(currentValue == null){
				cardMap.put(c.value, 1);
			} else {
				cardMap.put(c.value, cardMap.get(c.value)+1);
			}	
		}
		
		
		Hand h = null;
		
		for(Integer j : cardMap.keySet()){
			if(j == 2){
				h = new Hand(Hand.HAND_PAIR, j);
			}
		}
		
		if(h == null){
			h = new Hand(Hand.HAND_HIGH_CARD, HandUtil.findHighestCard(cards).value);
		}
		
		
		return h;
	}

}













