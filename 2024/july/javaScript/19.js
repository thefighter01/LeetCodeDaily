/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var luckyNumbers  = function(a) {
    let n ;
    let m;
    let fm;
    function solve(a ,  c){
        let f = new Array(2);
        for (let i = 0; i < 2; ++i) f[i] = new Array(n).fill(0);
        // pre col
        let cur = a[0][c];
        for (let i = 0; i < n; ++i){
            cur = Math.max(cur , a[i][c]);
            f[0][i] = cur;
           
        }
        // suf col
        cur = a[n-1][c];
        for (let i = n-1; i >= 0; --i){
            cur = Math.max(cur , a[i][c]);
            f[1][i] = cur;
        }

        return f;
    }

    n = a.length;
    m = a[0].length;
    let ans = [];

        if (n ==1 && m == 1) {
            ans.push(a[0][0]);
            return ans;
        }
       
        fm = new Array(m);
        for (let i = 0; i < m; ++i){
            fm[i] = new Array(2);
            for (let j = 0;j < 2; ++j){
                fm[i][j] = new Array(n).fill(0);
            }
        }

        for (let i = 0; i < m; ++i) {
            fm[i] = solve(a , i);
        }
        for (let i = 0; i < n; ++i){
            let suf = new Array(m).fill(0);
            let cur = a[i][m-1];
            for (let j = m-1; j >= 0; --j){
                cur = Math.min(cur , a[i][j]);
                suf[j] = cur;
            }
            cur = 1e5+1;
            for (let j = 0; j < m; ++j){
                let oth = cur;
                if (j+1 < m) oth = Math.min(oth , suf[j+1]);
              
                if (a[i][j] < oth){
                    let no = 0;
                    if (i-1 >= 0) no = Math.max(no , fm[j][0][i-1]);
                    if (i+1 < n) no = Math.max(no , fm[j][1][i+1]);
                    if (a[i][j] > no) ans.push(a[i][j]);
                }
                cur = Math.min(cur , a[i][j]);
            }
        }
        return ans;
};
