class Solution {
    public int minimumDeletions(String s) {
    int bCount = 0;
    final int n = s.length();
    var dp = new int[n+1];
    
   
    for (int i = 0; i < n; ++i){
        if (s.charAt(i) == 'a'){
            dp[i+1] = Math.min(dp[i]+1 , bCount);
        }else {
            dp[i+1] = dp[i];
            bCount++;
        }
    }
    return dp[n];
    }
}
