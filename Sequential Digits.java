class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        String s = "123456789";
        for(int l = 2; l <= s.length(); l++) {
            for(int j = 0; j <= s.length() - l; j++) {
                int num = Integer.parseInt(s.substring(j, j + l));
                if(num > high) return result;
                if(num >= low) result.add(num);
            }
        }
        
        return result;
    }
}