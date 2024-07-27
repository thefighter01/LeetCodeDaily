class Solution {
    private static long [][] f;
    private void floyed(){
       for (int k = 0; k < 26; ++k){
        for (int j = 0; j < 26; ++j){
            for (int i = 0; i < 26; ++i){
                f[i][j] = Math.min(f[i][j] , f[i][k] + f[k][j]);
            }
        }
       }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        f = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j){
                f[i][j] =(long)1e10+5;
            }
            f[i][i] = 0;
        }
        int sz = changed.length;
        for (int i = 0; i < sz; ++i){
            int from = original[i]-'a';
            int to = changed[i]-'a';
            f[from][to] = Math.min(f[from][to] , cost[i]);
        }
        floyed();
        sz = source.length();
        long ans = 0;
        for (int i = 0; i < sz; ++i){
            int from = source.charAt(i)-'a';
            int to = target.charAt(i)-'a';
            if (f[from][to] >= (long)1e10+5) return -1;
          
            ans+= f[from][to];
        }
        return ans;
    }
}
