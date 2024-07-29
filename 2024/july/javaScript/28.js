/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} time
 * @param {number} change
 * @return {number}
 */
var secondMinimum = function(n, edges, time, change) {
        const dist = Array.from({length : 2} , () => new Array(n+1).fill( Number.MAX_SAFE_INTEGER));
        let q = new MinPriorityQueue({priority : a => a[0]});
        q.enqueue([0 , 1]);
        dist[0][1] = 0;
        // state , node
        let g = Array.from({length : n+1} , () => []);
       
        for (const e of edges){
            for (let i = 0 ; i < 2; ++i){
                g[e[i]].push(e[i ^ 1]);
            }
        }
        
        while(q.size()){
            let [dis , node] = q.dequeue().element;
            let times = Math.floor(dis / change);
            if (times % 2 == 1)
                dis = (times + 1) * change + time;
            else dis+= time;
          
            for (const ch of g[node]){
                if (dist[0][ch] > dis){
                    dist[1][ch] = dist[0][ch];
                    dist[0][ch] = dis;
                    q.enqueue([dis , ch]);
                }else if (dist[1][ch] > dis && dis != dist[0][ch]){
                    dist[1][ch] = dis;
                    q.enqueue([dis , ch]);
                }
            }
        }
        return dist[1][n];
};
