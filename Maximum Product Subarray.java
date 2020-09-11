class Solution {
	public int maxProduct(int[] nums) {
		int n = nums.length;
		int result = nums[0];
		for (int i = 0; i < n; i++) {
			int product = 1;
			for (int j = i; j < n; j++) {
				product *= nums[j];
				result = Math.max(result, product);
			}
		}

		return result;
	}
}