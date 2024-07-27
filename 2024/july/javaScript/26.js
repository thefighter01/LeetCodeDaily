/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} distanceThreshold
 * @return {number}
 */
var findTheCity = function(n, edges, d) {
    const dist = new Array(100);
    for (let i = 0; i < 100; ++i) {
        dist[i] = new Array(100).fill(1e7);
        dist[i][i] = 0;
    }
    function floyed() {
        for (let k = 0; k < n; ++k){
            for (let i = 0; i < n; ++i){
                for (let j = 0; j < n; ++j){
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                }
            }
        }
        
    };
        
       
        for (const [u , v , w] of edges){
            dist[u][v] = w;
            dist[v][u] = w;
        }
        floyed();


        let mx = n;
        let ans = 0;
        for (let i = 0; i < n; ++i){
            let answer = dist[i].filter((ele)=> ele <= d).length;
            if (answer <= mx){
                mx = answer;
                ans = i;
            }
        }
        return ans;
};
