class Solution {
    class Pair {
        private int u;
        private int w;
        public int getW(){
            return this.w;
        }
        public int getU(){
            return this.u;
        }
        Pair (int u , int w){
            this.u = u;
            this.w = w;
        }
    }
    private ArrayList<Pair> [] g;
    private void addEdge(int u ,int v , int w){
        g[u].add(new Pair(v , w));
    }

    private int dijk(int node, int [] dist , int mxDist, int n){
        Comparator<Integer> comp = new Comparator<Integer> (){
            public int compare(Integer a , Integer b){
                return dist[a]- dist[b];
            }
        };

        PriorityQueue<Integer> q = new PriorityQueue<>(comp);
        q.add(node);
        int ans = 0;
        while(!q.isEmpty()){
            node = q.poll();
            for (var cur : g[node]){
                int ch = cur.getU();
                int w = cur.getW();
                if (dist[ch] > dist[node] + w){
                    dist[ch] = dist[node] + w;
                    if (dist[ch] <= mxDist) {
                        q.add(ch);
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dist[i] <= mxDist) ans++;
        }
        return ans;
    }
    public int findTheCity(int n, int[][] edges, int d) {
        g = new ArrayList[n];
        for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
        
        for (int [] e : edges){
            for (int i = 0; i < 2; ++i){
                addEdge(e[i] ,e[i ^ 1] , e[2]);
            }
        }
        int mx = n;
        int ans = 0;
        for (int i = 0; i < n; ++i){
            var f = new int [n];
            for (int k = 0; k < n;  ++k) f[k] = (int)1e7;
            f[i] = 0;
            int answer = dijk(i , f , d , n);
            if (answer <= mx){
                mx = answer;
                ans = i;
            }
        }
        return ans;
    }
}
