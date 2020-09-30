class Solution {
    public int firstMissingPositive(int[] nums) {
		// Set<Integer> set = new HashSet();
		// for(int num : nums) set.add(num);
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 1;
        while(set.contains(i)) i++;
        return i;
    }
}