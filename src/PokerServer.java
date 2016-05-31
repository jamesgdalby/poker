import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import player.Player;
import player.PlayerInfo;
import table.Table;
import cards.Card;
import cards.CardInfo;
import money.Chip;
import money.ChipTypes;

public class PokerServer {
	
	private Table table;
	
	public PokerServer(){
		init();
	}
	
	private void init(){		
		table = new Table();
	}
	
	public void addPlayer(String firstName, String lastName, int cash, int position){
		table.addPlayerToTable(new Player(new PlayerInfo(firstName, lastName, cash)), position);
	}
	
	public void start(){
		table.startGame();
	}
	
	
	
	

}
