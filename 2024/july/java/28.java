class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        var dist = new int [2][n+1];
        PriorityQueue<int [] > q = new PriorityQueue<>((a , b)->(a[0] - b[0]));
        q.add(new int [] {0 , 1});
        for (int i = 0; i < 2; ++i) for (int j = 0; j < n+1; ++j) dist[i][j] = Integer.MAX_VALUE;
        dist[0][1] = 0;
        // state , node

        Map<Integer, List<Integer> > g = new HashMap<>();
        for (int [] e : edges){
            for (int i =  0; i < 2; ++i){
                g.computeIfAbsent(e[i] , value -> new ArrayList<Integer> ()).add(e[i ^ 1]);
            }
        }
        while(!q.isEmpty()){
            var v= q.poll();
            int dis = v[0];
            int node = v[1];

            if ((dis / change) % 2 == 1){
                dis = (dis / change + 1) * change + time;
            }else dis+= time;
            
            if (!g.containsKey(node)) continue;
            for (var ch : g.get(node)){
                if (dist[0][ch] > dis){
                    dist[1][ch] = dist[0][ch];
                    dist[0][ch] = dis;
                    q.offer(new int [] {dis , ch});
                }else if (dist[1][ch] > dis && dis != dist[0][ch]){
                    dist[1][ch] = dis;
                    q.offer(new int[] {dis , ch});
                }
            }
        }
        return dist[1][n];
    }
}
