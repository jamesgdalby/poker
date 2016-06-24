package hand;

import java.util.ArrayList;

import cards.Card;

public class FullHouse extends Hand{
	
	public ThreeOfAKind threeOfAKind;
	public Pair pair;
	
	public FullHouse(ThreeOfAKind t, Pair p){
		this.threeOfAKind = t;
		this.pair = p;
	}
	
	@Override 
	public ArrayList<Card> getCards(){
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.addAll(threeOfAKind.getCards());
		cards.addAll(pair.getCards());
		return cards;
	}

}
