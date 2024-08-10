/**
 * @param {number[][]} grid
 * @return {number}
 */
var numMagicSquaresInside = function(grid) {
    function solve( rSt ,  cSt , rEnd ,cEnd ,  g){
        let mn = 3e3;
        let mx = 0;
        // sum the rows
        let mxNum = 0;
        let mnNum = mn;
        const f = new Map();
        for (let k = 0; k < 3; ++k){
            let curSum = 0;
            for (let i = cSt; i <= cEnd; ++i){
                curSum+= g[k+rSt][i];
                mxNum = Math.max(mxNum , g[k+rSt][i]);
                mnNum = Math.min(mnNum , g[k+rSt][i]);
                f.set(g[k+rSt][i] , true);
            }
            mn = Math.min(mn , curSum);
            mx = Math.max(mx , curSum);
        }
        if (f.size!= 9) return 0;

        // sum the cols
         for (let k = 0; k < 3; ++k){
            let curSum = 0;
            for (let i = rSt; i <= rEnd; ++i){
                curSum+= g[i][cSt+k];
                mxNum = Math.max(mxNum , g[i][cSt+k]);
                mnNum = Math.min(mnNum , g[i][cSt+k]);
            }
            mn = Math.min(mn , curSum);
            mx = Math.max(mx , curSum);
        }


        // sum the left diagonals
        let curSum = 0;
        for (let k = 0; k < 3; ++k){
            curSum+= g[k+rSt][k+cSt];
        }
        mn = Math.min(mn , curSum);
        mx = Math.max(mx , curSum);
        curSum = 0;
    
        for (let k = 0; k <3; ++k){
            curSum+= g[rEnd-k][cEnd-k];
        }
        mn = Math.min(mn , curSum);
        mx = Math.max(mx , curSum);
        return mn == mx && mxNum < 10 && mnNum == 1 ? 1 : 0;
    }
    
        let n = grid.length;
        let m = grid[0].length;
       
        let ans = 0;
        for (let i = 0; i + 2 < n; ++i){
            for (let j = 0; j +2 < m; ++j){
                ans+= solve(i , j , i+2 , j+2 , grid);
            }
        }
        return ans;

};
