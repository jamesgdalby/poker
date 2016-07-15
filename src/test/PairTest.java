package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hand.Hand;
import hand.HandUtil;
import hand.Pair;

import org.junit.Test;

import cards.Card;
import cards.CardInfo;
import cards.Deck;

public class PairTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		deck.createDeck();
		
		ArrayList<Card> playerCards =  new ArrayList<Card>();
		ArrayList<Card> boardCards =  new ArrayList<Card>();
		
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.FIVE, 15));
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.TWO, 2));
		
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.TWO, 2));
		boardCards.add(new Card(CardInfo.SPADE, CardInfo.THREE, 2));
		boardCards.add(new Card(CardInfo.HEART, CardInfo.KING, 2));
		boardCards.add(new Card(CardInfo.CLUB, CardInfo.JACK, 2));
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.EIGHT, 2));
		
		ArrayList allCards = new ArrayList<Card>();
		allCards.addAll(playerCards);
		allCards.addAll(boardCards);
		
		Hand h = HandUtil.getHand(allCards);
		System.out.println("The hand is " + h);
		assert(h instanceof Pair);
	}

}
