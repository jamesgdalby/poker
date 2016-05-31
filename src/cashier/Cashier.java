package cashier;

import java.util.ArrayList;
import java.util.HashMap;

import money.Chip;
import money.ChipTypes;

public class Cashier {
	
	private HashMap<String, Double> chipValues;
	
	public void setChipValues(){
		chipValues = new HashMap<String, Double>();
		chipValues.put(ChipTypes.WHITE, 0.25d);
		chipValues.put(ChipTypes.YELLOW, 0.50d);
		chipValues.put(ChipTypes.BLUE, 1.0d);
		chipValues.put(ChipTypes.RED, 5.0d);
		chipValues.put(ChipTypes.GREEN, 25.0d);
		chipValues.put(ChipTypes.BLACK, 100.0d);
		
	}
	
	public ArrayList<Chip> getChips(double cash){
		ArrayList<Chip> chips = new ArrayList<Chip>();
		//
		return chips;
	}

}
