package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public ArrayList<String> ranks;
	public ArrayList<String> suits;
	public ArrayList<Card> cards;
	
	public void createDeck(){
		cards = new ArrayList<Card>();
		ranks = new ArrayList<String>();
		suits = new ArrayList<String>();
		
		// Create ranks
		
		
		ranks.add(CardInfo.TWO);
		ranks.add(CardInfo.THREE);
		ranks.add(CardInfo.FOUR);
		ranks.add(CardInfo.FIVE);
		ranks.add(CardInfo.SIX);
		ranks.add(CardInfo.SEVEN);
		ranks.add(CardInfo.EIGHT);
		ranks.add(CardInfo.NINE);
		ranks.add(CardInfo.TEN);
		ranks.add(CardInfo.JACK);
		ranks.add(CardInfo.QUEEN);
		ranks.add(CardInfo.KING);
		ranks.add(CardInfo.ACE);
		
		// Create suits
		
		suits.add(CardInfo.CLUB);
		suits.add(CardInfo.DIAMOND);
		suits.add(CardInfo.HEART);
		suits.add(CardInfo.SPADE);
		
		// Create the deck
		
		for(String s : suits){
			for(int i = 2; i < ranks.size(); i++){
				
			
				cards.add(new Card(s, ranks.get(i), i));
			}
		}
		
		shuffleDeck();
		
		//System.out.println(deck.toString());
		
	}
	
	public void shuffleDeck(){
		Collections.shuffle(cards);
		
		System.out.println("The deck is shuffled..." );//cards);
	}

}
