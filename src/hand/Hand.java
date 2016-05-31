package hand;

public class Hand {
	
	public static String HAND_HIGH_CARD = "highCard";
	public static String HAND_PAIR = "pair";
	public static String HAND_TWO_PAIR = "twoPair";
	public static String HAND_THREE_OF_A_KIND = "threeOfAKind";
	public static String STRAIGHT = "straight";
	public static String FLUSH = "flush";
	public static String FULL_HOUSE = "fullHouse";
	public static String FOUR_OF_A_KIND = "fourOfAKind";
	public static String STRAIGHT_FLUSH = "straightFlush";
	
	public String type;
	public int highValue;
	public Hand(String type, int highValue){
		this.type = type;
		this.highValue = highValue;
	}

}
