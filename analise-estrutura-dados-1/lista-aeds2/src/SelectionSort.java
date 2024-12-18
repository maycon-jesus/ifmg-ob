public class SelectionSort {
	static SortResponse sort(int[] _vector) {
		SortResponse resp = new SortResponse();
		int[] vector = _vector.clone();

		for(int i=0; resp.incrementInteraction() && i<vector.length; i++) {
			int smallestIndex = i;
			int smallestValue = vector[i];
			for(int j=i+1; resp.incrementInteraction()&& j<vector.length; j++) {
				int currentValue = vector[j];
				if(resp.incrementInteraction() && currentValue < smallestValue) {
					smallestIndex = j;
					smallestValue = currentValue;
				}
			}

			int temp = smallestValue;
			vector[i]=smallestValue;
			vector[smallestIndex]=temp;
		}
		return resp;
	}
}
