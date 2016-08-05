package table;

import player.Player;

public class Seat {
	
	private Player player;
	public boolean hasDealerButton;
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
	
	
	public void removePlayer(){
		this.player = null;
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
