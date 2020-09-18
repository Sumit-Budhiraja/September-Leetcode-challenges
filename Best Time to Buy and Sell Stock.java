class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minSoFar = Math.min(minSoFar, price);
            maxProfit = Math.max(maxProfit, price - minSoFar);
        }

        return maxProfit;
    }
}