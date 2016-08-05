package game;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static String STATE_NEED_SHUFFLE = "Need to shuffle";
	public static String READY_FOR_BLINDS = "ready for blinds";
	public static String STATE_READY_TO_DEAL = "ready to deal";
	
	
	private String currentState;
	
	// The number of cards played on the table
	private int cardCount;
	private Table table;
	private boolean isTesting = false;
	
	public PokerGame(Table table){
		init(table);		
	}
	
	public PokerGame(Table table, boolean isTesting){
		setIsTesting(isTesting);
		init(table);
	}
	
	private void init(Table table){
		cardCount = 3;
		this.table = table;
		startGame();
	}
	
	public void setIsTesting(boolean value){
		isTesting = value;
	}
	
	public void getNextState(){
		if(currentState.equalsIgnoreCase(PokerGame.STATE_WAITING_FOR_PLAYERS_TO_JOIN))
		{
			currentState = PokerGame.STATE_GET_READY;
			getReady();
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Waiting for players to join.");
		
		if(isTesting){
			if(table.getPlayerCount() < 2){
			int i = 1; 
			while(table.getPlayerCount() < 2){
					table.addPlayerToTable(new Player("Test", "Player " + i, 100), table.getNextSeatNum());
					i++;
				}
			}
			getNextState();
		} else {
			while(table.getPlayerCount() < 2){
				requestNewPlayer();
			}
			
			boolean allSet = false;
			
			while(!allSet){
				System.out.println("Would you like to add another player? Y/N");
				
				
				String answer = "";
				try {
					answer = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(answer.equalsIgnoreCase("Y")){
					requestNewPlayer();
				} else if(answer.equalsIgnoreCase("N")){
					allSet = true;
				}
			}
			
			getNextState();
					
		}
		
		
		
		
	}
	
	private void requestNewPlayer(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter player info.");
			System.out.println("First name: ");
			String firstName = br.readLine().trim();
			System.out.println("Last name: ");
			String lastName = br.readLine().trim();
			System.out.println("Funds: ");
			double funds = Double.parseDouble(br.readLine().trim());
			
			Player p = new Player(firstName, lastName, funds);
			table.addPlayerToTable(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startGame(){
		// All players accounted for, start the game.
		currentState = PokerGame.STATE_GET_READY;
		getReady();
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
		System.out.println("Shuffling the cards");
		table.deck.createDeck();
		table.deck.shuffleDeck();
	
		getBlinds();
		System.out.println("Deal the cards");
		getNextState();
	}
	
	private void getBlinds(){
		
	}

	private void getReady() {
		// TODO Auto-generated method stub
		System.out.println("Ready to play");
		getNextState();
	}
	
}
