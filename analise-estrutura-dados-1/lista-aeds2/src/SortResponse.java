public class SortResponse {
	public int interactions = 0;
	private int[] finalVector;

	public boolean incrementInteraction(){
		interactions++;
		return true;
	}

	public void setFinalVector(int[] vector){
		finalVector =vector.clone();
	}

	public int[] getFinalVector() {
		return finalVector;
	}

	public void printFinalVector(){
		for(int item:finalVector){
			System.out.println(item);
		}
	}
}
