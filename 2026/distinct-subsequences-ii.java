class Solution {
    public int distinctSubseqII(String s) {
        final int mod = (int)1e9 + 7;
         int n = s.length();
        int [] dp = new int[n+1];
        dp [0] = 1;
        int [] last = new int[26];
        Arrays.fill(last , -1);

        /*
        when a dupplicate can happen ?
        it's about the subsequences that can be formed by adding the current character to the subsequences that created by the previous occurance of the same char
        
        
        */
       
        for (int i = 1; i <= n; ++i){
            int c = s.charAt(i-1)-'a';
            dp[i] = 2 * dp[i-1] % mod;

            if (last[c] != -1){
                dp[i] = (dp[i] - dp[last[c]] + mod) % mod;
            }

            last[c] = i -1;
        }
        
        return (dp[n] -1 + mod) % mod;
    }
}