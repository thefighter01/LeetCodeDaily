class Solution {
    private int n;
    private int [][][] dp ;

    private int solveDp(int [] a){
        for (int i = 0; i <= n; ++i) dp[n][i][3] = 1;
        for (int i = n-1; i >= 0; --i){
            for(int lst = -1; lst < n; ++lst){
                for (int sz = 3; sz >= 0; --sz){
                    int ch1 = dp[i+1][lst+1][sz];

                    int ch2 = 0;
                    if ((lst == -1 || a[i] > a[lst]) && sz <= 2 ) {
                        ch2 = dp[i+1][i+1][sz +1];
                    }
                    dp[i][lst+1][sz] = ch1 + ch2;
                }
            }
        }
        return dp[0][0][0];
    }

    private int solve(int i , int lst , int sz , int [] a){
        if (i == n) return sz == 3 ? 1 : 0;

        if (dp[i][lst+1][sz] != -1) return dp[i][lst+1][sz];
        dp[i][lst+1][sz] = 0;

        int ch1 = solve(i+1 , lst , sz , a);

        int ch2 = 0;
        if (lst == -1 || (a[i] > a[lst] && sz <= 2) ) ch2 = solve(i+1 , i , sz +1 , a);
        return dp[i][lst+1][sz] = ch1 + ch2;
    }

    private void init(int v){
        dp = new int [n+1][n+1][4];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j <= n; ++j){
                for (int k = 0; k < 4; ++k){
                    dp[i][j][k] = v;
                }
            }
        }
    }
    public int numTeams(int[] rating) {
        n = rating.length;
        init(0);
        //int ans = solve(0 , -1 , 0 , rating);
        int ans = solveDp(rating);

        int[] reversedRating = Arrays.copyOf(rating, rating.length);
        for (int i = 0; i < n / 2; ++i) {
            int temp = reversedRating[i];
            reversedRating[i] = reversedRating[n - 1 - i];
            reversedRating[n - 1 - i] = temp;
        }

        init(0); // Re-initialize dp for the reversed array
       // ans += solve(0, -1, 0, reversedRating);
        ans+= solveDp(reversedRating);
        return ans;
    }
}
