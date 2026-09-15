class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean [][] dp = new boolean[n+1][n+1];
        List<int [] > ranges = new ArrayList<>();
        for (int L = n-1; L >= 0; --L){
            for (int R = L; R < n; ++R){
                dp[L][R] = (s.charAt(L) == s.charAt(R) && (R - L < 2 || dp[L+1][R-1]));
                if (dp[L][R] && R -L+1 >=  k ) ranges.add(new int[]{L , R});
            }
        }

        Collections.sort(ranges , (x , y) -> Integer.compare(x[1] , y[1]));

        int sz = ranges.size();

        // corner case
        int ans = (sz == 0 ? 0 : 1);
        int [] preMax = new int[sz+5];
        preMax[0] = 1;
        for (int i = 1; i < sz; ++i){
            int curL = ranges.get(i)[0];

            int L = 0; int R = i-1;
            int idx = -1;
            while(L <= R){
                int md = (L + R) / 2;
                int curValue = ranges.get(md)[1];
                if (curValue < curL){
                    idx = md;
                    L = md + 1;
                }else {
                    R = md -1;
                }
            }
            preMax[i] = preMax[i-1];
            if (idx != -1){
                preMax[i] = Math.max(preMax[i] , 1 + preMax[idx]);
            }
            ans = Math.max(ans , preMax[i]);
        }
        return ans;
    }
}