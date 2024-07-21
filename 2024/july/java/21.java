class Solution {
    private void isNull(int x , ArrayList<Integer> [] g){
        if (g[x] == null) {
            g[x] = new ArrayList<>();
        }
    }
    public int[][] buildMatrix(int k, int[][] row, int[][] col) {
        Deque<Integer> q = new ArrayDeque<>();
        // solve for rows
        ArrayList<Integer> [] g = new ArrayList[k+1];
        for (int i = 1; i <= k; ++i) isNull(i , g);
        int [] deg = new int [k+1];
        for (var con : row){
            deg[con[1]]++;
            g[con[0]].add(con[1]);

        }
        for (int i = 1; i <= k; ++i){
            if (deg[i] == 0){
                q.addFirst(i);
            }
        }
        var ansRows = new int[k+1];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.removeFirst();
            ansRows[node] = idx++;
            for (int ch : g[node]){
                if (--deg[ch] == 0){
                    q.addFirst(ch);
                }
            }
        }
        if (idx != k) {
            return new int[0][0];
        }
        idx = 0;
        q.clear();
        for (int i = 1; i <= k; ++i) {
            g[i].clear();
            deg[i] = 0;
        }
        // solve cols
        for (var con : col){
            deg[con[1]]++;
            g[con[0]].add(con[1]);
        }
        for (int i = 1; i <= k; ++i){
            if (deg[i] == 0){
                q.addFirst(i);
            }
        }
        var ans = new int[k][k];
         while(!q.isEmpty()){
            int node = q.removeFirst();
            ans[ansRows[node]][idx++] = node;
            for (int ch : g[node]){
                if (--deg[ch] == 0){
                    q.addFirst(ch);
                }
            }
        }
        if(idx != k) {
            return new int [0][0];
        }
        return ans;


    }
}
