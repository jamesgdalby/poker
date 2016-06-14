package hand;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import cards.Card;
import cards.CardInfo;

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
		
		cards.sort(new Comparator<Card>(){

			@Override
			public int compare(Card card1, Card card2) {							
				return card1.value - card2.value;
				
			}
		});
		
		Flush flush = checkFlush(cards);
		
		if(flush != null){
			hands.add(flush);
		}
		
		Hand checkStraight = findStraight(cards, 1, cards.get(0).value, 0, 0, false);
		
		if(checkStraight != null && flush != null){
			checkStraightFlush(checkStraight);
		}
		
		
		/*if(h == null){
			h = new Hand(Hand.HAND_HIGH_CARD, HandUtil.findHighestCard(cards).value);
		}
		*/
		
		
		return null;
	}
	
	private static StraightFlush checkStraightFlush(Straight straight){
		
	}
	
	private static Flush checkFlush(ArrayList<Card> cards){
		ArrayList<Card> clubs = new ArrayList<Card>();
		ArrayList<Card> diamonds = new ArrayList<Card>();
		ArrayList<Card> hearts = new ArrayList<Card>();
		ArrayList<Card> spades = new ArrayList<Card>();
		
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i).rank.equalsIgnoreCase(CardInfo.CLUB)){
				clubs.add(cards.get(i));
			}
			if(cards.get(i).rank.equalsIgnoreCase(CardInfo.DIAMOND)){
				diamonds.add(cards.get(i));
			}
			if(cards.get(i).rank.equalsIgnoreCase(CardInfo.HEART)){
				hearts.add(cards.get(i));
			}
			if(cards.get(i).rank.equalsIgnoreCase(CardInfo.SPADE)){
				spades.add(cards.get(i));
			}
		}
		
		if(clubs.size() >= 5){
			return new Flush(clubs);
		}
		
		if(diamonds.size() >= 5){
			return new Flush(diamonds);
		}
		
		if(hearts.size() >= 5){
			return new Flush(hearts);
		}
		
		if(spades.size() >= 5){
			return new Flush(spades);
		}
		
		return null;
	}
	
	
	private static ArrayList<Straight> findStraights(ArrayList<Card> cards, int index, int previousValue, int sequenceCount, int highestSequenceIndex, boolean straightFound){
		
		// TODO recursively find all straights
		
		ArrayList<Straight> straights = new ArrayList<Straight>();
		
		if(cards.get(index).value == previousValue+1){
			sequenceCount ++;
			highestSequenceIndex = index;
			
			if (sequenceCount >= 5){
				straightFound = true;
			}
			
		} else {
			sequenceCount = 0;
		}
		
		if(index >= cards.size()){
			// determine what kind of straight we have
			// h = our new hand
			
			if(straightFound){
				Straight straight = new Straight(cards.get(highestSequenceIndex),
						cards.get(highestSequenceIndex-1),
						cards.get(highestSequenceIndex-2),
						cards.get(highestSequenceIndex-3),
						cards.get(highestSequenceIndex-4));
				
				return straight;
			} 
			
//			// return high card
//			
//			HighCard h = new HighCard(cards.get(cards.size()-1));
//			
//			return h;
			
			return null;
			
			
		} else {
		
			return findStraight(
					cards, 
					index + 1, 
					cards.get(index).value, 
					sequenceCount, 
					highestSequenceIndex, 
					straightFound
					);
		}
	
		 
	}
	
	

}













