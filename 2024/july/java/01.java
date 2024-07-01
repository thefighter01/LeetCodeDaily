class Solution {
    public boolean threeConsecutiveOdds(int[] a) {
        int n = a.length;
        for (int i = 0; i +2 < n; ++i){
            int x = a[i];
            int y = a[i+1];
            int z = a[i+2];
            if ((x & 1 )> 0 && (y & 1 ) > 0 && (z & 1 ) > 0) return true;
        }
        return false;
        
    }
}
