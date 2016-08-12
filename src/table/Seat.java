package table;

import player.Player;

public class Seat {
	
	private Player player;
	private int seatID;
	
	
	public Seat(int seatID){
		this.seatID = seatID;
	}
	
	public int getSeatID(){
		return this.seatID;
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
		player.setSeat(this);
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

	public void postSmallBlind() {
		// TODO Auto-generated method stub
		
	}

	public void postBigBlind() {
		// TODO Auto-generated method stub
		
	}
	
	

}
