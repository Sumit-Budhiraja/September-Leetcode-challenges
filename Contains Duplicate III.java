class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(Math.abs(1L * nums[i] - nums[j]) <= t && j - i <= k)
                    return true;
            }
        }
        return false;
    }
}