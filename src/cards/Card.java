package cards;

public class Card {
	
	public String suit;
	public String rank;
	public int value;
	
	public Card(String suit, String rank, int value){
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}
	
	public String toString(){
		return rank + " of " + suit + "s\n"; 
	}

}
