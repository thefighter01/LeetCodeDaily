/**
 * @param {number[]} rowSum
 * @param {number[]} colSum
 * @return {number[][]}
 */
var restoreMatrix = function(rowSum, colSum) {
  
        let n = rowSum.length;
        let m = colSum.length;
        var ans = new Array(n);
        for (let i = 0; i < n; ++i){
            ans[i] = new Array(m);
            for (let j = 0; j < m; ++j){
                ans[i][j] = Math.min(rowSum[i] , colSum[j]);
                rowSum[i]-=ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }
        return ans;
};
