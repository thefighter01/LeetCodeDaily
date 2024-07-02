class Solution {
    public int[] intersect(int[] a, int[] b) {
        int sz1 = a.length;
        int sz2 = b.length;
        int [] f1 = new int [1001];
        int [] f2 = new int[1001];
        for (int cur : a) f1[cur]++;
        for (int cur : b) f2[cur]++;

        ArrayList<Integer > ans = new ArrayList<>();
        for (int i = 0; i <= 1000; ++i){
            int cur = Math.min(f1[i] , f2[i]);
            for (int k = 0; k < cur; ++k) ans.add(i);
        }

        sz1 = ans.size();
        int [] aux = new int [sz1];
        for (int i = 0; i < sz1; ++i) aux[i] = ans.get(i);
        return aux;
        


    }
}
