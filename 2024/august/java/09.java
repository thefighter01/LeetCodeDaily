class Solution {
    private int solve(int rSt , int cSt , int rEnd , int cEnd , int [][] g){
        int mn = (int)3e3;
        int mx = 0;
        // sum the rows
        int mxNum = 0;
        int mnNum = mn;
        HashMap<Integer, Boolean> f = new HashMap<>();
        for (int k = 0; k < 3; ++k){
            int curSum = 0;
            for (int i = cSt; i <= cEnd; ++i){
                curSum+= g[k+rSt][i];
                mxNum = Math.max(mxNum , g[k+rSt][i]);
                mnNum = Math.min(mnNum , g[k+rSt][i]);
                
                f.put(g[k+rSt][i] , true);
            }
            mn = Math.min(mn , curSum);
            mx = Math.max(mx , curSum);
        }
        if (f.size() != 9) return 0;

        // sum the cols
         for (int k = 0; k < 3; ++k){
            int curSum = 0;
            for (int i = rSt; i <= rEnd; ++i){
                curSum+= g[i][cSt+k];
                mxNum = Math.max(mxNum , g[i][cSt+k]);
                mnNum = Math.min(mnNum , g[i][cSt+k]);
            }
            mn = Math.min(mn , curSum);
            mx = Math.max(mx , curSum);
        }


        // sum the left diagonals
        int curSum = 0;
        for (int k = 0; k < 3; ++k){
            curSum+= g[k+rSt][k+cSt];
        }
        mn = Math.min(mn , curSum);
        mx = Math.max(mx , curSum);
        curSum = 0;
    
        for (int k = 0; k <3; ++k){
            curSum+= g[rEnd-k][cEnd-k];
        }
        mn = Math.min(mn , curSum);
        mx = Math.max(mx , curSum);
        return mn == mx && mxNum < 10 && mnNum == 1 ? 1 : 0;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        int ans = 0;
        for (int i = 0; i + 2 < n; ++i){
            for (int j = 0; j +2 < m; ++j){
                ans+= solve(i , j , i+2 , j+2 , grid);
            }
        }
        return ans;

        
    }
}
