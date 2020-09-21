class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] arr = new int[1001];
		int max = 0;

		for(int i=0; i<trips.length; i++){
			arr[trips[i][1]] += trips[i][0];
			arr[trips[i][2]] += -trips[i][0];
			max = Math.max(max, trips[i][2]);
		}

		if(arr[0]>capacity) return false;

		for(int i=1; i<=max; i++){
			arr[i] += arr[i-1];
			if(arr[i]>capacity) return false;
		} 

		return true;
	}
}