class Solution {
    private HashMap<String,Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
	//Hashmap for memoization
        memo=new HashMap<String,Boolean>();
	//We know that ,if string is empty ,return true
        memo.put("",true);
	//Start Depth-first-Search
        return recur(s,wordDict);
    }
    private boolean recur(String s,List<String> dictionary){
	//If given string is already computed,then return stored result
        if(memo.containsKey(s)) return memo.get(s);
	//Variable to store result
        boolean res=false;
	//For every word in Dictionary,check if the word is prefix of input string
        for(String word: dictionary){
            if(s.startsWith(word)){
			//If you find string can be broken ,then stop searching 
                if(recur(s.substring(word.length()),dictionary)){
                    res=true;
                    break;
                }
            }
        }
		//Store result to prevent same computations in future
        memo.put(s,res);
        return res;
    }
}