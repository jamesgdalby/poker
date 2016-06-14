
public class RecursionExample {
	
	public RecursionExample(){
		countDown(10);
	}
	
	private boolean countDown(int counter){
		if(counter > 0){
			System.out.println("Counter: " + counter);
			counter --;
			countDown(counter);
		} 
		return true;
	}

}
