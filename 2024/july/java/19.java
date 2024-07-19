class Solution {

    private int n ;
    private int m;
    private int [][][] fm;
    private int [][] solve(int [][] a , int c){
        int [][] f = new int[2][n];
        // pre col
        int cur = a[0][c];
        for (int i = 0; i < n; ++i){
            cur = Math.max(cur , a[i][c]);
            f[0][i] = cur;
           
        }
        // suf col
        cur = a[n-1][c];
        for (int i = n-1; i >= 0; --i){
            cur = Math.max(cur , a[i][c]);
            f[1][i] = cur;
        }

        return f;
    }
    public List<Integer> luckyNumbers (int[][] a) {
        n = a.length;
        m = a[0].length;
        List<Integer> ans = new ArrayList<>();

        if (n ==1 && m == 1) {
            ans.add(a[0][0]);
            return ans;
        }
       
        fm = new int [m][][];
        for (int i = 0; i < m; ++i) {
            fm[i] = solve(a , i);
        }
        for (int i = 0; i < n; ++i){
            var suf = new int[m];
            int cur = a[i][m-1];
            for (int j = m-1; j >= 0; --j){
                cur = Math.min(cur , a[i][j]);
                suf[j] = cur;
            }
            cur = (int)1e5+1;
            for (int j = 0; j < m; ++j){
                int oth = cur;
                if (j+1 < m) oth = Math.min(oth , suf[j+1]);
                
                if (a[i][j] < oth){
                    int no = 0;
                    if (i-1 >= 0) no = Math.max(no , fm[j][0][i-1]);
                    if (i+1 < n) no = Math.max(no , fm[j][1][i+1]);
                 
                    if (a[i][j] > no) ans.add(a[i][j]);
                }
                cur = Math.min(cur , a[i][j]);
            }
        }
        return ans;
    }
        
}
