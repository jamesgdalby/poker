package player;

public class PlayerInfo {
	
	public String firstName;
	public String lastName;
	public double funds;
	
	
	public PlayerInfo(String firstName, String lastName, double funds){
		this.firstName = firstName;
		this.lastName = lastName;
		this.funds = funds;
	}
	
	public PlayerInfo(){
		this.firstName = "none";
		this.lastName = "none";
		this.funds = 0;
	}

}
