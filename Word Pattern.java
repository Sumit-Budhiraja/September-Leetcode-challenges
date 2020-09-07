class Solution {
    public boolean wordPattern(String pattern, String str) {
         String c[]=str.split(" ");
        HashMap<Character, String> map=new HashMap<>();
        
        if(pattern.length()!=c.length) //if pattern size != size of str, it's false
            return false;
        
      for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))){
                if(!map.containsValue(c[i])){
                map.put(pattern.charAt(i),c[i]);
                } 
                else{
                   map.put(pattern.charAt(i), "-99"); //put any value if the key is different but the value is same
                }
            }
        }
      
      
     
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.get(pattern.charAt(i)).equals(c[i]))
                return false;
        }
       return true;
    }
}