package player;

import table.Seat;

public class Player {
	
	private PlayerInfo info; 
	private Holding holding;
	private Seat seat;
	
	public Player(String firstName, String lastName, double funds){
		info = new PlayerInfo(firstName, lastName, funds);
	}
	
	public Player(){
		info = new PlayerInfo();
	}
	
	public Player(PlayerInfo info){
		this.info = info;
	}
	
	public Holding getHolding(){
		return holding;
	}
	
	public String toString(){
		return info.firstName + " " + info.lastName + ", $" + info.funds;
	}
	
	public void setSeat(Seat s){
		this.seat = s;
	}
	

}
