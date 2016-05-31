package table;

import player.Player;

public class Seat {
	
	private Player player;
	String seatID;
	
	
	public Seat(String seatID){
		this.seatID = seatID;
	}
	
	public boolean hasPlayer(){
		if (player == null){
			return false;
		} else {
			return true;
		}
	}
	
	public void addPlayer(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	@Override 
	public String toString(){
		String message = "Seat: " + seatID ;
		
		if(hasPlayer()){
			message += ", Player: " + player;
		}
		
		return message; 
	}
	
	

}
