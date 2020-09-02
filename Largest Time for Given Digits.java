class Solution {
    
    private boolean rearrange(int maxValue,int index,int[] a){
        int max = -1;
		
		// find the maximum number for the given index which should be less than equal
		// to maxValue
        for(int i = index; i<a.length;i++) if(a[i]<=maxValue && (max==-1 || a[max]<a[i])) max = i;
		// number not found
        if(max==-1) return false;
    
	// put the number to its correct index 
	// swap it put at correct position
        int temp = a[max];
        a[max] = a[index];
        a[index] = temp;
        return true;
    }
	
	
    
    public String largestTimeFromDigits(int[] a) {
        boolean res = (rearrange(2,0,a) && (a[0]==2 ? rearrange(3,1,a) : rearrange(9,1,a)) && rearrange(5,2,a) && rearrange(9,3,a)) || (rearrange(1,0,a) && rearrange(9,1,a) && rearrange(5,2,a) && rearrange(9,3,a));
        
        
        StringBuilder sb = new StringBuilder();
        
        if(!res) return sb.toString();
        
        return sb.append(String.valueOf(a[0]))
          .append(String.valueOf(a[1]))
          .append(':')
          .append(String.valueOf(a[2]))
          .append(String.valueOf(a[3])).toString();
    }
}