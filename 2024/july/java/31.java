class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int n = books.length;
        var dp = new int[n+1];

        for (int i = n-1; i >= 0; --i){
            int curSum =0;
            int mx = 0;
            dp[i] = (int)1e7;
            for (int k = i; k < n && curSum+ books[k][0] <= shelfWidth ; ++k){
                mx = Math.max(mx , books[k][1]);
                curSum+=books[k][0];
                dp[i] = Math.min(dp[i] , mx + dp[k+1]);
            }
        
        }
        return dp[0];
    }
}
