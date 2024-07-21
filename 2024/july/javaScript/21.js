/**
 * @param {number} k
 * @param {number[][]} rowConditions
 * @param {number[][]} colConditions
 * @return {number[][]}
 */
var buildMatrix = function(k, row, col) {
        let q = [];
        // solve for rows
        let g = new Array(k+1);
        for (let i = 1; i <= k; ++i) g[i] = [];
        let deg = new Array(k+1).fill(0);
        for (const [a , b] of row){
            deg[b]++;
            g[a].push(b);

        }
        for (let i = 1; i <= k; ++i){
            if (deg[i] === 0){
                q.push(i);
            }
        }
        let ansRows = new Array(k+1).fill(0);
        let idx = 0;
        while(q.length){
            const node = q.shift();
            ansRows[node] = idx++;
            g[node].forEach(ch => {
                if (--deg[ch] === 0) q.push(ch);
            });
        }
        if (idx != k) {
            return [];
        }
        idx = 0;
        q = [];
        for (let i = 1; i <= k; ++i) {
            g[i] = [];
            deg[i] = 0;
        }
        // solve cols
        for (const [a , b] of col){
            deg[b]++;
            g[a].push(b);
        }
        for (let i = 1; i <= k; ++i){
            if (deg[i] === 0){
               q.push(i);
            }
        }
        let ans = new Array(k);
        for (let i = 0; i <k; ++i) ans[i] = new Array(k).fill(0);
          while(q.length){
            const node = q.shift();
            ans[ansRows[node]][idx++] = node;
            g[node].forEach(ch => {
                if (--deg[ch] === 0) q.push(ch);
            });
        }
        if(idx != k) {
           return [];
        }
        return ans;
};
