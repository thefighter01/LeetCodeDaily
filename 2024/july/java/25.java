class Solution {
    static final int mx = (int)5e4;
    public int[] sortArray(int[] nums) {
        var f = new int [2 * mx+1];
        for (var cur : nums) f[cur + mx]++;
        final int n = nums.length;
        var ans = new int[n];
        int k = 0;
        for (int i = -mx; i <= mx; ++i){
            final int sz = f[mx + i];
            for (int j = 0; j < sz; ++j) ans[k++] = i;
        }
        return ans;
        
    }
}
