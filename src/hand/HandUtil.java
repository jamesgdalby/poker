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
	
	private static Hand getHand(ArrayList<Card> cards){
		
		// Check for pairs first
		
		HashMap<Integer, ArrayList<Card>> cardMap = new HashMap<Integer, ArrayList<Card>>();
		Card highCard = null;
		
		
		for(Card c : cards){
			
			if(highCard == null){
				highCard = c;
			} else if(c.value > highCard.value){
				highCard = c;
			}
			
			ArrayList<Card> currentValue = cardMap.get(c.value);
			
			if(currentValue == null){
				cardMap.put(c.value, new ArrayList<Card>());
				cardMap.get(c.value).add(c);
			} else {
				cardMap.get(c.value).add(c);
			}	
		}
		
		ArrayList<Hand> hands = new ArrayList<Hand>();
		
		for(Integer j : cardMap.keySet()){
			if(cardMap.get(j).size() == 2){
				Pair p = new Pair(cardMap.get(j).get(0), cardMap.get(j).get(1));
				hands.add(p);
			}
			
			if(cardMap.get(j).size() == 3){
				ThreeOfAKind t = new ThreeOfAKind(cardMap.get(j).get(0), cardMap.get(j).get(1), cardMap.get(j).get(2));
				hands.add(t);
			}
			
			if(cardMap.get(j).size() == 4){
				FourOfAKind f = new FourOfAKind(cardMap.get(j).get(0), cardMap.get(j).get(1), cardMap.get(j).get(2), cardMap.get(j).get(3));
				hands.add(f);
			}
		}
		
		/*if(h == null){
			h = new Hand(Hand.HAND_HIGH_CARD, HandUtil.findHighestCard(cards).value);
		}
		*/
		
		
		return null;
	}

}













