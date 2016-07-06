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
		
		//******************************
		//***       Pair Check       ***
		//******************************
		
		HashMap<Integer, ArrayList<Card>> cardMap = new HashMap<Integer, ArrayList<Card>>();
		
		Card highCard = null;
		
		boolean fourOfAKindFound = false;
		
		for(Card c : cards){
			
			// Get the high card in the hand
			
			if(highCard == null){
				highCard = c;
			} else if(c.value > highCard.value){
				highCard = c;
			}
			
			ArrayList<Card> currentValue = cardMap.get(c.value);
			
			
			// Map the value of cards to their card types
			if(currentValue == null){
				cardMap.put(c.value, new ArrayList<Card>());
				cardMap.get(c.value).add(c);
			} else {
				cardMap.get(c.value).add(c);
			}	
		}
		
		ArrayList<Hand> hands = new ArrayList<Hand>();
				
		for(Integer j : cardMap.keySet()){
			if(cardMap.get(j).size() == 4){
				FourOfAKind f = new FourOfAKind(cardMap.get(j).get(0), cardMap.get(j).get(1), cardMap.get(j).get(2), cardMap.get(j).get(3));
				hands.add(f);
				fourOfAKindFound = true;
				break;
			} else if(cardMap.get(j).size() == 3){
				ThreeOfAKind t = new ThreeOfAKind(cardMap.get(j).get(0), cardMap.get(j).get(1), cardMap.get(j).get(2));
				hands.add(t);
			} else if(cardMap.get(j).size() == 2){
				Pair p = new Pair(cardMap.get(j).get(0), cardMap.get(j).get(1));
				hands.add(p);
			}
			
		}
		
		//*************************
		//***  Full house check ***
		//*************************
		
		boolean fullHouseFound = false;
		
		ArrayList<ThreeOfAKind> threeOfAKindList = new ArrayList<ThreeOfAKind>();
		ArrayList<Pair> pairList = new ArrayList<Pair>();
		
		
		for(Hand h : hands){
			if(h instanceof ThreeOfAKind){
				threeOfAKindList.add((ThreeOfAKind) h);
			} else if(h instanceof Pair) {
				pairList.add((Pair) h);
			}	
		}
		
		if(threeOfAKindList.size() >= 1 ){
			// Check for two threeOfAKinds
			FullHouse fullHouse;
			if(threeOfAKindList.size() == 2){
				// Determine what kind of a full house you have given 2 ThreeOfAKinds
				fullHouseFound = true;
				
				int currentHighValue = threeOfAKindList.get(0).getHighCard().value;
				if(currentHighValue > threeOfAKindList.get(1).getHighCard().value){
					Pair p = new Pair(
							threeOfAKindList.get(1).getCards().get(0),
							threeOfAKindList.get(1).getCards().get(1)
							);
					fullHouse = new FullHouse(threeOfAKindList.get(0), p);
					hands.add(fullHouse);
					
				} else {
					Pair p = new Pair(
							threeOfAKindList.get(0).getCards().get(0),
							threeOfAKindList.get(0).getCards().get(1)
							);
					fullHouse = new FullHouse(threeOfAKindList.get(1), p);
					hands.add(fullHouse);
				}
			} else {
				//Check for pairs
				if(pairList.size() > 0){
					// Full house FOUND!
					fullHouseFound = true;
					
					if(pairList.size() == 2){
						// find the highest pair if there are two
						
						int currentHighValue = pairList.get(0).getHighCard().value;
						
						if(pairList.get(1).getHighCard().value > currentHighValue){
							fullHouse = new FullHouse(threeOfAKindList.get(0), pairList.get(1));
						} else {
							fullHouse = new FullHouse(threeOfAKindList.get(0), pairList.get(0));
						}
					} else {
						// create a full house with the only pair available
						fullHouse = new FullHouse(threeOfAKindList.get(0), pairList.get(0));
					}
					hands.add(fullHouse);
				}
			}
		}
		
		
		//*************************
		//***  Straights Check  ***
		//*************************
		
		cards.sort(new Comparator<Card>(){

			@Override
			public int compare(Card card1, Card card2) {							
				return card1.value - card2.value;
				
			}
		});
		
		ArrayList<Straight> straights = new ArrayList<Straight>();
		
		findStraights(cards, straights, 1, cards.get(0).value, 0, 0, false);
		
		//******************************
		//***  Straight Flush Check  ***
		//******************************
		
		StraightFlush straightFlush = null;
		
		if(straights.size() > 0){
			straightFlush = checkStraightFlush(straights);
		}
		
		if(straightFlush != null){
			hands.add(straightFlush);
		} else {
			Flush flush = checkFlush(cards);
			if(flush != null){
				hands.add(flush);
			}
		}
		
		//******************************
		//***     High Card Only     ***
		//******************************
		
		hands.add(new HighCard(HandUtil.findHighestCard(cards)));;
		
		
		//******************************
		//***   Find Highest Hand    ***
		//******************************
		
		Comparator<Hand> handComparator = new Comparator<Hand>(){

			@Override
			public int compare(Hand hand1, Hand hand2) {							
				return hand1.handRank - hand2.handRank;
				
			}
		};
		
		if(hands.size() == 1){
			return hands.get(0);
		} else {
			Hand currentHighestHand = hands.get(0);
			
			for(int i=1; i<hands.size(); i++){
				int compareResult = handComparator.compare(currentHighestHand, hands.get(i));
				
				if(compareResult < 0){
					currentHighestHand = hands.get(i);
				} else if(compareResult == 0){
					currentHighestHand = (currentHighestHand.getHighCard().value > hands.get(i).getHighCard().value) ? 
							currentHighestHand : hands.get(i);
					
				}
			}
			
			return currentHighestHand;
		}
	}
	
	private static StraightFlush checkStraightFlush(ArrayList<Straight> straights){
		
		ArrayList<StraightFlush> sf = new ArrayList<StraightFlush>();
		
		for(Straight s : straights){
			Flush f = checkFlush(s.getCards());
			
			if(f != null){
				sf.add(new StraightFlush(f.getCards()));
			}
			
		}
		
		if(sf.size()>0){
			
			int highest = 0;
			int index = 0;
			
			if(sf.size() == 1){
				return sf.get(0);
			} else {
			
				for(int i = 0; i < sf.size(); i++){
					if(sf.get(i).getHighCard().value > highest){
						highest = sf.get(i).getHighCard().value;
						index = i;
					}
				}
				
				
			}
			
			return sf.get(index);
		}
		
		return null;
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
	
	
	private static void findStraights(ArrayList<Card> cards, ArrayList<Straight> straights, int index, int previousValue, int sequenceCount, int highestSequenceIndex, boolean straightFound){
		
		// TODO recursively find all straights
		
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
			
			if(straightFound){
				Straight straight = new Straight(cards.get(highestSequenceIndex),
						cards.get(highestSequenceIndex-1),
						cards.get(highestSequenceIndex-2),
						cards.get(highestSequenceIndex-3),
						cards.get(highestSequenceIndex-4));
				
				straights.add(straight);
			} 
			
		} else {
		
			findStraights(
				cards, 
				straights,
				index + 1, 
				cards.get(index).value, 
				sequenceCount, 
				highestSequenceIndex, 
				straightFound
			);
		}
	
		 
	}
	
	

}













