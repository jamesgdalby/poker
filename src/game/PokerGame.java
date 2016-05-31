package game;

import java.util.ArrayList;

import cards.Card;
import hand.Hand;
import hand.HandUtil;
import player.Holding;
import player.Player;
import table.Board;
import table.Table;

public class PokerGame {
	
	public static String STATE_WAITING_FOR_PLAYERS_TO_JOIN = "waiting for players";
	public static String STATE_GET_READY = "get ready";
	public static String STATE_DEAL = "deal";
	public static String STATE_FLIP_CARD = "flip card";
	public static String STATE_CHECK_CARDS = "check cards";
	public static String STATE_WAIT_FOR_PLAYER = "wait for player";
	public static String STATE_PLAYER_ACTIONS = "player actions";
	public static String STATE_FIND_THE_WINNER = "find the winner";
	public static String STATE_END_GAME = "end game";
	
	
	private String currentState;
	private int cardCount;
	private Table table;
	
	public PokerGame(Table table){
		currentState = PokerGame.STATE_WAITING_FOR_PLAYERS_TO_JOIN;
		cardCount = 3;
		
		this.table = table;
		waitForPlayersToJoin();
	}
	
	public void getNextState(){
		if(currentState.equalsIgnoreCase(PokerGame.STATE_WAITING_FOR_PLAYERS_TO_JOIN))
		{
			currentState = PokerGame.STATE_GET_READY;
			getReadyToPlay();
		} else if(currentState.equalsIgnoreCase(PokerGame.STATE_GET_READY))
		{
			currentState = PokerGame.STATE_DEAL;
			dealTheCards();
		} else if(currentState.equalsIgnoreCase(PokerGame.STATE_DEAL))
		{
			currentState = PokerGame.STATE_WAIT_FOR_PLAYER;
			waitForPlayers();
		} else if(currentState.equalsIgnoreCase(PokerGame.STATE_WAIT_FOR_PLAYER))
		{
			if(isMoreCardsLeft()){
				// deal more cards
				currentState = PokerGame.STATE_PLAYER_ACTIONS;
				getPlayerActions();
			} else {
				// deal more cards
				currentState = PokerGame.STATE_FIND_THE_WINNER;
				findTheWinner();
			}
			
		} else if(currentState.equalsIgnoreCase(PokerGame.STATE_PLAYER_ACTIONS))
		{
			currentState = PokerGame.STATE_FLIP_CARD;
			flipCard();
		}
		else if(currentState.equalsIgnoreCase(PokerGame.STATE_FLIP_CARD))
		{
			currentState = PokerGame.STATE_WAIT_FOR_PLAYER;
			waitForPlayers();
		}
		else if(currentState.equalsIgnoreCase(PokerGame.STATE_FIND_THE_WINNER))
		{
			currentState = PokerGame.STATE_END_GAME;
			endGame();
		}
	}

	private void endGame() {
		// TODO Auto-generated method stub
		System.out.println("Game over.");
		
	}

	private void waitForPlayersToJoin() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for players to join.");
		
		if(table.getPlayerCount() < 2){
			int i = 1; 
			while(table.getPlayerCount() < 2){
				table.addPlayerToTable(new Player("Test", "Player " + i, 100), table.getNextSeatNum());
				i++;
			}
		}
		
		getNextState();
	}
	
	public Hand getHand(Player player, Board board){
		Holding h = player.getHolding();
		return HandUtil.findHand(h.getCards(), board.getCards());
	}
	
	

	private void findTheWinner() {
		// TODO Auto-generated method stub
		System.out.println("Finding the winner");
		getNextState();
	}

	private void getPlayerActions() {
		// TODO Auto-generated method stub
		System.out.println("Getting player actions.");
		getNextState();
	}
	
	private void flipCard(){
		System.out.println("Flipping card.");
		getNextState();
	}

	private boolean isMoreCardsLeft() {
		// TODO Auto-generated method stub
		cardCount--;
		if(cardCount > 0){
			return true;
		} 
		
		return false;
		
	}

	private void waitForPlayers() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for players");
		getNextState();
	}

	private void dealTheCards() {
		// TODO Auto-generated method stub
		System.out.println("Deal the cards");
		getNextState();
	}

	private void getReadyToPlay() {
		// TODO Auto-generated method stub
		System.out.println("Ready to play");
		getNextState();
	}
	
}
