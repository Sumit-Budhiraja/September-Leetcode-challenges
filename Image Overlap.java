class Solution {
       public int largestOverlap(int[][] A, int[][] B) {
           int n = A.length;
           int[][] t = new int[2*n+1][2*n+1];
           for(int i = 0;i < n;i++){
              for(int j = 0;j < n;j++){
                 for(int k = 0;k < n;k++){
                    for(int l = 0;l < n;l++){
                       t[k-i+n][l-j+n] += A[i][j] * B[k][l];
                    }
                 }
              }
           }
           int ret = 0;
           for(int[] row : t){
              for(int v : row){
                 ret = Math.max(ret, v);
              }
           }
           return ret;
       }
   }