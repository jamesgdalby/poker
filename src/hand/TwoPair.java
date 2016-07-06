package hand;

import cards.Card;

public class TwoPair extends Hand{
	
	private Card pair1Card1, pair1Card2, pair2Card1, pair2Card2;
	
	public TwoPair(Card pair1Card1, Card pair1Card2, Card pair2Card1, Card pair2Card2){
		this.pair1Card1 = pair1Card1;
		this.pair1Card2 = pair1Card2;
		this.pair2Card1 = pair2Card1;
		this.pair2Card2 = pair2Card2;
		this.handRank = 2;
	}
	
	public String toString(){
		return "Two pair hand: " + pair1Card1 + ", " + pair1Card2 + ", " + pair2Card1 + ", " + pair2Card2;
	}

}
