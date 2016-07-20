package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hand.FullHouse;
import hand.Hand;
import hand.HandUtil;
import hand.Pair;
import hand.Straight;

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
		
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.TWO, CardInfo.TWO_VALUE));
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.THREE, CardInfo.THREE_VALUE));
		
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.FOUR, CardInfo.FOUR_VALUE));
		boardCards.add(new Card(CardInfo.SPADE, CardInfo.FIVE, CardInfo.FIVE_VALUE));
		boardCards.add(new Card(CardInfo.HEART, CardInfo.SIX, CardInfo.SIX_VALUE));
		boardCards.add(new Card(CardInfo.CLUB, CardInfo.JACK, CardInfo.JACK_VALUE));
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.JACK, CardInfo.JACK_VALUE));
		
		ArrayList allCards = new ArrayList<Card>();
		allCards.addAll(playerCards);
		allCards.addAll(boardCards);
		
		Hand h = HandUtil.getHand(allCards);
		System.out.println("The hand is " + h);
		assert(h instanceof Straight);
	}
	
	public static void main(String[] args){
		Deck deck = new Deck();
		deck.createDeck();
		
		ArrayList<Card> playerCards =  new ArrayList<Card>();
		ArrayList<Card> boardCards =  new ArrayList<Card>();
		
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.FIVE, CardInfo.FIVE_VALUE));
		playerCards.add(new Card(CardInfo.CLUB, CardInfo.TWO, CardInfo.TWO_VALUE));
		
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.TWO, CardInfo.TWO_VALUE));
		boardCards.add(new Card(CardInfo.SPADE, CardInfo.THREE, CardInfo.THREE_VALUE));
		boardCards.add(new Card(CardInfo.HEART, CardInfo.KING, CardInfo.KING_VALUE));
		boardCards.add(new Card(CardInfo.CLUB, CardInfo.JACK, CardInfo.JACK_VALUE));
		boardCards.add(new Card(CardInfo.DIAMOND, CardInfo.EIGHT, CardInfo.EIGHT_VALUE));
		
		ArrayList allCards = new ArrayList<Card>();
		allCards.addAll(playerCards);
		allCards.addAll(boardCards);
		
		Hand h = HandUtil.getHand(allCards);
		System.out.println("The hand is " + h);
	}

}
